package railway.dba.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T,PK>{
	
	protected Connection connection;
	
	@SuppressWarnings("unused")
	private Class<T> clazz;

	public BaseDaoImpl() {
		super();
	}

	public BaseDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public List<T> getAll() throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(PK id) throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PK add(T object) throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T object) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(PK id) throws SQLException{
		// TODO Auto-generated method stub		
	}

	@Override
	public Connection getConnection() {
		return this.connection;
	}
}
