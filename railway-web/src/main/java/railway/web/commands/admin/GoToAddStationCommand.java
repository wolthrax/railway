package railway.web.commands.admin;

import javax.servlet.http.HttpServletRequest;

import railway.entities.User;
import railway.entities.enums.UserRole;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class GoToAddStationCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("user");
		if(user != null)
			if(user.getRole() == UserRole.ADMIN)
				return RailwayProps.getProperty("page.admin.add_station");
		return RailwayProps.getProperty("page.index");
	}
}