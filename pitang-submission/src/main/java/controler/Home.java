package controler;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import model.Phone;
import model.User;
import model.UserDAO;


@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Resource
//	private UserTransaction ut;
//	
//	
//	@PersistenceContext
//	private EntityManager em;

	
	public Home() {
		// TODO Auto-generated constructor stub
	}

	@EJB
	UserDAO dao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User newUser = new User("Joao", "jvaoliasfasgveitra96@gmail.com", "123456pwd",
				new Phone(81, "999101888", "Cel Phone"));
//		User user;
//		String email = "";
//		try {
//			ut.begin();
//			//em.persist(newUser);
//			user = em.find(User.class, "jvaoliveira96@gmail.com");
//			email = user.getEmail();
//			ut.commit();
//		} catch (NotSupportedException | SystemException | SecurityException | IllegalStateException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
//			// TODO Auto-generated catch block
//			
//			e.printStackTrace();
//		}
		
		//UserDAO dao = new UserDAO();
		//dao.add(newUser);
		System.out.println(dao.listUsers().get(0).getEmail());

		response.getWriter().append("Served at: ");
	}

}
