package cn.com.sinosoft.usercenter.web.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.sinosoft.usercenter.model.GeCustomer;
import cn.com.sinosoft.usercenter.service.CustomerService;
import cn.com.sinosoft.usercenter.util.JsonByGsonUtils;
import cn.com.sinosoft.usercenter.util.constants.UserConstants;
import cn.com.sinosoft.usercenter.web.security.constants.RoleConfig;

/**
 * 用户控制器
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

  private Logger log = Logger.getLogger(this.getClass());

  @Resource(name = "customerServiceImpl")
  private CustomerService customerService;

  /**
   * 进入登录页面
   * 
   * @param result
   * @return
   */
  @RequestMapping(value = "/login")
  public String login() {
    log.debug("进入登录页面");
    return "/user/login";
  }

  /**
   * 测试错误页面
   * 
   * @param request
   * @param reponse
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/error")
  public String errpr(HttpServletRequest request, HttpServletResponse reponse)
      throws Exception {
    throw new Exception();
  }

  @RequiresRoles(value = RoleConfig.USER)
  @RequestMapping(value = "/userindex")
  public String userIndex(HttpServletRequest request,
      HttpServletResponse reponse) throws Exception {
    return "userindex";
  }

  /**
   * 测试json
   * 
   * @param request
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/loginsubmit", method = RequestMethod.POST)
  public Map<String, Object> loginsubmit(GeCustomer user,
      HttpServletRequest request) {
    log.debug("进入loginsubmit");
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("flag", false);
    try {
      Subject subject = SecurityUtils.getSubject();
      // 身份验证
      subject.login(new UsernamePasswordToken(user.getCustomeraccount(), user
          .getPwd()));
      // 验证成功在Session中保存用户信息
      List<GeCustomer> list = customerService.getOneCustomersByName(request
          .getParameter("username"));
      if (list != null && list.size() > 0) {
        log.debug("-------" + list.size());
        final GeCustomer authUserInfo = list.get(0);
        request.getSession().setAttribute(UserConstants.LOGIN_USER,
            authUserInfo);
        map.put("flag", true);
        map.put("authUserInfo", authUserInfo);
      }
    } catch (AuthenticationException e) {
      e.printStackTrace();
    }
    return map;
  }
  
  /**
   * json2
   * @param user
   * @param request
   * @param response
   */
  @RequestMapping(value = "/loginsubmit2", method = RequestMethod.POST)
  public void loginsubmit2(GeCustomer user, HttpServletRequest request,
      HttpServletResponse response) {
    log.debug("进入loginsubmit2");
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("flag", false);
    List<GeCustomer> list = customerService.getOneCustomersByName(request
        .getParameter("username"));
    if (list != null && list.size() > 0) {
      log.debug("-------" + list.size());
      final GeCustomer authUserInfo = list.get(0);
      request.getSession().setAttribute(UserConstants.LOGIN_USER, authUserInfo);
      map.put("flag", true);
      map.put("authUserInfo", authUserInfo);
    }
    PrintWriter pw;
    try {
      pw = response.getWriter();
      response.setContentType("text/json;charset=UTF-8");
      pw.write(JsonByGsonUtils.mapToJsonObject(map));
      pw.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 登出
   * 
   * @param request
   * @return
   */
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpServletRequest request) {
    return "redirect:/user/login";
  }

}
