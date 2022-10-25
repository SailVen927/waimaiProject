package waimai.service;

import waimai.entity.Image;
import waimai.utils.ResponseData;

import java.util.List;

/**
 * (Image)表服务接口
 *
 * @author makejava
 * @since 2021-08-20 16:57:48
 */
public interface ImageService {

    /**
     * 通过ID查询单条数据
     *
     * @param imgid 主键
     * @return 实例对象
     */
    Image queryById(Long imgid);
    ResponseData queryByType(String type);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Image> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    Image insert(Image image);

    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    Image update(Image image);

    /**
     * 通过主键删除数据
     *
     * @param imgid 主键
     * @return 是否成功
     */
    boolean deleteById(Long imgid);

}
