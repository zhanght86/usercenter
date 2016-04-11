package cn.com.sinosoft.usercenter.util.constants;

/**
 * 用户常量
 * @author renlc
 * @e-mail:rlc0204@163.com
 * @Description:
 * @CreateDate:2016年3月29日
 */
public final class UserConstants {
  
  /**
   * 不允许实例化
   */
  private UserConstants(){
    throw new AssertionError();
  }
  
  /**
   * 用户登录存放的key值
   */
  public static final String LOGIN_USER = "user_session";

}
