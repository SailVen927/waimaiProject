package waimai.service;

import waimai.entity.Dish;

import java.util.List;

/**
 * (Dish)表服务接口
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
public interface DishService {

    /**
     * 通过ID查询单条数据
     *
     * @param dishid 主键
     * @return 实例对象
     */
    Dish queryById(Long dishid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Dish> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dish 实例对象
     * @return 实例对象
     */
    Dish insert(Dish dish);

    /**
     * 修改数据
     *
     * @param dish 实例对象
     * @return 实例对象
     */
    Dish update(Dish dish);

    /**
     * 通过主键删除数据
     *
     * @param dishid 主键
     * @return 是否成功
     */
    boolean deleteById(Long dishid);

}
