package railway.web.commands.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import railway.entities.User;
import railway.services.train.ITrainManager;
import railway.services.train.TrainManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class ShowPassengersCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		ITrainManager trainManager = new TrainManagerImpl();
		
		List<User> userList = trainManager.getPassengers(Long.valueOf(request.getParameter("trainId")));
		
		if(userList != null){
			request.setAttribute("userList", userList);
		}
		
		return RailwayProps.getProperty("page.admin.showPassengers");
	}

}
