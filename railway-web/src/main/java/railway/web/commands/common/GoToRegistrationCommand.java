package railway.web.commands.common;

import javax.servlet.http.HttpServletRequest;

import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class GoToRegistrationCommand extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		return RailwayProps.getProperty("page.registration");
	}

}
