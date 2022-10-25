package waimai.service.impl;

import waimai.entity.Resttype;
import waimai.dao.ResttypeDao;
import waimai.service.ResttypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Resttype)表服务实现类
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
@Service("resttypeService")
public class ResttypeServiceImpl implements ResttypeService {
    @Resource
    private ResttypeDao resttypeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param typeid 主键
     * @return 实例对象
     */
    @Override
    public Resttype queryById(Long typeid) {
        return this.resttypeDao.queryById(typeid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Resttype> queryAllByLimit(int offset, int limit) {
        return this.resttypeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param resttype 实例对象
     * @return 实例对象
     */
    @Override
    public Resttype insert(Resttype resttype) {
        this.resttypeDao.insert(resttype);
        return resttype;
    }

    /**
     * 修改数据
     *
     * @param resttype 实例对象
     * @return 实例对象
     */
    @Override
    public Resttype update(Resttype resttype) {
        this.resttypeDao.update(resttype);
        return this.queryById(resttype.getTypeid());
    }

    /**
     * 通过主键删除数据
     *
     * @param typeid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long typeid) {
        return this.resttypeDao.deleteById(typeid) > 0;
    }
}
