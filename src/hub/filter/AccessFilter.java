package hub.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*用来检测直接访问JSP时候用户是否登录*/
public class AccessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("Filter execued");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        if (session.getAttribute("customer") == null && (request.getRequestURI().indexOf("percenter.jsp") != -1 || request.getRequestURI().indexOf("perinfo.jsp") != -1
        ||request.getRequestURI().indexOf("modifyImg.jsp")!=-1||request.getRequestURI().indexOf("modifyImgFail.jsp")!=-1)) {
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().print("<script> alert(\"请先登录!\"); window.location.href='login.jsp'</script>");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
