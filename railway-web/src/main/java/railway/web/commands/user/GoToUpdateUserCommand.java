package railway.web.commands.user;

import javax.servlet.http.HttpServletRequest;

import railway.entities.User;
import railway.entities.enums.UserRole;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class GoToUpdateUserCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("user");
		if(user != null)
			if(user.getRole() == UserRole.USER)
				return RailwayProps.getProperty("page.user.update");
		return RailwayProps.getProperty("page.index");
	}
}
