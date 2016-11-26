package railway.web.commands.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import railway.entities.Train;
import railway.entities.User;
import railway.services.user.IUserManager;
import railway.services.user.UserManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class ShowAllTicketsCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		IUserManager userManager = new UserManagerImpl();
		
		User user = (User) request.getSession().getAttribute("user");
		
		List<Train> trainList = userManager.getAllTickets(user.getId());
		
		if(trainList.isEmpty()){
			request.setAttribute("message", RailwayProps.getProperty("mess.ticket.no_tickets"));
		} else request.setAttribute("trainList", trainList);
		
		return RailwayProps.getProperty("page.user.show_tickets");
	}
}
