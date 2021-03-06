package railway.services.user;

import java.sql.SQLException;
import java.util.List;

import railway.dba.dao.IBaseDao;
import railway.dba.dao.user.IUserDao;
import railway.dba.dao.user.UserDaoImpl;
import railway.dba.utils.ConnectionPool;
import railway.entities.Train;
import railway.entities.User;
import railway.entities.enums.UserRole;
import railway.entities.models.Credential;
import railway.entities.models.InfoForTicketModel;
import railway.entities.models.UserModel;
import railway.utils.logger.RailwayLogger;

public class UserManagerImpl implements IUserManager{

	@Override
	public List<User> getAllUsers() {
		
		IBaseDao<User, Long> baseDao = UserDaoImpl.getInstance();
		
		List<User> userList = null;
		try {
			userList = baseDao.getAll();
		} catch (SQLException e) {
			RailwayLogger.logError(UserManagerImpl.class, e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(baseDao.getConnection());
		}
		
		return userList;
	}

	@Override
	public User getUserById(long id) {
		
		IBaseDao<User, Long> baseDao = UserDaoImpl.getInstance();
		
		User user = null;
		try {
			user = baseDao.get(id);
		} catch (SQLException e) {
			RailwayLogger.logError(UserManagerImpl.class, e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(baseDao.getConnection());
		}
		return user;
	}

	@Override
	public long addUser(UserModel userModel) {
		
		IBaseDao<User, Long> baseDao = UserDaoImpl.getInstance();
		
		User user = new User();
		user.setLogin(userModel.getLogin());
		user.setPassword(userModel.getPassword1());
		user.setName(userModel.getName());
		user.setSurname(userModel.getSurname());
		user.setEmail(userModel.getEmail());
		user.setPhone(userModel.getPhone());
		user.setRole(UserRole.USER);
		user.setMoney(0);
		
		try {
			long id = baseDao.add(user);
			return id;
		} catch (SQLException e) {
			RailwayLogger.logError(UserManagerImpl.class, e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(baseDao.getConnection());
			return -1;
		}
	}

	@Override
	public byte updateUser(UserModel userModel) {
		
		IBaseDao<User, Long> baseDao = UserDaoImpl.getInstance();
		
		try {
			User user = baseDao.get(userModel.getId());
			if(!userModel.getPassword1().equals(""))
				user.setPassword(userModel.getPassword1());
			
			if(!userModel.getName().equals(""))
				user.setName(userModel.getName());
			
			if(!userModel.getSurname().equals(""))
				user.setSurname(userModel.getSurname());
			
			if(!userModel.getEmail().equals(""))
				user.setEmail(userModel.getEmail());
			
			if(!userModel.getPhone().equals(""))
				user.setPhone(userModel.getPhone());
			
			if(!userModel.getMoney().equals(""))
				user.setMoney(Double.valueOf(userModel.getMoney()));
			
			baseDao.update(user);
			return 0;
		} catch (SQLException e) {
			RailwayLogger.logError(UserManagerImpl.class, e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(baseDao.getConnection());
			return -1;
		}
		
	}

	@Override
	public long checkForUniqueness(String login) {
		
		IUserDao userDao = UserDaoImpl.getInstance();
		
		long uniqueness = -1;
		try {
			uniqueness = userDao.checkForUniqueness(login);
		} catch (SQLException e) {
			RailwayLogger.logError(UserManagerImpl.class, e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(userDao.getConnection());
		}
		
		return uniqueness;
	}

	@Override
	public User authentication(Credential credential) {
		
		IUserDao userDao = UserDaoImpl.getInstance();
		User user = null;
		try {
			user = userDao.authentication(credential);
		} catch (SQLException e) {
			RailwayLogger.logError(UserManagerImpl.class, e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(userDao.getConnection());
		}
		
		return user;
	}

	@Override
	public int bookATicket(InfoForTicketModel infoForTicketModel) {
		
		IUserDao userDao = UserDaoImpl.getInstance();
		
		try {
			userDao.bookATicket(infoForTicketModel);
		} catch (SQLException e) {
			RailwayLogger.logError(UserManagerImpl.class, e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(userDao.getConnection());
			return -1;
		}
		return 0;
	}

	@Override
	public List<Train> getAllTickets(long userId) {
		IUserDao userDao = UserDaoImpl.getInstance();
		
		List<Train> trainList = null;
		
		try {
			trainList = userDao.getAllTickets(userId);
		} catch (SQLException e) {
			RailwayLogger.logError(UserManagerImpl.class, e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(userDao.getConnection());
		}
		return trainList;
	}
}