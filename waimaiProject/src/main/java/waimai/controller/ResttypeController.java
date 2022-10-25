package waimai.controller;

import waimai.entity.Resttype;
import waimai.service.ResttypeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Resttype)表控制层
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
@RestController
@RequestMapping("resttype")
public class ResttypeController {
    /**
     * 服务对象
     */
    @Resource
    private ResttypeService resttypeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Resttype selectOne(Long id) {
        return this.resttypeService.queryById(id);
    }

}
