package waimai.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import waimai.entity.Order;
import waimai.service.OrderService;
import org.springframework.web.bind.annotation.*;
import waimai.service.UserService;
import waimai.utils.ResponseCode;
import waimai.utils.ResponseData;
import waimai.utils.StringUtils;

import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
@Api(tags = "订单接口")
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order selectOne(Long id) {
        return this.orderService.queryById(id);
    }

    @ApiOperation(value = "根据状态返回订单",notes = "输入String类型的状态，返回对应订单信息")
    @GetMapping("showOrder")
    public ResponseData showOrder(String status) {
        return this.orderService.queryByStatus(status);
    }

    @ApiOperation(value = "生成订单")
    @PostMapping("addOrder")
    public ResponseData addOrder(Order order,String token){
        System.out.println("order = "+order);
        System.out.println("token = "+token);
        String openid = userService.queryOpenidByToken(token);

        if(StringUtils.isNull(openid)){
            return new ResponseData(ResponseCode.FAIL);
        }

        System.out.println("获取到的openid = "+openid);
        order.setOpenid(openid);
        //2.调用保存
        return orderService.insert(order);
    }

    @ApiOperation(value = "根据状态返回订单")
    @GetMapping("queryOrderByType")
    public ResponseData queryOrderByType(String token,String orderstate){
        System.out.println("根据状态获取订单 token = "+token);
        System.out.println("根据状态获取订单 orderstate = "+orderstate);
        //1.根据token获取到openid
        String openid = userService.queryOpenidByToken(token);

        return orderService.queryOpenidByOpenidAndOrderstate(openid,orderstate );
    }


}
