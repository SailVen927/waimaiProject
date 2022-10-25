package waimai.service.impl;

import waimai.entity.Product;
import waimai.dao.ProductDao;
import waimai.entity.Restaurant;
import waimai.query.LimitQuery;
import waimai.service.ProductService;
import org.springframework.stereotype.Service;
import waimai.utils.ResponseCode;
import waimai.utils.ResponseData;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Product)表服务实现类
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;

    /**
     * 通过ID查询单条数据
     *
     * @param pid 主键
     * @return 实例对象
     */
    @Override
    public Product queryById(Long pid) {
        return this.productDao.queryById(pid);
    }

    @Override
    public Product queryByDishId(Long dishid) {
        return this.productDao.queryById(dishid);
    }

    @Override
    public ResponseData queryAllByLimit(Long restid) {
        try {
//            //分页查询
//            Long page = limitQuery.getPage();
//            Long limit = limitQuery.getLimit();
//            Long start = (page-1)*limit;
//            System.out.println(restid);
            List<Product> restaurants = this.productDao.queryAllByRest(restid);
            return new ResponseData(restaurants, ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }


    @Override
    public ResponseData queryProInfoByKeyword(String keyword, String type) {

        try{
            List<Product> projects = productDao.queryProInfoByKeyword("%"+keyword+"%", type);
            return new ResponseData(projects,ResponseCode.SUCCESS);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }


    }

    @Override
    public ResponseData queryProInfoByType(LimitQuery limitQuery,String type){
        try{
            Long page = limitQuery.getPage();
            Long limit = limitQuery.getLimit();

            Long start = (page-1)*limit;  //从哪开始查询

            List<Product> projects = this.productDao.queryAllByLimitType(start, limit,type);

            //获取数据库的总条数
            Long count = productDao.queryCountByType(type);

            return new ResponseData(projects, ResponseCode.SUCCESS,count);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseData(ResponseCode.FAIL);
        }
    }


    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product insert(Product product) {
        this.productDao.insert(product);
        return product;
    }

    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product update(Product product) {
        this.productDao.update(product);
        return this.queryById(product.getPid());
    }

    /**
     * 通过主键删除数据
     *
     * @param pid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long pid) {
        return this.productDao.deleteById(pid) > 0;
    }
}
