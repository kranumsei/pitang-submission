package controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("registerController")
@ViewScoped
public class RegisterController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	SelectedUserCDI userCDI;
	
	public String registerUser() {
		String result = "";
		userCDI.getUser().getPhones().add(userCDI.getPhone());
		if (userCDI.persistUser()) {
			userCDI.getUserList().add(userCDI.getUser());
			result = "success";
		} else {
			FacesContext.getCurrentInstance().addMessage("registerUserForm:registerEmail", new FacesMessage("Please, use a valid email format."));
			result = "fail";
		}
		userCDI.clear();
		return result;
	}
}
