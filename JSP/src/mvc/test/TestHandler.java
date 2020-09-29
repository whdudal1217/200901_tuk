package mvc.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class TestHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setAttribute("test", "테스트중입니다");
		return "/WEB-INF/view/test.jsp"; 
	}

}
