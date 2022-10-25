package waimai.utils;

/**
 * 定义ResponseData中的信息
 */
public enum ResponseCode {
    SUCCESS("0","请求成功"),
    FAIL("9999","网络不稳定"),
    ERROR_1("1001","参数不能为空"),
    ERROR_2("1002","手机号已经注册"),
    ERROR_3("1003","登录异常"),
    ERROR_4("1004","账号或密码输入错误");

    private String code;

    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResponseCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
