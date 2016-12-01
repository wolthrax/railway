package railway.services.user;

import java.util.List;

import railway.entities.Train;
import railway.entities.User;
import railway.entities.models.Credential;
import railway.entities.models.InfoForTicketModel;
import railway.entities.models.UserModel;

public interface IUserManager {

	List<User> getAllUsers();
	User getUserById(long id);
	long addUser(UserModel userModel);
	byte updateUser(UserModel userModel);
	long checkForUniqueness(String login);
	User authentication(Credential credential);
	int bookATicket(InfoForTicketModel infoForTicketModel);
	List<Train> getAllTickets(long userId);
	
}
