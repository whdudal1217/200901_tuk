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
			String uri = (String) keyIter.next();//uri = member/memberList.do
			String handlerClassName = prop.getProperty(uri); //handlerClassName = kr.ac.hit.member.controller.MemberListController
			Class handlerClass = Class.forName(handlerClassName);
			Controller handler = (Controller) handlerClass.newInstance(); //업캐스팅
			handlerMap.put(uri, handler);//member/memberList.do, MemberListController
		}
	}

	public static Controller getHandler(String uri) {
		return handlerMap.get(uri); //맵객체는 키값으로 밸류를 가져올 수 있음
		//member/memberList.do의 값 (controller)kr.ac.hit.member.controller.MemberListController를 가져옴
	}
	
}
