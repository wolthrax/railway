package railway.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import railway.entities.enums.UserRole;

@WebFilter( urlPatterns = { "/jsp/admin/*" },
	initParams = { @WebInitParam(name = "INDEX_PATH", value = "/index.jsp") })
public class AdminSecurityFilter implements Filter{
	
	private String indexPath;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		indexPath = filterConfig.getInitParameter("INDEX_PATH");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		
		UserRole role = (UserRole) session.getAttribute("userRole");
		
		if(role != UserRole.ADMIN){
			httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);
			return;
		}
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
	}

}
