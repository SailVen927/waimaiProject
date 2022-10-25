package waimai.entity;

import java.io.Serializable;

/**
 * (Dish)实体类
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
public class Dish implements Serializable {
    private static final long serialVersionUID = 439817630174378732L;

    private Long dishid;

    private String dishname;

    private Long dishprice;

    private String typename;

    private Long dishimgid;


    public Long getDishid() {
        return dishid;
    }

    public void setDishid(Long dishid) {
        this.dishid = dishid;
    }

    public String getDishname() {
        return dishname;
    }

    public void setDishname(String dishname) {
        this.dishname = dishname;
    }

    public Long getDishprice() {
        return dishprice;
    }

    public void setDishprice(Long dishprice) {
        this.dishprice = dishprice;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Long getDishimgid() {
        return dishimgid;
    }

    public void setDishimgid(Long dishimgid) {
        this.dishimgid = dishimgid;
    }

}
