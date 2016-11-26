package railway.dba.dao.user;

import java.sql.SQLException;
import java.util.List;

import railway.dba.dao.IBaseDao;
import railway.entities.Train;
import railway.entities.User;
import railway.entities.models.Credential;
import railway.entities.models.InfoForTicketModel;

public interface IUserDao extends IBaseDao<User, Long>{

	long checkForUniqueness(String login) throws SQLException;
	User authentication(Credential credential) throws SQLException;
	void bookATicket(InfoForTicketModel infoForTicketModel) throws SQLException;
	List<Train> getAllTickets(long idUser) throws SQLException;
}
