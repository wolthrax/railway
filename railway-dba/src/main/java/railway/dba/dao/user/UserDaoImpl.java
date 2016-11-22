package railway.dba.dao.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import railway.dba.dao.BaseDaoImpl;
import railway.dba.enums.ColumnNames;
import railway.dba.utils.ConnectionPool;
import railway.entities.User;
import railway.entities.enums.UserRole;
import railway.entities.models.Credential;
import railway.utils.props.RailwayProps;

public class UserDaoImpl extends BaseDaoImpl<User, Long> implements IUserDao{

	public UserDaoImpl() {
		super(User.class);
	}
	
	@Override
	public List<User> getAll() throws SQLException{
		
		connection = ConnectionPool.getInstatce().getConnection();
		PreparedStatement statement = connection.prepareStatement(RailwayProps.getProperty("query.get_all_users"));
		ResultSet result = statement.executeQuery();
		
		List<User> userList = new ArrayList<>();
		
		while(result.next()){
			
			User user = new User();
			user.setId(result.getLong(ColumnNames.USER_ID.getColumnName()));
			user.setLogin(result.getString(ColumnNames.USER_LOGIN.getColumnName()));
			user.setPassword(result.getString(ColumnNames.USER_PASSWORD.getColumnName()));
			user.setName(result.getString(ColumnNames.USER_NAME.getColumnName()));
			user.setSurname(result.getString(ColumnNames.USER_SURNAME.getColumnName()));
			user.setEmail(result.getString(ColumnNames.USER_EMAIL.getColumnName()));
			user.setPhone(result.getString(ColumnNames.USER_PHONE.getColumnName()));
			user.setRole(UserRole.valueOf(result.getString(ColumnNames.USER_ROLE.getColumnName())));
			user.setMoney(result.getDouble(ColumnNames.USER_MONEY.getColumnName()));
			
			userList.add(user);
		}
		
		ConnectionPool.getInstatce().closeConnection(connection);
		return userList;
	}
	
	@Override
	public User get(Long PK) throws SQLException{
		
		connection = ConnectionPool.getInstatce().getConnection();
		PreparedStatement statement = connection.prepareStatement(RailwayProps.getProperty("query.get_user_by_id"));
		statement.setLong(1, PK);
		
		ResultSet result = statement.executeQuery();
		
		User user = null;
		if(result.next()){
			user = new User();
			user.setId(result.getLong(ColumnNames.USER_ID.getColumnName()));
			user.setLogin(result.getString(ColumnNames.USER_LOGIN.getColumnName()));
			user.setPassword(result.getString(ColumnNames.USER_PASSWORD.getColumnName()));
			user.setName(result.getString(ColumnNames.USER_NAME.getColumnName()));
			user.setSurname(result.getString(ColumnNames.USER_SURNAME.getColumnName()));
			user.setEmail(result.getString(ColumnNames.USER_EMAIL.getColumnName()));
			user.setPhone(result.getString(ColumnNames.USER_PHONE.getColumnName()));
			user.setRole(UserRole.valueOf(result.getString(ColumnNames.USER_ROLE.getColumnName())));
			user.setMoney(result.getDouble(ColumnNames.USER_MONEY.getColumnName()));
		}
		
		ConnectionPool.getInstatce().closeConnection(connection);
		
		return user;
	}
	
	@Override
	public Long add(User user) throws SQLException {
		
		connection = ConnectionPool.getInstatce().getConnection();
		PreparedStatement statement = connection.prepareStatement(RailwayProps.getProperty("query.add_user"),
				Statement.RETURN_GENERATED_KEYS);
		
		statement.setString(1, user.getLogin());
		statement.setString(2, user.getPassword());
		statement.setString(3, user.getName());
		statement.setString(4, user.getSurname());
		statement.setString(5, user.getEmail());
		statement.setString(6, user.getPhone());
		statement.setString(7, user.getRole().toString());
		statement.setDouble(8, user.getMoney());
		statement.executeUpdate();
		
		ResultSet result = statement.getGeneratedKeys();
		result.next();
		long id = result.getLong(1);
		
		connection.commit();
		ConnectionPool.getInstatce().closeConnection(connection);
		return id;	
	}
	
