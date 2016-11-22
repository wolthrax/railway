package railway.web.commands.common;

import javax.servlet.http.HttpServletRequest;

import railway.entities.User;
import railway.entities.enums.UserRole;
import railway.services.user.IUserManager;
import railway.services.user.UserManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class RegistrationCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		String page = null;
		
		IUserManager userManager = new UserManagerImpl();
		
		if(userManager.checkForUniqueness(request.getParameter("login")) == 0){
			User user = new User();
			user.setLogin(request.getParameter("login"));
			user.setPassword(request.getParameter("password"));
			user.setName(request.getParameter("name"));
			user.setSurname(request.getParameter("surname"));
			user.setEmail(request.getParameter("email"));
			user.setPhone(request.getParameter("phone"));
			user.setRole(UserRole.USER);
			user.setMoney(0);
			
			userManager.addUser(user);
			page = RailwayProps.getProperty("page.index");
			
		}else {
			request.setAttribute("message2", "User with login " + "\"" + request.getParameter("login") + 
					"\"" + " alredy exists.");
			page = RailwayProps.getProperty("page.registration");;
		}
		
		return page;
	}
}
