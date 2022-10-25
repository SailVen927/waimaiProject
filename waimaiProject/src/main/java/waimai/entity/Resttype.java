package waimai.entity;

import java.io.Serializable;

/**
 * (Resttype)实体类
 *
 * @author makejava
 * @since 2021-08-20 16:57:51
 */
public class Resttype implements Serializable {
    private static final long serialVersionUID = 122231240506291731L;

    private Long typeid;

    private String typename;


    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

}
