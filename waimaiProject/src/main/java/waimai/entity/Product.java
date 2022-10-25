package waimai.entity;

import java.io.Serializable;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -99233853025138692L;

    private Long pid;

    private Long dishid;

    private Long restid;

    private Image image;

    private Dish dish;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public Long getDishid() {
        return dishid;
    }

    public void setDishid(Long dishid) {
        this.dishid = dishid;
    }

    public Long getRestid() {
        return restid;
    }

    public void setRestid(Long restid) {
        this.restid = restid;
    }

}
