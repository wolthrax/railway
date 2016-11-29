package railway.web.commands.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import railway.entities.Station;
import railway.entities.User;
import railway.entities.enums.UserRole;
import railway.services.station.IStationManager;
import railway.services.station.StationManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class GoToAdminMainCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("user");
		
		if(user != null)
			if(user.getRole() == UserRole.ADMIN){
				
				IStationManager stationManager = new StationManagerImpl();
				List<Station> stationList = stationManager.getAllStations();
				
				request.setAttribute("stationList", stationList);
				request.setAttribute("message", request.getParameter("message"));
				
				return RailwayProps.getProperty("page.admin.main");
			}
		return RailwayProps.getProperty("page.index");
	}
}