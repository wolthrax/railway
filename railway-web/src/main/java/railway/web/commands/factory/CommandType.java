package railway.web.commands.factory;

import railway.web.commands.Command;
import railway.web.commands.admin.AddStationCommand;
import railway.web.commands.admin.AddTrainCommand;
import railway.web.commands.admin.FindTrainCommand;
import railway.web.commands.admin.GoToAddStationCommand;
import railway.web.commands.admin.GoToAddTrainCommand;
import railway.web.commands.admin.GoToAdminMainCommand;
import railway.web.commands.admin.ShowPassengersCommand;
import railway.web.commands.common.GoToRegistrationCommand;
import railway.web.commands.common.LoginCommand;
import railway.web.commands.common.LogoutCommand;
import railway.web.commands.common.RegistrationCommand;
import railway.web.commands.user.BookATicketCommand;
import railway.web.commands.user.GetSiutableTrainCommand;
import railway.web.commands.user.GoToUpdateUserCommand;
import railway.web.commands.user.GoToUserMainCommand;
import railway.web.commands.user.ShowAllTicketsCommand;
import railway.web.commands.user.UpdateUserCommnd;

public enum CommandType {

	// User commands
	GO_TO_USER_MAIN,
	GET_SIUTABLE_TRAIN,
	BOOK_A_TICKET,
	SHOW_ALL_TICKETS,
	UPDATE_USER,
	GO_TO_UPDATE_USER,
	// ...
	
	// Admin commands
	GO_TO_ADMIN_MAIN,
	GO_TO_ADD_TRAIN,
	ADD_TRAIN,
	GO_TO_ADD_STATION,
	ADD_STATION,
	FIND_TRAIN,
	SHOW_PASSENGERS,
	// ...
	
	// Other commands
	GO_TO_REGISTRATION,
	REGISTRATION,
	LOGIN,
	LOGOUT;
	
	public Command getCommnad(){
		
		switch(this){
		
			case LOGIN:
				return new LoginCommand();
				
			case LOGOUT:
				return new LogoutCommand();
				
			case GO_TO_REGISTRATION:
				return new GoToRegistrationCommand();
				
			case REGISTRATION:
				return new RegistrationCommand();
				
			case GO_TO_ADMIN_MAIN:
				return new GoToAdminMainCommand();
				
			case ADD_STATION:
				return new AddStationCommand();
				
			case GO_TO_ADD_STATION:
				return new GoToAddStationCommand();
				
			case GO_TO_ADD_TRAIN:
				return new GoToAddTrainCommand();
				
			case ADD_TRAIN:
				return new AddTrainCommand();
				
			case FIND_TRAIN:
				return new FindTrainCommand();
				
			case GO_TO_USER_MAIN:
				return new GoToUserMainCommand();
				
			case GET_SIUTABLE_TRAIN:
				return new GetSiutableTrainCommand();
				
			case BOOK_A_TICKET:
				return new BookATicketCommand();
				
			case SHOW_PASSENGERS:
				return new ShowPassengersCommand();
				
			case SHOW_ALL_TICKETS:
				return new ShowAllTicketsCommand();
				
			case GO_TO_UPDATE_USER:
				return new GoToUpdateUserCommand();
				
			case UPDATE_USER:
				return new UpdateUserCommnd();
				
			default: return new GoToRegistrationCommand();
		}
	}
}
