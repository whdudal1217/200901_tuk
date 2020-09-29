package mvc.simple;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController extends HttpServlet {
	//1단계: 요청이 겟인지 포스트인지 파악
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req,resp);
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//2단계: 요청파악
		String type = req.getParameter("type");
		System.out.println("type : " + type);
		//3단계 : 로직수행
		Object resultObject = null;
		if(type == null || type.equals("greeting")) {
			resultObject = "hi";
		}else if (type.equals("data")) {
			resultObject = new java.util.Date();
		}else {
			resultObject = "invalid type";
		}
		
		//4단계 : req, session에 결과 저장
		req.setAttribute("result", resultObject);
		
		//5단계 : 반환할 뷰로 포워딩
		RequestDispatcher dispatcher = req.getRequestDispatcher("/simpleView.jsp");
		dispatcher.forward(req, resp);
	}
}







