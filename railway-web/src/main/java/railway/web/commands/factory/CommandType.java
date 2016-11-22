package railway.web.commands.factory;

import railway.web.commands.Command;
import railway.web.commands.admin.AddStationCommand;
import railway.web.commands.admin.GoToAddStation;
import railway.web.commands.common.GoToRegistrationCommand;
import railway.web.commands.common.LoginCommand;
import railway.web.commands.common.LogoutCommand;
import railway.web.commands.common.RegistrationCommand;

public enum CommandType {

	// User commands
	BOOK_A_TICKET,
	SHOW_ALL_TICKETS,
	GO_TO_ADD_STATION,
	// ...
	
	// Admin commands
	ADD_TRAIN,
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
				return new GoToAddStation();
		
		}
		
		return null;	
	}
	
}
