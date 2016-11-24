package railway.web.commands.factory;

import railway.web.commands.Command;
import railway.web.commands.admin.AddStationCommand;
import railway.web.commands.admin.AddTrainCommand;
import railway.web.commands.admin.GoToAddStationCommand;
import railway.web.commands.admin.GoToAddTrainCommand;
import railway.web.commands.common.GoToRegistrationCommand;
import railway.web.commands.common.LoginCommand;
import railway.web.commands.common.LogoutCommand;
import railway.web.commands.common.RegistrationCommand;

public enum CommandType {

	// User commands
	BOOK_A_TICKET,
	SHOW_ALL_TICKETS,
	// ...
	
	// Admin commands
	GO_TO_ADD_TRAIN,
	ADD_TRAIN,
	GO_TO_ADD_STATION,
	ADD_STATION,
	SHOW_PASSENGERS,
	// ...
	
	// Other commands
	GO_TO_REGISTRATION,
	REGISTRATION,
	LOGIN,
	LOGOUT,
	SHOW_SIUTABLE_TRAIN;
	
	@SuppressWarnings("incomplete-switch")
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
				
			case ADD_STATION:
				return new AddStationCommand();
				
			case GO_TO_ADD_STATION:
				return new GoToAddStationCommand();
				
			case GO_TO_ADD_TRAIN:
				return new GoToAddTrainCommand();
				
			case ADD_TRAIN:
				return new AddTrainCommand();
		
		}
		
		return null;	
	}
	
}
