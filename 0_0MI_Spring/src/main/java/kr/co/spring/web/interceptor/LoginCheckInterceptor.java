package kr.co.spring.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	//pre - 컨트롤러 호출 전, post - 컨트롤러 호출 후 , after - 뷰까지 처리가 끝난 후
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(true); //true 혹은 아무것도 없다 - 현재 세션이 있으면 그 세션을 가져오고 없으면 만들어서 가져옴
		if(session == null) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return false;
		}
		if(session.getAttribute("LOGIN_USER") == null) {
			response.sendRedirect(request.getContextPath() + "/login/loginForm");
			return false;
		}
		return true;
	}
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		super.postHandle(request, response, handler, modelAndView);
//	}
//	
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		super.afterCompletion(request, response, handler, ex);
//	}
	
}
