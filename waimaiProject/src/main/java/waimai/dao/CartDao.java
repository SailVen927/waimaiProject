package waimai.dao;

import waimai.entity.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Cart)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
public interface CartDao {

    /**
     * 通过ID查询单条数据
     *
     * @param cid 主键
     * @return 实例对象
     */
    Cart queryById(Long cid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Cart> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    List<Cart> showCart(@Param("restid") Long restid,@Param("dishid") Long dishid);

    List<Cart> showAllCart();

    void addCart(@Param("cid") Long cid,@Param("dishid") Long dishid);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param cart 实例对象
     * @return 对象列表
     */
    List<Cart> queryAll(Cart cart);

    /**
     * 新增数据
     *
     * @param cart 实例对象
     * @return 影响行数
     */
    int insert(Cart cart);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cart> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Cart> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cart> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Cart> entities);

    /**
     * 修改数据
     *
     * @param cart 实例对象
     * @return 影响行数
     */
    int update(Cart cart);

    /**
     * 通过主键删除数据
     *
     * @param cid 主键
     * @return 影响行数
     */
    int deleteById(Long cid);

}

