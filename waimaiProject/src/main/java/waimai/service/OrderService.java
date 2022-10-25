package waimai.service;

import waimai.entity.Order;
import waimai.utils.ResponseData;

import java.util.List;

/**
 * (Order)表服务接口
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
public interface OrderService {

    ResponseData queryByStatus(String status);
    /**
     * 通过ID查询单条数据
     *
     * @param oid 主键
     * @return 实例对象
     */
    Order queryById(Long oid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Order> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    ResponseData insert(Order order);

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    Order update(Order order);

    /**
     * 通过主键删除数据
     *
     * @param oid 主键
     * @return 是否成功
     */
    boolean deleteById(Long oid);
    ResponseData queryOpenidByOpenidAndOrderstate(String openid,String orderstate);
    List<Order> queryOrderByOrderstate(String orderstate);

}
