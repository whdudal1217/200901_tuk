package kr.ac.hit.web.servlet.mvc.handler;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import kr.ac.hit.web.servlet.mvc.Controller;

public class UrlHandlerMapping {

	//uri와 controller를 매핑한 정보 저장
	public static Map<String, Controller> handlerMap = new HashMap<String, Controller>();
	
	private UrlHandlerMapping() {}; //프라이빗객체생성자
	
	public static void init(String configFiltPath) throws Exception{
		Properties prop = new Properties();
		prop.load(new FileReader(configFiltPath));
		
		Iterator keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			String uri = (String) keyIter.next();
			String handlerClassName = prop.getProperty(uri);
			Class handlerClass = Class.forName(handlerClassName);
			Controller handler = (Controller) handlerClass.newInstance();
			handlerMap.put(uri, handler);
		}
	}

	public static Controller getHandler(String uri) {
		return handlerMap.get(uri);
	}
	
}
