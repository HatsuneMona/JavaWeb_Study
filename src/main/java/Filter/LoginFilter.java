package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.server.Authentication.User;

/**
 * Created by Hatsune Mona on 2020/4/14. 初音萌奈什喵的最可爱了喵！
 */
@WebFilter(filterName = "LoginFilter", value = {
    "/QueryPages/teacherQue.jsp",
    "/RegPages/teacherReg.jsp",
    "/userReg.jsp"
})
public class LoginFilter implements Filter {
  
  public void destroy() {
  }
  
  public void doFilter(ServletRequest req, ServletResponse resp,
      FilterChain chain) throws ServletException, IOException {
    chain.doFilter(req, resp);
    
    HttpServletRequest httpServletRequest = (HttpServletRequest) req;
    User user = (User) httpServletRequest.getSession().getAttribute("loginUser");
    if (null != user) {
      //已登录，放行
      chain.doFilter(req, resp);
    } else {
      //未登录，提示登录
      httpServletRequest.setAttribute("msg", "您还没有登录，请登录后访问");
      httpServletRequest.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
  }
  
  public void init(FilterConfig config) throws ServletException {
    
  }
  
}
