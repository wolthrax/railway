package railway.dba.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IBaseDao<T, PK extends Serializable> {
	
	List<T> getAll() throws SQLException;
	T get(PK id) throws SQLException;
	PK add(T object) throws SQLException;
	void update(T object) throws SQLException;
	void delete(PK id) throws SQLException;
	
	Connection getConnection();
}
