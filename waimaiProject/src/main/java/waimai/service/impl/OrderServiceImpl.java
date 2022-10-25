package waimai.service.impl;

import waimai.entity.Order;
import waimai.dao.OrderDao;
import waimai.service.OrderService;
import org.springframework.stereotype.Service;
import waimai.utils.ResponseCode;
import waimai.utils.ResponseData;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * (Order)表服务实现类
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Override
    public ResponseData queryByStatus(String status) {
       try {
           return new ResponseData(this.orderDao.queryByStatus(status), ResponseCode.SUCCESS);
       }catch (Exception e){
           System.out.println(e);
           return new ResponseData(ResponseCode.FAIL);
       }

    }

    /**
     * 通过ID查询单条数据
     *
     * @param oid 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Long oid) {
        return this.orderDao.queryById(oid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        return this.orderDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public ResponseData insert(Order order) {
        try{
            //1.设置状态为0
            order.setOstatus("0");
            //2.设置当前时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            order.setOtime(sdf.format(new Date()));
            this.orderDao.insert(order);
            return new ResponseData(ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }

    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getOid());
    }

    /**
     * 通过主键删除数据
     *
     * @param oid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long oid) {
        return this.orderDao.deleteById(oid) > 0;
    }

    @Override
    public ResponseData queryOpenidByOpenidAndOrderstate(String openid, String orderstate) {

        try{
            Order order = new Order();
            order.setOpenid(openid);
            order.setOstatus(orderstate);

            List<Order> orders = orderDao.queryAll(order);

            return new ResponseData(orders,ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }

    }

    @Override
    public List<Order> queryOrderByOrderstate(String orderstate) {
        return orderDao.queryOrderByOrderstate(orderstate);
    }
}
