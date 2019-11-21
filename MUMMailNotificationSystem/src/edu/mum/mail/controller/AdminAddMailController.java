package edu.mum.mail.controller;

import edu.mum.mail.dao.mailDAO2;
import edu.mum.mail.model.mail;
import edu.mum.mail.model.mailView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminAddMailController", urlPatterns = {"/AdminAddMailController"}, description = "AdminAddMailController")
public class AdminAddMailController extends HttpServlet {

    private mailDAO2 mailDAO;

    public AdminAddMailController() {
        this.mailDAO = new mailDAO2();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String personId=request.getParameter("personId1");
    	request.setAttribute("personId", personId);
    	RequestDispatcher rd = request.getRequestDispatcher("addMail.jsp");
      rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String personId=request.getParameter("personId");
    	request.setAttribute("personId", personId);
    	String deliveredDate=request.getParameter("deliveredDate");
    	String sender=request.getParameter("sender");
    	String deliveredBy=request.getParameter("deliveredBy");
    	String missingFieldsMsg = "";
    	System.out.println(personId+"=="+deliveredDate+"=="+sender+"=="+deliveredBy+"==");
//    	if(personId.equals(null)) {
//            missingFieldsMsg += "<span style='color:red;font-size:1em'>Name is missing.</span><br/>";
//        }
        if(deliveredDate== null || deliveredDate=="") {
            missingFieldsMsg += "<span style='color:red;'>Deliverey Date is missing.</span><br/>";
        }
        if(sender==null || sender=="") {
            missingFieldsMsg += "<span style='color:red;'>userRole is missing.</span><br/>";
        }
        if(deliveredBy==null || deliveredBy=="") {
            missingFieldsMsg += "<span style='color:red;'>deliveredBy is missing.</span><br/>";
        }
        System.out.println("missing field= "+ missingFieldsMsg);
        if(!missingFieldsMsg.equals("")) {
            request.setAttribute("isErrMsgsPresent", true);
            request.setAttribute("errMsgs", missingFieldsMsg);
           
            RequestDispatcher rd = request.getRequestDispatcher("/addMail.jsp");
            rd.forward(request, response);
        } 
        else{
        	mail mailOb;
           Date d=new Date(20191212);

					mailOb = new mail(d, sender, deliveredBy, 1, Integer.parseInt(personId));
					try {
						mailDAO.saveMail(mailOb);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				      response.sendRedirect("admin-person-list.jsp");

				
				
//            request.setAttribute("savedUser", savedUser);
//            RequestDispatcher rd = request.getRequestDispatcher("addMail.jsp");
//            rd.forward(request, response);
        }
//    	
//    	request.setAttribute("mailList", mailList);
//        RequestDispatcher rd = request.getRequestDispatcher("/admin-check-mail.jsp");
//        rd.forward(request, response);
    }
}