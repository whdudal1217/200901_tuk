package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

public class ControllerUsingFile extends HttpServlet{
	//<커맨드, 핸들러인스턴스> 매핑정보저장
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();
	
	//초기화
	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		//<param-value>/WEB-INF/commandHandler.properties</param-value>
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		try(FileReader fis = new FileReader(configFilePath)) {
			prop.load(fis);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName = prop.getProperty(command);
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				commandHandlerMap.put(command, handlerInstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String command = req.getParameter("cmd"); //hello, test
		CommandHandler handler = commandHandlerMap.get(command); //command가 hello면 mvc.hello.helloHandelr 객체가 handler에 저장됨
		if(handler == null) { //파라미터로 아무것도 안 들어온 경우
			handler = new NullHandler();
		}
		String viewPage = null;
		try {
			viewPage = handler.process(req, resp); //테스트핸들러, 헬로핸들러 각 자식의 메소드를 실행
		} catch (Exception e) {
			throw new ServletException(e);
		}
		if(viewPage != null) {
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, resp);
		}
	}
	
}















