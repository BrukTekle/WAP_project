package edu.mum.mail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.mum.mail.model.ContactFormData;
import edu.mum.mail.model.user;

public class userDAO {
//================================================
//  @Resource(name = "jdbc/cs472-201911-lesson15-contacts-db")
  private DataSource dataSource;

  public userDAO() {
      try {
          Context initContext = new InitialContext();
          Context envContext = (Context) initContext.lookup("java:comp/env");
          this.dataSource = (DataSource) envContext.lookup("jdbc/mum-mail-notification-system");
      } catch (NamingException e) {
          System.err.println(e);
      }
  }

  public user getUser(user userOb) {
      List<ContactFormData> list = new ArrayList<>();
      try {
          Connection connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("SELECT userName, password, role, role, personId FROM `mum-mail-notification-system`.users "
          		+ "where userName=? AND  password=?");
          pstmt.setString(1, userOb.getUserName());
          pstmt.setString(2, userOb.getPassword());
          ResultSet rs = pstmt.executeQuery();

          while(rs.next()) {
        	  System.out.println("Succesfull");
//              int contactsId = rs.getInt("contacts_id");
//              String name = rs.getString("customer_name");
//              String gender = rs.getString("gender");
//              String category = rs.getString("category");
//              String message = rs.getString("message");
//              ContactFormData data = new ContactFormData(contactsId, name, gender, category, message);
//              list.add(data);
          }
      } catch (SQLException e) {
          System.err.println(e);
      }
      return null;
  }
  public ContactFormData saveContactFormData(ContactFormData contactFormData) {
      try {
          Connection connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("insert into `cs472-201911-lesson15-contacts-db`.contacts (customer_name, gender, category, message) values (?, ?, ?, ?)");
          pstmt.setString(1, contactFormData.getName());
          pstmt.setString(2, contactFormData.getGender());
          pstmt.setString(3, contactFormData.getCategory());
          pstmt.setString(4, contactFormData.getMessage());
          pstmt.executeUpdate();
      } catch (SQLException e) {
          System.err.println(e);
      }
      return contactFormData;
  }
	
	
//===============================================	
}
