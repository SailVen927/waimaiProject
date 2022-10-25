package waimai.dao;

import waimai.entity.Restaurant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Restaurant)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
public interface RestaurantDao {
    /**
     * 查询数量
     * @return
     */
    Long queryCount();

    List<Restaurant> queryRestInfoByKeyword(String keyword,String type);

    /**
     * 通过ID查询单条数据
     *
     * @param restid 主键
     * @return 实例对象
     */
    Restaurant queryById(Long restid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Restaurant> queryAllByLimit(@Param("offset") Long offset, @Param("limit") Long limit);

    Long queryCountByType(String type);

    /**
     *
     * @param offset
     * @param limit
     * @param type
     * @return
     */
    List<Restaurant> queryAllByType(@Param("offset") Long offset,@Param("limit") Long limit,@Param("type") String type);
    /**
     * 通过实体作为筛选条件查询
     *
     * @param restaurant 实例对象
     * @return 对象列表
     */
    List<Restaurant> queryAll(Restaurant restaurant);

    /**
     * 新增数据
     *
     * @param restaurant 实例对象
     * @return 影响行数
     */
    int insert(Restaurant restaurant);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Restaurant> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Restaurant> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Restaurant> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Restaurant> entities);

    /**
     * 修改数据
     *
     * @param restaurant 实例对象
     * @return 影响行数
     */
    int update(Restaurant restaurant);

    /**
     * 通过主键删除数据
     *
     * @param restid 主键
     * @return 影响行数
     */
    int deleteById(Long restid);

}

