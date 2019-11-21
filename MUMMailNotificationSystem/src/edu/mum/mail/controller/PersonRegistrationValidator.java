package edu.mum.mail.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.mum.mail.dao.RegistrationDAO;
import edu.mum.mail.dao.PersonTypeDAO;
import edu.mum.mail.model.Person;
import edu.mum.mail.model.PersonRegistration;
import edu.mum.mail.model.PersonType;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PersonRegistrationValidator", urlPatterns = {"/PersonRegistrationValidator"}, description = "PersonRegistrationValidator")
public class PersonRegistrationValidator extends HttpServlet {
     
   
	private static final long serialVersionUID = 1L;
	private RegistrationDAO registrationDAO;
	private PersonTypeDAO personTypeDao;
	public PersonRegistrationValidator() {
		registrationDAO=new RegistrationDAO();
		personTypeDao=new PersonTypeDAO();
	}
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String email = request.getParameter("email");
        String tel = request.getParameter("phone");
        String boxNumber = request.getParameter("boxnumber");
        String type = request.getParameter("pType");
        System.out.println("fname = "+ firstName + ", lname = " + lastName + ", ptype = " + type + ", email = " + email + ", phone = " + tel + ", boxnumber = " + boxNumber);
        PersonRegistration personregistration = new PersonRegistration(firstName, lastName, type, email, tel, boxNumber );
        Person personregistration = new Person(firstName, lastName, type, email, tel, boxNumber );
        request.setAttribute("personregistration", personregistration);
        // Check for missing fields data
        String missingFieldsMsg = "";
        if(firstName.equals("")) {
            missingFieldsMsg += "<span style='color:red;font-size:1em'>First Name is missing.</span><br/>";
        }
        if(lastName.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Last Name is missing.</span><br/>";
        }
        if(type==null || type.equals("null")) {
            missingFieldsMsg += "<span style='color:red;'>Person Type is missing.</span><br/>";
        }
        if(email.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Email is missing.</span><br/>";
        }
        if(tel.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Phone is missing.</span><br/>";
        }
        if(boxNumber.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Box Number is missing.</span><br/>";
        }
        if(!missingFieldsMsg.equals("")) {
            request.setAttribute("isErrMsgsPresent", true);
            request.setAttribute("errMsgs", missingFieldsMsg);
            // forward (return) back to sender
            RequestDispatcher rd = request.getRequestDispatcher("/person.jsp");
            rd.forward(request, response);
        } else {
  
        	registrationDAO.saveContactFormData(personregistration);
            String currDateTime = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy - h:mm:ss a zzzz"));
            request.setAttribute("currDateTime", currDateTime);
            // forward ahead to thank-you
            RequestDispatcher rd = request.getRequestDispatcher("HomePage.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<PersonType> listPersonType= personTypeDao.getAllPersonTypeFormData();

    	request.getSession().setAttribute("ListPersonType", listPersonType);
    	System.out.println(listPersonType);
        request.getServletContext().getRequestDispatcher("/person.jsp").forward(request, response);;
    }
}

