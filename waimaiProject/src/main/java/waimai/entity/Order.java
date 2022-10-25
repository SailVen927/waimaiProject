package waimai.entity;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2021-08-20 16:57:50
 */
public class Order implements Serializable {
    private static final long serialVersionUID = -57647268121083300L;

    private Long oid;

    private Long oprice;

    private String otime;

    private String ostatus;

    private String openid;

    private Long cid;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOprice() {
        return oprice;
    }

    public void setOprice(Long oprice) {
        this.oprice = oprice;
    }

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    public String getOstatus() {
        return ostatus;
    }

    public void setOstatus(String ostatus) {
        this.ostatus = ostatus;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

}
