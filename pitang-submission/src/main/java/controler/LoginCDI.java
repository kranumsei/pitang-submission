package controler;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;

@Named("loginCDI")
@SessionScoped
public class LoginCDI implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Inject
	private User user;
	
	@PersistenceContext
	private EntityManager em;

	private boolean isLoggedIn = false;;
	
	public LoginCDI() {
		
	}
	
	public String validateUserLogin() {
		String typedPwd = user.getPwd();
		user = em.find(User.class, this.user.getEmail());
		if(user.getPwd().equals(typedPwd)) {
			isLoggedIn = true;
			return "success";
		}else {
			return "failed";
		}
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
