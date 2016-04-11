package cn.com.sinosoft.usercenter.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageFilter extends BaseFilter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
    this.response = (HttpServletResponse) response;
    this.request = (HttpServletRequest) request;
    //do something
    //...
    //对于所有直接访问jsp、html的请求，全部转到首页
    this.response.sendRedirect("./");
  }
}
