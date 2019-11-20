package edu.mum.mail.controller;

import edu.mum.mail.dao.mailDAO2;
import edu.mum.mail.model.mail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@WebServlet(name = "updateMailController", urlPatterns = {"/updateMailController"}, description = "updateMailController")
public class updateMailController extends HttpServlet {

    private mailDAO2 mailDAO;

    public updateMailController() {
        this.mailDAO = new mailDAO2();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String mailId=request.getParameter("mailId");
    	int id= Integer.parseInt(mailId);
    	boolean mailList = mailDAO.updateMail(id, 1);
    	System.out.println(mailList);

//        request.setAttribute("mailList", mailList);
//
//        RequestDispatcher rd = request.getRequestDispatcher("/admin-check-mail.jsp");
//        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    }
}
