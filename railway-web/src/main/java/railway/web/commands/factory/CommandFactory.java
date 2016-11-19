package railway.web.commands.factory;

import javax.servlet.http.HttpServletRequest;

import railway.web.commands.Command;

public class CommandFactory {
	
	public Command defineCommand(HttpServletRequest request){
		
		Command command = null;
		String commandName = request.getParameter("command");
		CommandType commandType = CommandType.valueOf(commandName.toUpperCase());
		command = commandType.getCommnad();
		
		return command;
	}
}
