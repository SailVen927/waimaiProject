package waimai.service.impl;

import waimai.entity.Restaurant;
import waimai.dao.RestaurantDao;
import waimai.query.LimitQuery;
import waimai.service.RestaurantService;
import org.springframework.stereotype.Service;
import waimai.utils.ResponseCode;
import waimai.utils.ResponseData;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Restaurant)表服务实现类
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {
    @Resource
    private RestaurantDao restaurantDao;

    /**
     * 通过ID查询单条数据
     *
     * @param restid 主键
     * @return 实例对象
     */
    @Override
    public Restaurant queryById(Long restid) {
        return this.restaurantDao.queryById(restid);
    }

    @Override
    public ResponseData queryRestInfoByKeyword(String keyword, String type) {

        try{
            List<Restaurant> projects = restaurantDao.queryRestInfoByKeyword("%"+keyword+"%", type);
            return new ResponseData(projects,ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }


    }
    /**
     * 查询多条数
     * @return 对象列表
     */
    @Override
    public ResponseData queryAllByLimit(LimitQuery limitQuery) {
        try{
            Long page = limitQuery.getPage();
            Long limit = limitQuery.getLimit();
            Long start = (page-1)*limit;
            List<Restaurant> restaurants = restaurantDao.queryAllByLimit(start, limit);
            //获取总条数
            Long count = restaurantDao.queryCount();
            return new ResponseData(restaurants, ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    @Override
    public ResponseData queryByType(LimitQuery limitQuery,String type) {
        try{
            //分页查询
            Long page = limitQuery.getPage();
            Long limit = limitQuery.getLimit();
            Long start = (page-1)*limit;
            System.out.println(start);
            System.out.println(limit);
            System.out.println(type);
            List<Restaurant> restaurants = this.restaurantDao.queryAllByType(start,limit,type);
            //获取数据库的总条数
            Long count = restaurantDao.queryCountByType(type);
            return new ResponseData(restaurants, ResponseCode.SUCCESS,count);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    /**
     * 新增数据
     *
     * @param restaurant 实例对象
     * @return 实例对象
     */
    @Override
    public Restaurant insert(Restaurant restaurant) {
        this.restaurantDao.insert(restaurant);
        return restaurant;
    }

    /**
     * 修改数据
     *
     * @param restaurant 实例对象
     * @return 实例对象
     */
    @Override
    public Restaurant update(Restaurant restaurant) {
        this.restaurantDao.update(restaurant);
        return this.queryById(restaurant.getRestid());
    }

    /**
     * 通过主键删除数据
     *
     * @param restid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long restid) {
        return this.restaurantDao.deleteById(restid) > 0;
    }
}
