package waimai.dao;

import waimai.entity.Resttype;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Resttype)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
public interface ResttypeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param typeid 主键
     * @return 实例对象
     */
    Resttype queryById(Long typeid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Resttype> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param resttype 实例对象
     * @return 对象列表
     */
    List<Resttype> queryAll(Resttype resttype);

    /**
     * 新增数据
     *
     * @param resttype 实例对象
     * @return 影响行数
     */
    int insert(Resttype resttype);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Resttype> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Resttype> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Resttype> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Resttype> entities);

    /**
     * 修改数据
     *
     * @param resttype 实例对象
     * @return 影响行数
     */
    int update(Resttype resttype);

    /**
     * 通过主键删除数据
     *
     * @param typeid 主键
     * @return 影响行数
     */
    int deleteById(Long typeid);

}

