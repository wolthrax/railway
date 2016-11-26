package railway.services.user;

import java.sql.SQLException;
import java.util.List;

import railway.dba.dao.IBaseDao;
import railway.dba.dao.user.IUserDao;
import railway.dba.dao.user.UserDaoImpl;
import railway.dba.utils.ConnectionPool;
import railway.entities.Train;
import railway.entities.User;
import railway.entities.models.Credential;
import railway.entities.models.InfoForTicketModel;
import railway.utils.logger.RailwayLogger;

public class UserManagerImpl implements IUserManager{

	@Override
	public List<User> getAllUsers() {
		
		IBaseDao<User, Long> userDao = new UserDaoImpl();
		
		List<User> userList = null;
		try {
			userList = userDao.getAll();
		} catch (SQLException e) {
			ConnectionPool.getInstatce().connectionRollback(userDao.getConnection());
		}
		
		return userList;
	}

	@Override
	public User getUserById(long id) {
		
		IBaseDao<User, Long> userDao = new UserDaoImpl();
		
		User user = null;
		try {
			user = userDao.get(id);
		} catch (SQLException e) {
			ConnectionPool.getInstatce().connectionRollback(userDao.getConnection());
		}
		return user;
	}

	@Override
	public long addUser(User user) {
		
		IBaseDao<User, Long> userDao = new UserDaoImpl();
		
		try {
			long id = userDao.add(user);
			return id;
		} catch (SQLException e) {
			RailwayLogger.logError(UserManagerImpl.class, e.getMessage());
			ConnectionPool.getInstatce().connectionRollback(userDao.getConnection());
			return -1;
		}
	}

	@Override
	public void updateUser(User user) {
		
		IBaseDao<User, Long> userDao = new UserDaoImpl();
		
		try {
			userDao.update(user);
		} catch (SQLException e) {
			ConnectionPool.getInstatce().connectionRollback(userDao.getConnection());
		}
		
	}

	@Override
	public long checkForUniqueness(String login) {
		
		IUserDao userDao = new UserDaoImpl();
		
		long uniqueness = -1;
		try {
			uniqueness = userDao.checkForUniqueness(login);
		} catch (SQLException e) {
			ConnectionPool.getInstatce().connectionRollback(userDao.getConnection());
		}
		
		return uniqueness;
	}

	@Override
	public User authentication(Credential credential) {
		
		IUserDao userDao = new UserDaoImpl();
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
		
		IUserDao userDao = new UserDaoImpl();
		
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
		IUserDao userDao = new UserDaoImpl();
		
		List<Train> trainList = null;
		
		try {
			trainList = userDao.getAllTickets(userId);
		} catch (SQLException e) {
			e.printStackTrace();
			RailwayLogger.logError(UserManagerImpl.class, e.getMessage());
		}
		return trainList;
	}
}