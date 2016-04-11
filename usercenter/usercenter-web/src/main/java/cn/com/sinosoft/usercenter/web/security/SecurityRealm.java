package cn.com.sinosoft.usercenter.web.security;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.com.sinosoft.usercenter.model.GeCustomer;
import cn.com.sinosoft.usercenter.service.CustomerService;
import cn.com.sinosoft.usercenter.web.security.constants.PermissionConfig;
import cn.com.sinosoft.usercenter.web.security.constants.RoleConfig;

/**
 * 用户身份验证,授权 Realm 组件
 * @author renlc
 * @e-mail:rlc0204@163.com
 * @Description:
 * @CreateDate:2016年3月31日
 */
//@Component(value = "securityRealm")
public class SecurityRealm extends AuthorizingRealm {

  Logger log = Logger.getLogger(this.getClass());

  @Resource
  private CustomerService customerService;

  /**
   * 权限检查
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(
      PrincipalCollection principals) {
    SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
    String username = String.valueOf(principals.getPrimaryPrincipal());

    log.debug(username);

    /*
     * 角色处理...以后要从表中读取
     */
    authorizationInfo.addRole(RoleConfig.USER);
    /*
     * 权限处理...也要从表中读取
     */
    authorizationInfo.addStringPermission(PermissionConfig.USER_CREATE);
    return authorizationInfo;
  }

  /**
   * 登录验证
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    String username = String.valueOf(token.getPrincipal());
    String password = new String((char[]) token.getCredentials());
    // 通过数据库进行验证
    GeCustomer record = new GeCustomer();
    record.setCustomername(username);
    record.setProvinces(password);
    try {
      final GeCustomer authentication = customerService.authentication(record);
      if (authentication == null) {
        throw new AuthenticationException("用户名或密码错误.");
      }
    } catch (Exception e) {
      log.error("登录验证发生未知错误", e.getCause());
      throw new AuthenticationException("未知错误：" + e.getMessage());
    }
    SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
        username, password, getName());
    return authenticationInfo;
  }

}
