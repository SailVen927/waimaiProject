package waimai.entity;

import java.io.Serializable;

/**
 * (Restaurant)实体类
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
public class Restaurant implements Serializable {
    private static final long serialVersionUID = -99689620030176944L;

    private Long restid;

    private String restname;

    private String restaddress;

    private String restintroduce;

    private String restell;

    private String restype;

    private String restimgid;

    private String servicetime;

    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Long getRestid() {
        return restid;
    }

    public void setRestid(Long restid) {
        this.restid = restid;
    }

    public String getRestname() {
        return restname;
    }

    public void setRestname(String restname) {
        this.restname = restname;
    }

    public String getRestaddress() {
        return restaddress;
    }

    public void setRestaddress(String restaddress) {
        this.restaddress = restaddress;
    }

    public String getRestintroduce() {
        return restintroduce;
    }

    public void setRestintroduce(String restintroduce) {
        this.restintroduce = restintroduce;
    }

    public String getRestell() {
        return restell;
    }

    public void setRestell(String restell) {
        this.restell = restell;
    }

    public String getRestype() {
        return restype;
    }

    public void setRestype(String restype) {
        this.restype = restype;
    }

    public String getRestimgid() {
        return restimgid;
    }

    public void setRestimgid(String restimgid) {
        this.restimgid = restimgid;
    }

    public String getServicetime() {
        return servicetime;
    }

    public void setServicetime(String servicetime) {
        this.servicetime = servicetime;
    }

}
