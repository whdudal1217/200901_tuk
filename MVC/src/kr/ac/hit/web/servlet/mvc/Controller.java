package kr.ac.hit.web.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	public String process (HttpServletRequest req, HttpServletResponse resp) throws Exception;
}
