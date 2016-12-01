package railway.web.commands.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import railway.entities.User;
import railway.entities.enums.UserRole;
import railway.entities.models.UserModel;
import railway.services.user.IUserManager;
import railway.services.user.UserManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;
import railway.web.validator.UserUpdateValidator;

public class UpdateUserCommnd extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(user != null)
			if(user.getRole() == UserRole.USER){
				IUserManager userManager = new UserManagerImpl();
				
				String money = "";
				
				if(request.getParameter("money") != null){
					money = request.getParameter("money");
				}
				UserModel userModel = new UserModel(user.getId(), 
						null, 
						request.getParameter("password1"), 
						request.getParameter("password2"),
						request.getParameter("name"), 
						request.getParameter("surname"), 
						request.getParameter("email"), 
						request.getParameter("phone"),
						money);
				
				UserUpdateValidator userValidator = new UserUpdateValidator();
				Map<String, String> errors = userValidator.getErrorMap(userModel);
				
				if(errors.isEmpty()){
					long status = userManager.updateUser(userModel);
					if(status == -1)
						request.setAttribute("message", RailwayProps.getProperty("mess.error.user.update"));
					else request.setAttribute("message", RailwayProps.getProperty("mess.user.update"));
				} else {
					request.setAttribute("errors", errors);
					if(money.equals(""))
						return RailwayProps.getProperty("page.user.update");
					System.out.println(errors.get("money"));
					return RailwayProps.getProperty("page.user.go_to_main");
				}
				return RailwayProps.getProperty("page.user.go_to_main");
			}
		return RailwayProps.getProperty("page.index");
	}
}
