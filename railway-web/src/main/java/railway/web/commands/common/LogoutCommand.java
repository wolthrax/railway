package railway.web.commands.common;

import javax.servlet.http.HttpServletRequest;

import railway.web.commands.AbstractCommand;

public class LogoutCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		request.getSession().invalidate();
		return "/index.jsp";
	}

}
