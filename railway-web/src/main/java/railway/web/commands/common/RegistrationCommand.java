package railway.web.commands.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import railway.entities.User;
import railway.entities.enums.UserRole;
import railway.services.user.IUserManager;
import railway.services.user.UserManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;
import railway.web.validator.UserValidator;

public class RegistrationCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
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
			user.setMoney(1000);
			
			UserValidator userValidator = new UserValidator();
			Map<String,String> errors = userValidator.getErrorMap(user);
			
			if(errors.isEmpty()){
				long id = userManager.addUser(user);
				if(!(id > 0)){
					request.setAttribute("message", RailwayProps.getProperty("mess.error.user.registration"));
				} else request.setAttribute("message", RailwayProps.getProperty("mess.user.registration"));
			} else {
				request.setAttribute("errors", errors);
				return RailwayProps.getProperty("page.registration");
			}
			
		}else {
			request.setAttribute("message", "User with login " + "\"" + request.getParameter("login") + 
					"\"" + " alredy exists.");
			return RailwayProps.getProperty("page.registration");
		}
		
		return RailwayProps.getProperty("page.index");
	}
}