	@Override
	public void update(User updatedUser) throws SQLException {
		
		connection = ConnectionPool.getInstatce().getConnection();
		PreparedStatement statement = connection.prepareStatement(RailwayProps.getProperty("query.get_user_by_id"));
		statement.setLong(1, updatedUser.getId());
		
		ResultSet result = statement.executeQuery();
		result.next();
		
		User user = new User();
		user.setId(result.getLong(ColumnNames.USER_ID.getColumnName()));
		user.setLogin(result.getString(ColumnNames.USER_LOGIN.getColumnName()));
		user.setPassword(result.getString(ColumnNames.USER_PASSWORD.getColumnName()));
		user.setName(result.getString(ColumnNames.USER_NAME.getColumnName()));
		user.setSurname(result.getString(ColumnNames.USER_SURNAME.getColumnName()));
		user.setEmail(result.getString(ColumnNames.USER_EMAIL.getColumnName()));
		user.setPhone(result.getString(ColumnNames.USER_PHONE.getColumnName()));
		user.setRole(UserRole.valueOf(result.getString(ColumnNames.USER_ROLE.getColumnName())));
		user.setMoney(result.getDouble(ColumnNames.USER_MONEY.getColumnName()));
		
		if(updatedUser.getPassword() != null)
			user.setPassword(updatedUser.getPassword());
		if(updatedUser.getName() != null)
			user.setName(updatedUser.getName());
		if(updatedUser.getSurname() != null)
			user.setSurname(updatedUser.getSurname());
		if(updatedUser.getEmail() != null)	
			user.setEmail(updatedUser.getEmail());
		if(updatedUser.getPhone() != null)	
			user.setPhone(updatedUser.getPhone());
		if(updatedUser.getMoney() != 0)	
			user.setMoney(updatedUser.getMoney());
		
		statement.clearParameters();
		
		statement = connection.prepareStatement(RailwayProps.getProperty("query.update_user"));
		statement.setString(1, user.getPassword());
		statement.setString(2, user.getName());
		statement.setString(3, user.getSurname());
		statement.setString(4, user.getEmail());
		statement.setString(5, user.getPhone());
		statement.setDouble(6, user.getMoney());
		statement.setLong(7, user.getId());	
		statement.executeUpdate();
		
		connection.commit();
		ConnectionPool.getInstatce().closeConnection(connection);
	}

	@Override
	public long checkForUniqueness(String login) throws SQLException {
		
		connection = ConnectionPool.getInstatce().getConnection();
		
		PreparedStatement statement = connection.prepareStatement(RailwayProps.getProperty("query.check_for_uniqueness"));
		statement.setString(1, login);
		
		ResultSet result = statement.executeQuery();
		result.next();
		
		return result.getLong(1);
	}

	@Override
	public User authentication(Credential credential) throws SQLException {
		
		connection = ConnectionPool.getInstatce().getConnection();
		
		PreparedStatement statement = connection.prepareStatement(RailwayProps.getProperty("query.authentication"));
		statement.setString(1, credential.getLogin());
		statement.setString(2, credential.getPassword());
		
		ResultSet result = statement.executeQuery();
		
		User user = null;
		if(result.next()){
			user = new User();
			user.setId(result.getLong(ColumnNames.USER_ID.getColumnName()));
			user.setLogin(result.getString(ColumnNames.USER_LOGIN.getColumnName()));
			user.setPassword(result.getString(ColumnNames.USER_PASSWORD.getColumnName()));
			user.setName(result.getString(ColumnNames.USER_NAME.getColumnName()));
			user.setSurname(result.getString(ColumnNames.USER_SURNAME.getColumnName()));
			user.setEmail(result.getString(ColumnNames.USER_EMAIL.getColumnName()));
			user.setPhone(result.getString(ColumnNames.USER_PHONE.getColumnName()));
			user.setRole(UserRole.valueOf(result.getString(ColumnNames.USER_ROLE.getColumnName())));
			user.setMoney(result.getDouble(ColumnNames.USER_MONEY.getColumnName()));
		}
		
		ConnectionPool.getInstatce().closeConnection(connection);
		return user;
	}
}