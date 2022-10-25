package waimai.entity;

import java.io.Serializable;

/**
 * (Cart)实体类
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
public class Cart implements Serializable {
    private static final long serialVersionUID = 784410978355284079L;

    private Long cid;

    private Long pid;

    private Long ocount;

    private Product product;

    private  Dish dish;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getOcount() {
        return ocount;
    }

    public void setOcount(Long ocount) {
        this.ocount = ocount;
    }

}
