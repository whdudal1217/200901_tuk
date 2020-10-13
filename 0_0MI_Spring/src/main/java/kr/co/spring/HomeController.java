package kr.co.spring;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	BasicDataSource dataSource;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy.MMMMM.dd GGG  hh:mm aaa");
		String formattedDate2 = dateFormat2.format(date);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate2 );
		
		return "home"; // /WEB-INF/views/home.jsp -> servlet-context.xml
	}
	// http://localhost:8080/spring/dbTest.do
	@RequestMapping(value = "/dbTest.do")
	public String dbTest(Locale locale, Model model) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = dataSource.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select mem_email from tb_member where mem_name='test2'");
			
			while (rs.next()) {
				model.addAttribute("mem_email", rs.getString("mem_email"));
				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) {
					conn.close();
				}
				if(stmt != null) {
					stmt.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
		return "dbTest"; // /WEB-INF/views/home.jsp -> servlet-context.xml
	}
	
}



















