package railway.dba.dao.user;

import java.sql.SQLException;

import railway.dba.dao.IBaseDao;
import railway.entities.User;
import railway.entities.models.Credential;

public interface IUserDao extends IBaseDao<User, Long>{

	long checkForUniqueness(String login) throws SQLException;
	User authentication(Credential credential) throws SQLException;
}
