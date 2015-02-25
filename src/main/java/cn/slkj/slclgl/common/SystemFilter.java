package cn.slkj.slclgl.common;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import cn.slkj.slclgl.user.bean.User;

public class SystemFilter implements Filter {
	Logger logger = LoggerFactory.getLogger(SystemFilter.class);

	@SuppressWarnings("unused")
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		if (!(servletRequest instanceof HttpServletRequest)
				|| !(servletResponse instanceof HttpServletResponse)) {
			throw new ServletException("OncePerRequestFilter just supports HTTP requests");
		}
		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
		HttpSession session = httpRequest.getSession(true);
		StringBuffer url = httpRequest.getRequestURL();
//		String[] strs = ProsReader.getString("INDICATION_APP_NAME").split("\\|");
		String[] strs = null;
		if (strs != null && strs.length > 0) {
			for (String str : strs) {
				if (url.indexOf(str) >= 0) {
					filterChain.doFilter(servletRequest, servletResponse);
					return;
				}
			}
		}
		Object object = session.getAttribute(SessionConstants.SESSION_USER);
		User user = object == null ? null : (User) object;
		if (user == null) {
			boolean isAjaxRequest = isAjaxRequest(httpRequest);
			if (isAjaxRequest) {
				httpResponse.setCharacterEncoding("UTF-8");
				httpResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "您已经太长时间没有操作,请刷新页面");
			}
			httpResponse.sendRedirect("/login.jsp");
			return;
		}
		filterChain.doFilter(servletRequest, servletResponse);
		return;
	}

	/**
	 * 判断是否为Ajax请求 
	 * @param request HttpServletRequest   
	 * @return 是true, 否false
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		return request.getRequestURI().startsWith("/api");
		// String requestType = request.getHeader("X-Requested-With");
		// return requestType != null && requestType.equals("XMLHttpRequest");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void destroy() {

	}

 
}
