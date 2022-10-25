package waimai.entity;

import java.io.Serializable;

/**
 * (Image)实体类
 *
 * @author makejava
 * @since 2021-08-20 16:57:46
 */
public class Image implements Serializable {
    private static final long serialVersionUID = 801543491189922848L;

    private Long imgid;

    private String imgurl;

    private String imgtype;


    public Long getImgid() {
        return imgid;
    }

    public void setImgid(Long imgid) {
        this.imgid = imgid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getImgtype() {
        return imgtype;
    }

    public void setImgtype(String imgtype) {
        this.imgtype = imgtype;
    }

}
