package cn.com.sinosoft.usercenter.web.security.constants;

/**
 * 角色标识配置类, <br>
 * 使用:
 * <pre>
 * &#064;RequiresRoles(value = RoleConfig.ADMIN)
 * public String admin() {
 *   return &quot;拥有admin角色,能访问&quot;;
 * }
 * </pre>
 * 
 * @author renlc
 * @e-mail:rlc0204@163.com
 * @Description:
 * @CreateDate:2016年3月31日
 */
public final class RoleConfig {

  private RoleConfig() {
    throw new AssertionError();
  }

  /**
   * 普通后台管理员 标识
   */
  public static final String ADMIN = "admin";

  /**
   * 客户经理 标识
   */
  public static final String CONSULTANT = "consultant";

  /**
   * VIP客户 标识
   */
  public static final String VIP_USER = "vip_user";
  
  /**
   * 普通用户
   */
  public static final String USER = "user";

  /**
   * 商家 标识
   */
  public static final String MERCHANT = "merchant";

  /**
   * 添加更多...
   */

}
