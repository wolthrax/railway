package railway.web.commands.admin;

import javax.servlet.http.HttpServletRequest;

import railway.utils.props.RailwayProps;
import railway.web.commands.AbstractCommand;

public class GoToAdminMain extends AbstractCommand{

	@Override
	public String execute(HttpServletRequest request) {
		return RailwayProps.getProperty("page.admin.main");
	}
}
