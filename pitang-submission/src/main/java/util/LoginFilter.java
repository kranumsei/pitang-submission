package util;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

import controller.LoginCDI;

@WebFilter(urlPatterns = {"/loggedin/*"})
public class LoginFilter implements Filter{

	@Inject
	private LoginCDI login;

		
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    HttpServletResponse res = (HttpServletResponse) response;
		if(!login.isLoggedIn()) {
			
		    res.sendRedirect("/pitang-submission/index.xhtml");
		} else {
			chain.doFilter(request, response);
		}
		
		
	}

}
