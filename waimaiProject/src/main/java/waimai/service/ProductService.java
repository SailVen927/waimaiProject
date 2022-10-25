package waimai.service;

import waimai.entity.Product;
import waimai.query.LimitQuery;
import waimai.utils.ResponseData;

import java.util.List;

/**
 * (Product)表服务接口
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
public interface ProductService {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Product queryById(Long pid);

    Product queryByDishId(Long dishid);

    /**
     * 查询对应商家的商品
     *
     * @return 对象列表
     */
    ResponseData queryAllByLimit(Long restid);

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    Product insert(Product product);

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    Product update(Product product);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    boolean deleteById(Long pid);

    ResponseData queryProInfoByKeyword(String keyword,String type);

    ResponseData queryProInfoByType(LimitQuery limitQuery,String type);

}
