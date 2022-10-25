package waimai.controller;

import waimai.entity.Dish;
import waimai.service.DishService;
import org.springframework.web.bind.annotation.*;
import waimai.utils.ResponseData;

import javax.annotation.Resource;

/**
 * (Dish)表控制层
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
@RestController
@RequestMapping("dish")
public class DishController {
    /**
     * 服务对象
     */
    @Resource
    private DishService dishService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Dish selectOne(Long id) {
        return this.dishService.queryById(id);
    }


}
