package waimai.controller;

import com.google.thirdparty.publicsuffix.PublicSuffixPatterns;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import waimai.entity.Cart;
import waimai.service.CartService;
import org.springframework.web.bind.annotation.*;
import waimai.utils.ResponseData;

import javax.annotation.Resource;

/**
 * (Cart)表控制层
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
@Api(tags = "购物车接口")
@RestController
@RequestMapping("cart")
public class CartController {
    /**
     * 服务对象
     */
    @Resource
    private CartService cartService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Cart selectOne(Long id) {
        return this.cartService.queryById(id);
    }

    @ApiOperation(value = "添加商品进入购物车")
    @GetMapping("addCart")
    public ResponseData addCart(Long cid,Long dishid){
        return this.cartService.addCart(cid,dishid);
    }

    @ApiOperation(value = "查询已加入购物车信息")
    @GetMapping("showCart")
    public ResponseData showCart(Long restid,Long dishid){
        return this.cartService.showCart(restid,dishid);
    }

    @ApiOperation(value = "查询购物车内所有信息")
    @GetMapping("showAllCart")
    public ResponseData showAllCart(){
        return this.cartService.showAllCart();
    }

}
