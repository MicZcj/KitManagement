package filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.*;

@WebFilter(filterName = "authorityFilter", urlPatterns = { "/*" }, initParams = {
		@WebInitParam(name = "encoding", value = "UTF-8"), @WebInitParam(name = "loginPage", value = "login.jsp"),
		@WebInitParam(name = "proLogin", value = "UserLogin.do") })
public class AuthorityFilter implements Filter {
	private FilterConfig config;

	// 实现初始化方法
	public void init(FilterConfig fConfig) throws ServletException {
		config = fConfig;
	}

	// 实现过滤方法
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 获取该过滤器的配置参数
		String encoding = config.getInitParameter("encoding");
		String loginPage = config.getInitParameter("loginPage");
		String proLogin = config.getInitParameter("proLogin");
		// 设置请求request的编码字符集
		request.setCharacterEncoding(encoding);
		HttpServletRequest hrequest = (HttpServletRequest) request;
		HttpSession session = hrequest.getSession(true);
		// 获得客户请求的页面
		String requestPath = hrequest.getServletPath();
		// 如果session作用域的user为null，表明没有登录
		// 即用户请求的既不是登录页面，也不是处理登录的页面
		if ((session.getAttribute("user") == null &&session.getAttribute("admin")==null)&& !requestPath.endsWith(loginPage) && !requestPath.endsWith(proLogin)
				&& !requestPath.contains("assets") && !requestPath.contains("login")&& !requestPath.contains("egister")) {
			// 转发到登录页面
			request.getRequestDispatcher(loginPage).forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	// 实现销毁方法
	public void destroy() {
		config = null;
	}
}
