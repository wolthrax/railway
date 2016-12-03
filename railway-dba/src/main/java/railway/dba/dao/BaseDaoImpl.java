package railway.dba.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T,PK>{
	
	private static BaseDaoImpl<?, ?> BaseDaoImpl;
	
	protected Connection connection;
	
	@SuppressWarnings("unused")
	private Class<T> clazz;

	private BaseDaoImpl() {
		super();
	}

	public static BaseDaoImpl<?, ?> getInstance(){
		if(BaseDaoImpl == null){
			BaseDaoImpl = new BaseDaoImpl<>();
			return BaseDaoImpl;
		}else return BaseDaoImpl;
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
