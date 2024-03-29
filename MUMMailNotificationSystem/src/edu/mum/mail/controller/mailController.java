package edu.mum.mail.controller;

import edu.mum.mail.dao.mailDAO2;
import edu.mum.mail.model.User;
import edu.mum.mail.model.mail;
import edu.mum.mail.model.mailView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "mailController", urlPatterns = {"/mailController"}, description = "mailController")
public class mailController extends HttpServlet {

    private mailDAO2 mailDAO;

    public mailController() {
        this.mailDAO = new mailDAO2();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<mail> mailList = mailDAO.getMail(1);

    	HttpSession session=request.getSession();
		User user=(User)session.getAttribute("user");
		Integer perID=null;
		if(user!=null) {
			perID=user.getPersonId();
		}
        List<mailView> mailList = new ArrayList<mailView>(); 
    	List<mail> allMail=new ArrayList<mail>();
        try {
			allMail=mailDAO.getMail(perID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	for(mail list:allMail) {
    		 int mid=list.getMailId();
    		 Date deliveryDate=(Date) list.getDeliveryDate();
    		 String sender=list.getSender();
    		 String deliveredBy=list.getDeliveredBy();
    		 int statusId=list.getStatus();
    		 int personId=list.getPersonId();
    		 String fullName="";
			try {
				fullName = mailDAO.getPersonName(personId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 String status="";
			try {
				status = mailDAO.getStatusName(statusId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 mailView newMail=new mailView(mid,deliveryDate,sender,deliveredBy,status,fullName);
    		 mailList.add(newMail);
    	}
    	
        
        request.setAttribute("mailList", mailList);

        RequestDispatcher rd = request.getRequestDispatcher("/check-mail.jsp");
        rd.forward(request, response);
    }
}
