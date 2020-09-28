package conn;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

	private static Vector<Connection> pool = new Vector<>();

	// singletone Pattern
	private static ConnectionPool instance = new ConnectionPool();

	public static ConnectionPool getInstance() {
		if (instance == null) {
			instance = new ConnectionPool();
		}
		return instance;
	}

	private ConnectionPool() {

		try {
			initPool();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private synchronized void initPool() throws SQLException {
		destroyPool(); //혹시나 열려있을 커넥션을 닫고 시작
		
		ConnectionFactory factory = ConnectionFactory.getInstance();
		
		for (int i = 0; i < factory.getMaxConn(); i++) {
			pool.add(factory.getConnection());
		}

	}

	private synchronized void destroyPool() throws SQLException {
		for (Connection conn : pool) {
			conn.close();
		}
		pool.clear(); //벡터를 깨끗하게 비움
	}
	
	public synchronized Connection getConnection() throws InterruptedException {
		//커넥션이 없으면
		while (pool.size()==0) {
			wait();
		}
		//커넥션이 있으면
		Connection conn = pool.remove(pool.size()-1);
		System.out.println("pool size : " + pool.size());
		return conn;
	}
	
	public synchronized void releaseConnection(Connection conn) {
		pool.add(conn);
		System.out.println("pool size : " + pool.size());
		notifyAll();
	}

}




















