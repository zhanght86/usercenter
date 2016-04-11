package cn.com.sinosoft.usercenter.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通用控制器
 **/
@Controller
public class CommonController {
  /**
   * 首页
   * 
   * @param request
   * @return
   */
  @RequestMapping("index")
  public String index(HttpServletRequest request) {
    return "index";
  }

  /**
   * 404页面
   * 
   * @param request
   * @return
   */
  @RequestMapping("404")
  public String fileNotFind(HttpServletRequest request) {
    return "404";
  }

  /**
   * 403页面
   * 
   * @param request
   * @return
   */
  @RequestMapping("403")
  public String forbidden(HttpServletRequest request) {
    return "403";
  }

  /**
   * 500
   * 
   * @param request
   * @return
   */
  @RequestMapping("500")
  public String serverError500(HttpServletRequest request) {
    return "500";
  }

  /**
   * 503
   * 
   * @param request
   * @return
   */
  @RequestMapping("503")
  public String serverError503(HttpServletRequest request) {
    return "503";
  }

}
