package kr.ac.hit.controller.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.hit.web.servlet.mvc.Controller;

public class LogoutController implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("LOGIN_USER") != null){
			session.removeAttribute("LOGIN_USER");
		}
		String viewPage = "/login/loginForm.jsp";
		return viewPage;
	}

}
