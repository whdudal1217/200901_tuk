package jdbc;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInit extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();
	}
	
	private void initConnectionPool() {
		try {
				String url = getInitParameter("jdbcUrl");
				String user = getInitParameter("dbUser");
				String password = getInitParameter("dbPass");
			/*
			 * String url =
			 * "jdbc:mysql://localhost:3306/jdbc_ex?serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8&useUnicode=true&allowPublicKeyRetrieval=true";
			 * String user = "root"; String password = "0_0MI1217";
			 */
				// 유저 정보를 주고 이 db의 커넥션 풀을 생성
				// 커넥션 풀에 커넥션을 생성할 ConnectionFactory 생성
				ConnectionFactory connFactory = new DriverManagerConnectionFactory(url, user, password);
				
				//poolableConnection을 생성할 ConnectionFactory 생성
				//풀을 생성을 하기 위한 객체
				PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connFactory, null);
				//커넥션이 유효한지 검사해주는 쿼리 select1이란 쿼리를 사용할 것
				poolableConnectionFactory.setValidationQuery("select 1");
				
				//커넥션 풀 설정정보 셋팅.
				GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
				poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L); //검사하는 주기 
				poolConfig.setTestWhileIdle(true); //풀에 보관한 커넥션이 유효한지 검사
				poolConfig.setMinIdle(4); 
				poolConfig.setMaxIdle(50);
				
				//커넥션 풀 생성 
				GenericObjectPool<PoolableConnection> connectionPool = 
						new GenericObjectPool<>(poolableConnectionFactory,poolConfig);
				//커넥션 풀을 생성할 때 풀 생성을 위한 객체를 만들어뒀던 풀러블커넥션팩토리 객체를 넘기고 , 풀 셋팅 정보도 같이 넘깁니다
				poolableConnectionFactory.setPool(connectionPool); //풀러블커넥션팩토리의 null 안에 다시 셋풀로 커넥션풀을 줌
				
				// 커넥션 풀을 제공하는 JDBC 드라이버 로딩
				Class.forName("org.apache.commons.dbcp2.PoolingDriver");
				PoolingDriver driver = (PoolingDriver) DriverManager.getDriver("jdbc:apache:commons:dbcp:");
				// 커넥션 풀 드라이버에 커넥션 풀을 등록
				String DBConn = getInitParameter("poolName");
				driver.registerPool(DBConn , connectionPool);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	private void loadJDBCDriver(){
		String driver = getInitParameter("jdbcdriver");
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드");
		} catch (ClassNotFoundException ex) {
			throw new RuntimeException("fail to load JDBC Driver", ex);
		}
	}
}
