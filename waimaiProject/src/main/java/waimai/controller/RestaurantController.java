package waimai.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import waimai.entity.Restaurant;
import waimai.query.LimitQuery;
import waimai.service.RestaurantService;
import org.springframework.web.bind.annotation.*;
import waimai.utils.ResponseData;

import javax.annotation.Resource;

/**
 * (Restaurant)表控制层
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
@Api(tags = "商家接口")
@RestController
@RequestMapping("restaurant")
public class RestaurantController {
    /**
     * 服务对象
     */
    @Resource
    private RestaurantService restaurantService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Restaurant selectOne(Long id) {
        return this.restaurantService.queryById(id);
    }

    @ApiOperation(value = "分页获取商家信息", notes = "传入limitQuery（包含page和limit属性），返回商家信息数组")
    @GetMapping("queryRestInfo")
    public ResponseData queryRestInfo(LimitQuery limitQuery){
        System.out.println("分页获取商家信息，limitQuery = "+limitQuery);
        return restaurantService.queryAllByLimit(limitQuery);
    }

    @ApiOperation(value = "根据分类获取商家信息",notes = "传入limitQuery（包含page和limit属性）和分类名称，返回对应商家信息")
    @GetMapping("queryRestByType")
    public  ResponseData queryRestByType(LimitQuery limitQuery,String type){
        System.out.println("分类分页获取商家信息，queryByType = "+type);
        return restaurantService.queryByType(limitQuery,type);
    }

    @ApiOperation(value = "根据关键字获取商家信息")
    @GetMapping("queryRestInfoByKeyword")
    public ResponseData queryRestInfoByKeyword(String keyword,String type){
        System.out.println(" keyword= "+keyword);
        System.out.println(" type= "+type);
        return restaurantService.queryRestInfoByKeyword(keyword,type );
    }

}
