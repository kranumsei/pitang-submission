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
public class MainPageController implements Serializable {

	@Inject
	private SelectedUserCDI userCDI;

	@Inject
	private LoginCDI loginCDI;

	@PersistenceContext
	private EntityManager em;
	private static final long serialVersionUID = 1L;

	public void removeSelectedUser() {
		String userToRemove = userCDI.getUser().getEmail();
		userCDI.removeUser(userToRemove);
	}

	public void submitEdition() {
		boolean userIsAdmin = loginCDI.getUser().isAdmin();
		String currentUserEmail = loginCDI.getUser().getEmail();

		User selectedUser = userCDI.getUser();
		Phone selectedUserPhone = userCDI.getPhone();

		if (!userIsAdmin && !selectedUser.getEmail().equals(currentUserEmail)) {
			return;
		}
		if (selectedUserPhone.getRegionCode() != null && !selectedUserPhone.getNumber().equals("")
				&& !selectedUserPhone.getNumberType().equals("")) {
			selectedUser.getPhones().add(selectedUserPhone);
		}
		if (selectedUser.getName().equals("")) {
			User newUser = em.find(User.class, selectedUser.getEmail());
			selectedUser.setName(newUser.getName());
		}
		userCDI.editUser();
		userCDI.setPhone(new Phone());
	}

	public void removePhoneFromUser() {
		boolean userIsAdmin = loginCDI.getUser().isAdmin();
		String currentUserEmail = loginCDI.getUser().getEmail();
		User selectedUser = userCDI.getUser();
		if (!userIsAdmin && !selectedUser.getEmail().equals(currentUserEmail)) {
			return;
		}
		userCDI.getUser().getPhones().remove(userCDI.getPhone());
		userCDI.editUser();
	}

		
		

		
	

}
