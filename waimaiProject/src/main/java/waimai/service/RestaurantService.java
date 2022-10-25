package waimai.service;

import waimai.entity.Restaurant;
import waimai.query.LimitQuery;
import waimai.utils.ResponseData;

import java.util.List;

/**
 * (Restaurant)表服务接口
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
public interface RestaurantService {

    /**
     * 通过ID查询单条数据
     *
     * @param restid 主键
     * @return 实例对象
     */
    Restaurant queryById(Long restid);

    ResponseData queryRestInfoByKeyword(String keyword,String type);

    /**
     * 查询多条数据
     * @return 对象列表
     */
    ResponseData queryAllByLimit(LimitQuery limitQuery);

    /**
     *
     */
    ResponseData queryByType(LimitQuery limitQuery,String type);
    /**
     * 新增数据
     *
     * @param restaurant 实例对象
     * @return 实例对象
     */
    Restaurant insert(Restaurant restaurant);

    /**
     * 修改数据
     *
     * @param restaurant 实例对象
     * @return 实例对象
     */
    Restaurant update(Restaurant restaurant);

    /**
     * 通过主键删除数据
     *
     * @param restid 主键
     * @return 是否成功
     */
    boolean deleteById(Long restid);

}
