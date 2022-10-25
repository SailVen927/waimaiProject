package waimai.dao;

import waimai.entity.Image;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Image)表数据库访问层
 *
 * @author makejava
 * @since 2021-08-20 16:57:47
 */
public interface ImageDao {

    List<Image> queryByType(String type);
    /**
     * 通过ID查询单条数据
     *
     * @param imgid 主键
     * @return 实例对象
     */
    Image queryById(Long imgid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Image> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param image 实例对象
     * @return 对象列表
     */
    List<Image> queryAll(Image image);

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 影响行数
     */
    int insert(Image image);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Image> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Image> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Image> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Image> entities);

    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 影响行数
     */
    int update(Image image);

    /**
     * 通过主键删除数据
     *
     * @param imgid 主键
     * @return 影响行数
     */
    int deleteById(Long imgid);

}

