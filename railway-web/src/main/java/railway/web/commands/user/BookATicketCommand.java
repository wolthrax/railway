package railway.web.commands.user;

import javax.servlet.http.HttpServletRequest;

import railway.entities.User;
import railway.entities.models.InfoForTicketModel;
import railway.services.user.IUserManager;
import railway.services.user.UserManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class BookATicketCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		IUserManager userManager = new UserManagerImpl();
		
		User user = (User) request.getSession().getAttribute("user");
		user = userManager.getUserById(user.getId());
		
		InfoForTicketModel infoForTicketModel = new InfoForTicketModel(user.getId(), 
				Long.valueOf(request.getParameter("trainId")),
				Integer.valueOf(request.getParameter("trainPlaces")),
				Double.valueOf(request.getParameter("trainPrice")));
		
		if(user.getMoney() > Double.valueOf(request.getParameter("trainPrice"))){
			
			if(Integer.valueOf(request.getParameter("trainPlaces")) > 0){
				int result = userManager.bookATicket(infoForTicketModel);
				
				if(result < 0)
					request.setAttribute("message", RailwayProps.getProperty("mess.error.ticket.no_book"));
				else request.setAttribute("message", RailwayProps.getProperty("mess.ticket.book"));
				
			} else request.setAttribute("message", RailwayProps.getProperty("mess.error.ticket.no_places"));
			
		}else request.setAttribute("message", RailwayProps.getProperty("mess.error.ticket.no_money"));
		
		return RailwayProps.getProperty("page.user.main");
	}

}
