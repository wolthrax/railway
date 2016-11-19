package railway.web.commands.admin;

import javax.servlet.http.HttpServletRequest;

import railway.web.commands.AbstractCommand;

public class AddStationCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		return "/jsp/admin/main.jsp";
	}

}
