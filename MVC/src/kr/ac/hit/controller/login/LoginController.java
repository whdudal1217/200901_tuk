package kr.ac.hit.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.hit.web.servlet.mvc.Controller;

public class LoginController implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String viewPage = "/login/loginForm.do";
		return viewPage;
	}

	
}
