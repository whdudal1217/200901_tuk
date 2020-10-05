package kr.ac.hit.web.servlet.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.hit.web.servlet.mvc.handler.UrlHandlerMapping;

public class DispatcherServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		String contextConfigLocation = getInitParameter("contextConfigLocation");
		String configFiltPath = getServletContext().getRealPath(contextConfigLocation);
		
		try {
			UrlHandlerMapping.init(configFiltPath);
		} catch (Exception e) {
			throw new ServletException();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String uri = req.getRequestURI(); //사용자가 요청한 유알아이
		System.out.println("-*-*-*- URI 확인 -*-*-*-");
		System.out.println(uri);
		
		if(uri.indexOf(req.getContextPath()) == 0) {
			//localhost:8080/rootcontext/member/add.do
			uri = uri.substring(req.getContextPath().length()); //루트컨텍스트 앞에 다 자르고 뒤에 오는 진짜 요청 /member/add.do같은 것만 잘라낼 예정
		}
		System.out.println(uri); //확인
		
		Controller controller = UrlHandlerMapping.getHandler(uri);
		if(controller != null) {
			String viewPage = null;
			
			try {
				viewPage = controller.process(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException();
			}
			if(viewPage != null) {
				if(viewPage.startsWith("redirect:")){
					viewPage = viewPage.substring("redirect:".length());
					resp.sendRedirect( req.getContextPath() + viewPage); //풀경로 + 뷰페이지
				}else {
					RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
					dispatcher.forward(req, resp);
				}
			}
		}else {
			resp.setStatus(HttpServletResponse.SC_NOT_FOUND); //sc_not_found = 404 에러
		}
	}
	
	
}



















