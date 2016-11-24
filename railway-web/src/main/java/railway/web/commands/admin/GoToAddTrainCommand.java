package railway.web.commands.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import railway.entities.Station;
import railway.services.station.IStationManager;
import railway.services.station.StationManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class GoToAddTrainCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		IStationManager stationManager = new StationManagerImpl();
		
		List<Station> stationList = new ArrayList<>();
		stationList = stationManager.getAllStations();
		
		request.setAttribute("stationList", stationList);
		
		return RailwayProps.getProperty("page.admin.add_train");
	}

}
