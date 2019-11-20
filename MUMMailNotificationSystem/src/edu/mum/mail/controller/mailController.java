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
        List<mail> mailList = mailDAO.getMail(1);

        request.setAttribute("mailList", mailList);

        RequestDispatcher rd = request.getRequestDispatcher("/admin-check-mail.jsp");
        rd.forward(request, response);
    }
}
