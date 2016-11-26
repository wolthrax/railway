package railway.web.commands.common;

import javax.servlet.http.HttpServletRequest;

import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class LogoutCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		request.getSession().invalidate();
		return RailwayProps.getProperty("page.index");
	}

}
