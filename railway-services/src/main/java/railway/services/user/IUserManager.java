package railway.services.user;

import java.util.List;

import railway.entities.Train;
import railway.entities.User;
import railway.entities.models.Credential;
import railway.entities.models.InfoForTicketModel;

public interface IUserManager {

	List<User> getAllUsers();
	User getUserById(long id);
	long addUser(User user);
	void updateUser(User user);
	long checkForUniqueness(String login);
	User authentication(Credential credential);
	int bookATicket(InfoForTicketModel infoForTicketModel);
	List<Train> getAllTickets(long userId);
	
}
