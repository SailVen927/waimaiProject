package waimai.service.impl;

import waimai.entity.Image;
import waimai.dao.ImageDao;
import waimai.service.ImageService;
import org.springframework.stereotype.Service;
import waimai.utils.ResponseCode;
import waimai.utils.ResponseData;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Image)表服务实现类
 *
 * @author makejava
 * @since 2021-08-20 16:57:48
 */
@Service("imageService")
public class ImageServiceImpl implements ImageService {
    @Resource
    private ImageDao imageDao;

    /**
     * 通过ID查询单条数据
     *
     * @param imgid 主键
     * @return 实例对象
     */
    @Override
    public Image queryById(Long imgid) {
        return this.imageDao.queryById(imgid);
    }

    @Override
    public ResponseData queryByType(String type) {
       try {
           return new ResponseData(this.imageDao.queryByType(type), ResponseCode.SUCCESS);
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
    public List<Image> queryAllByLimit(int offset, int limit) {
        return this.imageDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @Override
    public Image insert(Image image) {
        this.imageDao.insert(image);
        return image;
    }

    /**
     * 修改数据
     *
     * @param image 实例对象
     * @return 实例对象
     */
    @Override
    public Image update(Image image) {
        this.imageDao.update(image);
        return this.queryById(image.getImgid());
    }

    /**
     * 通过主键删除数据
     *
     * @param imgid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long imgid) {
        return this.imageDao.deleteById(imgid) > 0;
    }
}
