package conn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	private String driver;
	private String url;
	private String user;
	private String password;
	private int maxConn;
	
	//싱글톤 패턴
	private static ConnectionFactory instance = new ConnectionFactory();
	
	public static ConnectionFactory getInstance() {
		if(instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}
	//싱글톤 패턴 끝 (ConnectionFactory.getInstance()해서 다른 클래스에서 객체를 꺼내서 가져갈 수 있음)

	
	private ConnectionFactory() {
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("src/db.properties"));
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			user = prop.getProperty("user");
			password = prop.getProperty("password");
			if (prop.getProperty("maxConn") != null) {
				maxConn = Integer.parseInt(prop.getProperty("maxConn"));
			}
			Class.forName(driver); //드라이버 로딩
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	//커넥션 가져오기
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, user, password);
		return conn;
	}

	public int getMaxConn() {
		return maxConn;
	}
	
}












