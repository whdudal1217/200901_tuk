import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss a");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html><head><title> 현재시간 서블릿 연습 </title></head>");
		out.println("<body>");
		out.println("현재 시간은  ");
		out.println(format.format(now));
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
