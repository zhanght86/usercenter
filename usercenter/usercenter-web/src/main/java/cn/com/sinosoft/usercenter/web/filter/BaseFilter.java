package cn.com.sinosoft.usercenter.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

public class BaseFilter implements Filter {

  protected Logger log = Logger.getLogger(this.getClass());
  protected HttpServletRequest request = null;
  protected HttpServletResponse response = null;
  protected HttpSession session = null;

  /**
   * 判断请求是否来自Ajax函数<br>
   * 
   * @param request
   * @return
   */
  public static boolean isAjaxRequest(HttpServletRequest request) {
    String requestType$1 = request.getHeader("X-Requested-With");
    String requestType$2 = request.getParameter("httpRequestType");
    boolean flag$1 = "XMLHttpRequest".equalsIgnoreCase(requestType$1);
    boolean flag$2 = "ajax".equalsIgnoreCase(requestType$2);
    return flag$1 || flag$2;
  }

  /**
   * 返回给浏览器指定类型
   * 
   * @param text
   * @param contentType
   */
  public void render(String text, String contentType) {
    try {
      this.response.setContentType(contentType);
      this.response.getWriter().write(text);
      this.response.getWriter().flush();
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  /**
   * 返回JSON格式数据
   * 
   * @param text
   */
  public void renderJson(String text) {
    render(text, "text/json;charset=UTF-8");
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
  }

  @Override
  public void destroy() {
  }

}
