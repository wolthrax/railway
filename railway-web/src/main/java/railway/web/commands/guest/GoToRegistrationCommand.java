package railway.web.commands.guest;

import javax.servlet.http.HttpServletRequest;

import railway.web.commands.AbstractCommand;

public class GoToRegistrationCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		return "/jsp/registration.jsp";
	}

}
