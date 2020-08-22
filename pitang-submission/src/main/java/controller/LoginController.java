package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.User;

@Named("loginController")
@ViewScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private LoginCDI loginCDI;
	
	@PersistenceContext
	private EntityManager em;
	
	public String validateUserLogin() {
		String result = "";
		String typedPwd = loginCDI.getUser().getPwd();
		User userRegister = em.find(User.class, this.loginCDI.getUser().getEmail());
		if(userRegister != null && userRegister.getPwd().equals(typedPwd)) {
			loginCDI.setUser(userRegister);
			loginCDI.setLoggedIn(true);
			result = "success";
		}else {
			FacesContext.getCurrentInstance().addMessage("loginForm:loginButton", new FacesMessage("Login failed! Wrong Email or Password."));
			result = "failed";
		}
		return result;
	}
}
