package railway.web.commands.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import railway.entities.Station;
import railway.entities.User;
import railway.services.station.IStationManager;
import railway.services.station.StationManagerImpl;
import railway.services.user.IUserManager;
import railway.services.user.UserManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class GoToUserMainCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		IStationManager stationManager = new StationManagerImpl();
		List<Station> stationList = stationManager.getAllStations();
		
		request.setAttribute("stationList", stationList);
		
		IUserManager userManager = new UserManagerImpl();
		User user = (User) request.getSession().getAttribute("user");
		user = userManager.getUserById(user.getId());
		request.setAttribute("user", user.getLogin() + "(" + user.getName() + " " + user.getSurname() + ")  ");
		request.setAttribute("money", "Money: " + user.getMoney());
		
		return RailwayProps.getProperty("page.user.main");
	}

}
