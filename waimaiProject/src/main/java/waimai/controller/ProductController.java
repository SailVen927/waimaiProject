package waimai.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Tag;
import waimai.entity.Product;
import waimai.query.LimitQuery;
import waimai.service.ProductService;
import org.springframework.web.bind.annotation.*;
import waimai.utils.ResponseData;

import javax.annotation.Resource;

/**
 * (Product)表控制层
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
@Api(tags = "产品接口")
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Product selectOne(Long id) {
        return this.productService.queryById(id);
    }

    @ApiOperation(value = "分页获取商家对应商品")
    @GetMapping("queryDishbyRest")
    ResponseData queryDishbyRest (Long restid){
        System.out.println("分类分页获取商品信息，restid = "+restid);
        return productService.queryAllByLimit(restid);
    }

    @ApiOperation(value = "商品关键字查询")
    @GetMapping("queryProInfoByKeyword")
    public ResponseData queryProInfoByKeyword(String keyword,String type){
        System.out.println("keyword= "+keyword);
        System.out.println("type= "+type);

        return productService.queryProInfoByKeyword(keyword,type );
    }

    @ApiOperation(value = "商品分类查询")
    @GetMapping("queryProInfoByType")
    public ResponseData queryProInfoByType(LimitQuery limitQuery,String type){
        System.out.println("获取分类数据 limitQuery = "+limitQuery);
        System.out.println("type = "+type);
        return productService.queryProInfoByType(limitQuery,type);
    }
}
