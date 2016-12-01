package railway.web.commands.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import railway.entities.models.UserModel;
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
			
			UserModel userModel = new UserModel(1,
					request.getParameter("login"), 
					request.getParameter("password1"), 
					request.getParameter("password2"),
					request.getParameter("name"), 
					request.getParameter("surname"), 
					request.getParameter("email"), 
					request.getParameter("phone"), 
					"");
			
			UserValidator userValidator = new UserValidator();
			Map<String,String> errors = userValidator.getErrorMap(userModel);
			
			if(errors.isEmpty()){
				long id = userManager.addUser(userModel);
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
