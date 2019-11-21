package edu.mum.mail.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.mum.mail.dao.LoginHistoryDAO;
import edu.mum.mail.dao.userDAO;
import edu.mum.mail.model.LoginHistory;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    LoginHistoryDAO loginHistoryDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
       
        this.loginHistoryDAO=new LoginHistoryDAO();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
	        if (session != null) {
	        	//save the logout history to db
				LoginHistory loggedIn=(LoginHistory) session.getAttribute("loggedIn");
				//Save loginHistory for the user
				if (loggedIn!=null) {
					try {
						loginHistoryDAO.updateLoginHistory(loggedIn);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
	        	session.invalidate();
	        	//or u can do it by 
	            //session.removeAttribute("user");
	        	
	        	
				
	            response.sendRedirect("index.jsp");
	           
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
