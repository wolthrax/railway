package railway.dba.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
// c3p0
public class ConnectionPool{
	
	private static ConnectionPool connectionPool;
	private ComboPooledDataSource cpds;
	
	private ConnectionPool(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO com.mysql.jdbc.Driver not found ...
		}
		cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl(DBProperties.getProperty("db.url"));
		cpds.setUser(DBProperties.getProperty("db.user"));
		
		cpds.setPassword(DBProperties.getProperty("db.password"));
		
		cpds.setMinPoolSize(Integer.valueOf(DBProperties.getProperty("pool.min_pool_size")));
        cpds.setAcquireIncrement(Integer.valueOf(DBProperties.getProperty("pool.acquire_increment")));
        cpds.setMaxPoolSize(Integer.valueOf(DBProperties.getProperty("pool.max_pool_size")));
        cpds.setMaxStatements(Integer.valueOf(DBProperties.getProperty("pool.max_statements")));
        
	}
	
	public static ConnectionPool getInstatce(){
		if(connectionPool == null){
			connectionPool = new ConnectionPool();
			return connectionPool;
		} else return connectionPool;
	}
	
	public Connection getConnection(){
		Connection connection = null;
		try {
			connection = this.cpds.getConnection();
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			System.out.println("*****error");
			e.printStackTrace();
		}
		return connection;	
	}
	
	public void closeConnection(Connection connection){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void connectionRollback(Connection connection) {
		if(connection != null){
			try {
				connection.rollback();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
