package model;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


@Stateless
public class UserDAO {
	
	private ArrayList<User> users;
	
	@PersistenceContext
	private EntityManager em;

	public UserDAO() {
		//users = listUsers();
	}
	
	@Transactional
	public void add(User user) {
		em.persist(user);
	}
	
	@Transactional
	public ArrayList<User> listUsers(){
		Query query = em.createQuery("SELECT u FROM User u");
		return (ArrayList<User>) query.getResultList();
	}
	
	public void print() {
		System.out.println(users);
	}
	
}
