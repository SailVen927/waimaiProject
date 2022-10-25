package waimai.service;

import waimai.entity.Resttype;

import java.util.List;

/**
 * (Resttype)表服务接口
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
public interface ResttypeService {

    /**
     * 通过ID查询单条数据
     *
     * @param typeid 主键
     * @return 实例对象
     */
    Resttype queryById(Long typeid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Resttype> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param resttype 实例对象
     * @return 实例对象
     */
    Resttype insert(Resttype resttype);

    /**
     * 修改数据
     *
     * @param resttype 实例对象
     * @return 实例对象
     */
    Resttype update(Resttype resttype);

    /**
     * 通过主键删除数据
     *
     * @param typeid 主键
     * @return 是否成功
     */
    boolean deleteById(Long typeid);

}
