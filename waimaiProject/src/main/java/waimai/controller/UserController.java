package waimai.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import waimai.entity.User;
import waimai.service.UserService;
import org.springframework.web.bind.annotation.*;
import waimai.utils.ResponseData;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id) {
        return this.userService.queryById(id);
    }

    @ApiOperation(value = "用户注册接口")
    @PostMapping("regUser")
    public ResponseData regUser(User user){
        System.out.println("注册 user = "+user);
        return userService.insert(user);
    }

    @ApiOperation(value = "用户登录接口")
    @PostMapping("userLogin")
    public ResponseData userLogin(String code,String password,String phone){
        System.out.println(" code = "+code);
        System.out.println(" password = "+password);
        System.out.println(" phone = "+phone);
        return userService.userLogin(code,password ,phone );
    }
}
