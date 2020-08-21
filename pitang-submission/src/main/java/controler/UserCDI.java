package controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import model.Phone;
import model.User;

@Named("userCDI")
@SessionScoped
public class UserCDI implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private User user;

	@Inject
	private Phone phone;

	@PersistenceContext
	private EntityManager em;

	@Resource
	private UserTransaction ut;

	private List<User> userList = new ArrayList<User>();

	public String registerUser() {
		user.getPhones().add(phone);
		persistUser();
		userList.add(user);
		clear();
		return "success";
	}

	private void persistUser() {
		try {
			ut.begin();
			em.persist(user);
			ut.commit();
		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void removeUser() {
		try {
			ut.begin();
			User userToRemove = em.find(User.class, user.getEmail());
			em.remove(userToRemove);
			ut.commit();
			userList.remove(user);
			clear();
		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException
				| HeuristicMixedException | HeuristicRollbackException e) {
			e.printStackTrace();
		}
		
	}

	private void retrieveList() {
		Query query = em.createQuery("SELECT u FROM User u");
		userList = query.getResultList();
	}

	public void editUser() {

	}

	private void clear() {
		user = new User();
		phone = new Phone();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		if (userList.size() == 0) {
			retrieveList();
		}
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}

}
