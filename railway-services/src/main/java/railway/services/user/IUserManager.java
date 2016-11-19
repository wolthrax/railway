package railway.services.user;

import java.util.List;

import railway.entities.User;
import railway.entities.models.Credential;

public interface IUserManager {

	List<User> getAllUsers();
	User getUserById(long id);
	void addUser(User user);
	void updateUser(User user);
	long checkForUniqueness(String login);
	User authentication(Credential credential);
	
}
