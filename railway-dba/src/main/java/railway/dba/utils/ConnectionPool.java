package railway.dba.utils;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import railway.utils.props.RailwayProps;
// c3p0
public class ConnectionPool{
	
	private static ConnectionPool connectionPool;
	private ComboPooledDataSource cpds;
	
	private ConnectionPool(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
		}
		cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl(RailwayProps.getProperty("db.url"));
		cpds.setUser(RailwayProps.getProperty("db.user"));
		
		cpds.setPassword(RailwayProps.getProperty("db.password"));
		
		cpds.setMinPoolSize(Integer.valueOf(RailwayProps.getProperty("db.pool.min_pool_size")));
        cpds.setAcquireIncrement(Integer.valueOf(RailwayProps.getProperty("db.pool.acquire_increment")));
        cpds.setMaxPoolSize(Integer.valueOf(RailwayProps.getProperty("db.pool.max_pool_size")));
        cpds.setMaxStatements(Integer.valueOf(RailwayProps.getProperty("db.pool.max_statements")));
        
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