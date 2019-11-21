package edu.mum.mail.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.mail.dao.PersonTypeDAO;
import edu.mum.mail.dao.RegistrationDAO;
import edu.mum.mail.dao.userDAO;
import edu.mum.mail.model.Person;
import edu.mum.mail.model.PersonRegistration;
import edu.mum.mail.model.PersonType;

/**
 * Servlet implementation class Login
 */
@WebServlet("/CreateUser")
public class CreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegistrationDAO personsDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateUser() {
    
        super();
        personsDao=new RegistrationDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<PersonRegistration> listPerson= null;
		try {
			listPerson = personsDao.getAllPersonFormData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    	request.getSession().setAttribute("ListPersons", listPerson);
    	System.out.println(listPerson);
    	request.getServletContext().getRequestDispatcher("/createUser.jsp").forward(request, response);
    }


}
