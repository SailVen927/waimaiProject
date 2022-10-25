package waimai.service;

import waimai.entity.Cart;
import waimai.utils.ResponseData;

import java.util.List;

/**
 * (Cart)表服务接口
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
public interface CartService {

    /**
     * 通过ID查询单条数据
     *
     * @param cid 主键
     * @return 实例对象
     */
    Cart queryById(Long cid);

    /**
     * 添加商品进入购物车
     * @param cid
     * @param dishid
     * @return
     */
    ResponseData addCart(Long cid,Long dishid);

    /**
     * 查询已加入购物车信息
     * @param cid
     * @param dishid
     * @return
     */
    ResponseData showCart(Long cid,Long dishid);

    ResponseData showAllCart();

    List<Cart> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    Cart insert(Cart cart);

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    Cart update(Cart cart);

    /**
     * 通过主键删除数据
     *
     * @param cid 主键
     * @return 是否成功
     */
    boolean deleteById(Long cid);

}
