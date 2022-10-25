package waimai.utils;

public class StringUtils {


    public static final String APPID="";
    public static final String SECRET="";

    /**
     * 字符串的非空校验
     * @param str
     * @return
     */
    public static boolean isNull(String str){
        if(str==null){
            return true;
        }
        str = str.trim(); //去除空格
        if("".equals(str)){
            return true;
        }
        return false;
    }
}