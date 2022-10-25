package waimai.service.impl;

import waimai.dao.DishDao;
import waimai.dao.ProductDao;
import waimai.entity.Cart;
import waimai.dao.CartDao;
import waimai.entity.Dish;
import waimai.entity.Product;
import waimai.service.CartService;
import org.springframework.stereotype.Service;
import waimai.utils.ResponseCode;
import waimai.utils.ResponseData;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Cart)表服务实现类
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
@Service("cartService")
public class CartServiceImpl implements CartService {
    @Resource
    private CartDao cartDao;
    private ProductDao productDao;

    /**
     * 通过ID查询单条数据
     *
     * @param cid 主键
     * @return 实例对象
     */
    @Override
    public Cart queryById(Long cid) {
        return this.cartDao.queryById(cid);
    }

    @Override
    public ResponseData addCart(Long cid,Long dishid){
        try {
            cartDao.addCart(cid,dishid);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);

        }
    }

    @Override
    public ResponseData showCart(Long restid, Long dishid) {
        try {

            return new ResponseData(cartDao.showCart(restid,dishid),ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);

        }
    }

    public ResponseData showAllCart() {
        try {

            return new ResponseData(cartDao.showAllCart(),ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);

        }
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Cart> queryAllByLimit(int offset, int limit) {
        return this.cartDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public Cart insert(Cart cart) {
        this.cartDao.insert(cart);
        return cart;
    }

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 实例对象
     */
    @Override
    public Cart update(Cart cart) {
        this.cartDao.update(cart);
        return this.queryById(cart.getCid());
    }

    /**
     * 通过主键删除数据
     *
     * @param cid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long cid) {
        return this.cartDao.deleteById(cid) > 0;
    }
}
