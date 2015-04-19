package cn.slkj.slclgl.interceptor;

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

import org.springframework.ui.Model;

import cn.slkj.slclgl.user.bean.User;

/**
 * 登录验证session是否存在。页面拦截。
 */
public class LoginFilter implements Filter {
	public final static String SEESION_MEMBER = "userSession";
	public String[] allowUrls = { "/login.jsp", "/js/", "/css/", "/images/", "/user/login",
			"/common/", "/lib/", "/views" };

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		// 获得用户请求的URI
		String path = request.getRequestURI();
		String contextPath = request.getContextPath();
		String requestUrl = path.replace(contextPath, "");
		try {
			if (null != allowUrls && allowUrls.length >= 1) {
				for (String uri : allowUrls) {
					if (requestUrl.contains(uri)) {
						filterChain.doFilter(servletRequest, servletResponse);
						return;
					}
				}
			}
			User u = (User) session.getAttribute(SEESION_MEMBER);

			if (u == null) {
				response.sendRedirect(contextPath + "/login.jsp");
				return;
			} else {
				filterChain.doFilter(servletRequest, servletResponse);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
}