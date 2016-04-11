package cn.com.sinosoft.usercenter.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.sinosoft.usercenter.util.JsonByGsonUtils;
import cn.com.sinosoft.usercenter.util.constants.UserConstants;
import cn.com.sinosoft.usercenter.util.messages.UserMessage;

public class SessionFilter extends BaseFilter {

  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    this.request = (HttpServletRequest) request;
    this.response = (HttpServletResponse) response;
    this.session = this.request.getSession();
    Object login = session.getAttribute(UserConstants.LOGIN_USER);
    if (login == null) {
      if (super.isAjaxRequest(this.request)) {
        this.log.error("ajax请求:"
            + UserMessage.ERROR_AJAX_NOT_LOGIN.getLogInfo());
        String str = JsonByGsonUtils.arrToJson(new Object[][] {
            { "flag", false },
            { "message", UserMessage.ERROR_AJAX_NOT_LOGIN.getMessage() }, });
        this.log.debug(str);
        this.renderJson(str);
        return;
      } else {
        this.response.sendRedirect(this.request.getContextPath()
            + "/login");
        return;
      }
    }
    chain.doFilter(request, response);
  }
}
