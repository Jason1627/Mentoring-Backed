package entity;/*
 * @program: tensquare_parent
 * @Date: 2020-04-14 9:26
 * @Author: Jason
 * @Description:
 */

public class StatusCode {
    //成功
    public static final int Ok = 20000;
    //失败
    public static final int ERROR = 20001;
    //用户名或密码错误
    public static final int LOGINERROR = 20002;
    //权限不足
    public static final int ACCESSERROR = 20003;
    //远程调用失败
    public static final int REMOTEERROR = 20003;
    //重复操作
    public static final int REPERROR = 20005;
}
