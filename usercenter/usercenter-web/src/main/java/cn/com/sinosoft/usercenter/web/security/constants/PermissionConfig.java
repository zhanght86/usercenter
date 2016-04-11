package cn.com.sinosoft.usercenter.web.security.constants;

/**
 * 权限标识配置类 <br>
 * 
 * <pre>
 * &#064;RequiresPermissions(value = PermissionConfig.USER_CREATE)
 * public String create() {
 *   return &quot;拥有user:create权限,能访问&quot;;
 * }
 * </pre>
 * 
 * @author renlc
 * @e-mail:rlc0204@163.com
 * @Description:
 * @CreateDate:2016年3月31日
 */
public class PermissionConfig {

  /**
   * 用户新增权限 标识
   */
  public static final String USER_CREATE = "user:create";

  /**
   * 用户删除权限 标识
   */
  public static final String USER_DELETE = "user:delete";

  /**
   * 添加更多...
   */

}
