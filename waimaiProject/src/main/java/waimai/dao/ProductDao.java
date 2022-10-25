package waimai.dao;

import waimai.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Product)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
public interface ProductDao {

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    Product queryById(Long pid);

    Product queryByDishId(Long dishid);

    List<Product> queryAllByLimitType(@Param("offset")Long offset,@Param("limit")Long limit,@Param("type")String type);

    Long queryCountByType(String type);

    List<Product> queryProInfoByKeyword(@Param("keyword") String keyword, @Param("type") String type);

    List<Product> queryAllByRest(@Param("restid") Long restid);
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Product> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param product 实例对象
     * @return 对象列表
     */
    List<Product> queryAll(Product product);

    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 影响行数
     */
    int insert(Product product);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Product> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Product> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Product> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Product> entities);

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 影响行数
     */
    int update(Product product);

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 影响行数
     */
    int deleteById(Long pid);

}

