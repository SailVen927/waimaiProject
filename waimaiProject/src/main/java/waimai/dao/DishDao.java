package waimai.dao;

import waimai.entity.Dish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Dish)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
public interface DishDao {

    /**
     * 通过ID查询单条数据
     *
     * @param dishid 主键
     * @return 实例对象
     */
    Dish queryById(Long dishid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Dish> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dish 实例对象
     * @return 对象列表
     */
    List<Dish> queryAll(Dish dish);

    /**
     * 新增数据
     *
     * @param dish 实例对象
     * @return 影响行数
     */
    int insert(Dish dish);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dish> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Dish> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Dish> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Dish> entities);

    /**
     * 修改数据
     *
     * @param dish 实例对象
     * @return 影响行数
     */
    int update(Dish dish);

    /**
     * 通过主键删除数据
     *
     * @param dishid 主键
     * @return 影响行数
     */
    int deleteById(Long dishid);

}

