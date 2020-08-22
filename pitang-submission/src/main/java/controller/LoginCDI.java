package controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import model.User;

@Named("loginCDI")
@SessionScoped
public class LoginCDI implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private User user;

	private boolean isLoggedIn = false;;
	
	public LoginCDI() {
		
	}
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}
	
	
	
	
	
}
