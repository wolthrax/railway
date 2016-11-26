package railway.web.commands.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import railway.entities.User;
import railway.entities.enums.UserRole;
import railway.entities.models.Credential;
import railway.services.user.IUserManager;
import railway.services.user.UserManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class LoginCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		String page = null;
		
		IUserManager userManager = new UserManagerImpl();
		Credential credential = new Credential(request.getParameter("login"), 
				request.getParameter("password"));
		
		User user = userManager.authentication(credential);
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			session.setAttribute("userRole", user.getRole());
			
			if(user.getRole() == UserRole.ADMIN)
				page = RailwayProps.getProperty("page.admin.go_to_main");
			if(user.getRole() == UserRole.USER)
				page = RailwayProps.getProperty("page.user.go_to_main");
		}else {
			request.setAttribute("message", RailwayProps.getProperty("mess.error.credential"));
			page = RailwayProps.getProperty("page.index");
		}
		
		return page;
	}
}