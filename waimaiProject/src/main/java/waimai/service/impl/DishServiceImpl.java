package waimai.service.impl;

import waimai.entity.Dish;
import waimai.dao.DishDao;
import waimai.service.DishService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Dish)表服务实现类
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
@Service("dishService")
public class DishServiceImpl implements DishService {
    @Resource
    private DishDao dishDao;

    /**
     * 通过ID查询单条数据
     *
     * @param dishid 主键
     * @return 实例对象
     */
    @Override
    public Dish queryById(Long dishid) {
        return this.dishDao.queryById(dishid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Dish> queryAllByLimit(int offset, int limit) {
        return this.dishDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dish 实例对象
     * @return 实例对象
     */
    @Override
    public Dish insert(Dish dish) {
        this.dishDao.insert(dish);
        return dish;
    }

    /**
     * 修改数据
     *
     * @param dish 实例对象
     * @return 实例对象
     */
    @Override
    public Dish update(Dish dish) {
        this.dishDao.update(dish);
        return this.queryById(dish.getDishid());
    }

    /**
     * 通过主键删除数据
     *
     * @param dishid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long dishid) {
        return this.dishDao.deleteById(dishid) > 0;
    }
}
