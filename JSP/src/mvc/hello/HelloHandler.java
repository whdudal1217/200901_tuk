package mvc.hello;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;

public class HelloHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setAttribute("hello", "안녕하시와요");
		return "/WEB-INF/view/hello.jsp"; 
		//jsp직접 실행이 아니라 컨트롤러 통해서 가는 거라서 web-inf상위 이름도 적어줘야함
	}

}
