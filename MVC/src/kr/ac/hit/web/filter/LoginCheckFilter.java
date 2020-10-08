package kr.ac.hit.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckFilter implements Filter {
	
	private static List<String> excludeURI = new ArrayList<String>();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		excludeURI.add("/login/login.jsp");
		excludeURI.add("/login/logForm.jsp");
		excludeURI.add("/login/logout.jsp");
		excludeURI.add("/login/login.do");
		excludeURI.add("/login/logForm.do");
		excludeURI.add("/login/logout.do");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("로그인 체크 필터");
		
		// session 은 httpServlet
		HttpServletRequest httpreq = (HttpServletRequest) request;
		HttpServletResponse httpresp = (HttpServletResponse) response;
		
		HttpSession session = httpreq.getSession();
		System.out.println("session : " + session);
		
		String url = httpreq.getRequestURI().substring(httpreq.getContextPath().length());
		System.out.println("loginCheckFilter :" + url);

		if (!excludeURI.contains(url) && session.getAttribute("LOGIN_USER") == null) {
			//httpresp.sendRedirect(httpreq.getContextPath()+"/login/loginForm.jsp");
			
			  RequestDispatcher dispatcher =
			  httpreq.getRequestDispatcher("/login/loginForm.jsp");
			  dispatcher.forward(httpreq, httpresp);
			 
			System.out.println("LoginCheckFilter");
		} else {
			System.out.println("session : " + session.getAttribute("LOGIN_USER"));
			chain.doFilter(request, response);
		}
	}
	@Override
	public void destroy() {
	}

}
