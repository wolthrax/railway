package railway.web.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import railway.utils.logger.RailwayLogger;
import railway.web.commands.Command;
import railway.web.commands.factory.CommandFactory;
import railway.web.timers.DeleteTimerTrains;

//@WebServlet("/controller")
public class Controller extends HttpServlet{

	static final long serialVersionUID = 1L;
	Thread deleteTimerTrains;
	
	@Override
	public void init() throws ServletException {
		deleteTimerTrains = new Thread(new DeleteTimerTrains(30));
		deleteTimerTrains.start();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		processRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response){
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response){
		CommandFactory commandFactory = new CommandFactory();
		Command command = commandFactory.defineCommand(request);
		String page = command.execute(request);
		try {
			request.getRequestDispatcher(page).forward(request, response);
		} catch (ServletException e) {
			RailwayLogger.logError(getClass(), e.getMessage());
		} catch (IOException e) {
			RailwayLogger.logError(getClass(), e.getMessage());
		}
	}
}
