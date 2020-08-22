package controller;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Phone;
import model.User;

@Named("mainPageController")
@ViewScoped
public class MainPageController implements Serializable{
	
	@Inject
	private SelectedUserCDI userCDI;
	
	@PersistenceContext
	private EntityManager em;
	private static final long serialVersionUID = 1L;

	
	public void removeSelectedUser() {
		String userToRemove = userCDI.getUser().getEmail();
		userCDI.removeUser(userToRemove);
	}
	
	public void submitEdition() {
		if(userCDI.getPhone().getRegionCode() != null && !userCDI.getPhone().getNumber().equals("") && !userCDI.getPhone().getNumberType().equals("")) {
			userCDI.getUser().getPhones().add(userCDI.getPhone());
		} 
		if(userCDI.getUser().getName().equals("")) {
			User newUser = em.find(User.class, userCDI.getUser().getEmail());
			userCDI.getUser().setName(newUser.getName());
		}
		userCDI.editUser();
		userCDI.setPhone(new Phone());
	}
	
	public void removePhoneFromUser() {
		userCDI.getUser().getPhones().remove(userCDI.getPhone());
		userCDI.editUser();
	}
	
}
