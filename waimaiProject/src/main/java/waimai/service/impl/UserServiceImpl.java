package waimai.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.crypto.hash.Md5Hash;
import waimai.entity.User;
import waimai.dao.UserDao;
import waimai.service.UserService;
import org.springframework.stereotype.Service;
import waimai.utils.HttpClientUtils;
import waimai.utils.ResponseCode;
import waimai.utils.ResponseData;
import waimai.utils.StringUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2021-08-12 09:29:39
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Long id) {
        return this.userDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<User> queryAllByLimit(int offset, int limit) {
        return this.userDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseData insert(User user) {
        String phone = user.getPhone();
        String password = user.getPassword();
        try{
            if(StringUtils.isNull(phone)||StringUtils.isNull(password)){
                //返回错误信息
                return new ResponseData(ResponseCode.ERROR_1);
            }

            User queryUser = userDao.queryUserByPhone(phone);
            if(queryUser!=null){
                return new ResponseData(ResponseCode.ERROR_2);
            }

            Md5Hash md5Hash = new Md5Hash(password,"waimai",10);
            System.out.println("加密的密码 = "+md5Hash);
            //保存
            user.setPassword(md5Hash.toString());
            this.userDao.insert(user);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getUserid());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public ResponseData userLogin(String code, String password, String phone) {
        //1.非空校验
        if(StringUtils.isNull(code)){
            return new ResponseData(ResponseCode.ERROR_3);
        }
        if(StringUtils.isNull(password)||StringUtils.isNull(phone)){
            return new ResponseData(ResponseCode.ERROR_1);
        }

        try{
            Md5Hash md5Hash = new Md5Hash(password,"waimai",10);
            password = md5Hash.toString(); //获取加密密码

            //查询user表，如果有数据，说明匹配
            Map<String,Object> map = new HashMap<>();
            map.put("phone", phone);
            map.put("password", password);
            User user = userDao.queryUserByMap(map);
            if(user==null){//说明没有查询到数据
                return new ResponseData(ResponseCode.ERROR_4);
            }

            //4.调用微信的登录接口   模拟http请求
            String httpUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+StringUtils.APPID+"&secret="+StringUtils.SECRET+"&js_code="+code+"&grant_type=authorization_code";
            String result = HttpClientUtils.doGet(httpUrl);
            System.out.println("result = "+result);

            JSONObject jsonResult = (JSONObject)JSON.parse(result);
            String session_key = (String)jsonResult.get("session_key");
            String openid = (String)jsonResult.get("openid");
            System.out.println("openid = "+openid+",session_key = "+session_key);

            Md5Hash md5 = new Md5Hash(openid,session_key,100);
            String token = md5.toString();

            //更新user表
            user.setToken(token);
            user.setSessionkey(session_key);
            user.setOpenid(openid);
            userDao.update(user);
            return new ResponseData(token,ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public String queryOpenidByToken(String token) {

        return userDao.queryOpenidByToken(token);
    }
}
