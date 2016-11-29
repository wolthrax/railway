package railway.web.commands.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import railway.entities.User;
import railway.entities.enums.UserRole;
import railway.services.train.ITrainManager;
import railway.services.train.TrainManagerImpl;
import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class ShowPassengersCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		
		User user = (User) request.getSession().getAttribute("user");
		if(user != null)
			if(user.getRole() == UserRole.ADMIN){
				ITrainManager trainManager = new TrainManagerImpl();
				
				List<User> userList = trainManager.getPassengers(Long.valueOf(request.getParameter("trainId")));
				
				if(userList != null)
					request.setAttribute("userList", userList);
				
				return RailwayProps.getProperty("page.admin.showPassengers");
			}
		return RailwayProps.getProperty("page.index");
	}
}
