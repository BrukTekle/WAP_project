package edu.mum.mail.controller;

import edu.mum.mail.dao.mailDAO2;
import edu.mum.mail.model.Person;
import edu.mum.mail.model.PersonView;
import edu.mum.mail.model.mail;
import edu.mum.mail.model.mailView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminMailController", urlPatterns = {"/AdminMailController"}, description = "AdminMailController")
public class AdminMailController extends HttpServlet {

    private mailDAO2 mailDAO;

    public AdminMailController() {
        this.mailDAO = new mailDAO2();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<PersonView> personList = new ArrayList<PersonView>(); 
    	List<Person> allPerson=new ArrayList<Person>();

//        allMail=mailDAO.getAllMail();
        allPerson=mailDAO.getAllPerson();
    	for(Person list:allPerson) {
    		 int pid=list.getPersonId();
    		 String fName=list.getFirstName();
    		 String lName=list.getLastName();
    		 String email=list.getEmail();
    		 String tel=list.getTel();
    		 String boxNumber=list.getBoxNumber();
    		 int typeId=list.getType();
    		 String type=mailDAO.getPersonType(typeId);
    		 System.out.println("type= "+type);
    		 PersonView newPerson=new PersonView(pid,fName,lName,email,tel,boxNumber,type);
    		 personList.add(newPerson);
    	}
    	
    	request.setAttribute("mailList", personList);
        RequestDispatcher rd = request.getRequestDispatcher("/admin-person-list.jsp");
        rd.forward(request, response);
    }
}
