package edu.mum.mail.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.mum.mail.model.PersonRegistration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {

    private DataSource dataSource;
    private Connection connection;
    public RegistrationDAO() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            this.dataSource = (DataSource) envContext.lookup("jdbc/mum-mail-notification-system");
        } catch (NamingException e) {
            System.err.println(e);
        }
    }

    public List<PersonRegistration> getAllPersonFormData() throws SQLException {
        List<PersonRegistration> list = new ArrayList<>();
        try {
             connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT `personId`, `firstName`, `lastName`, `type`, `email`, `phone`, `boxnumber` FROM `mum-mail-notification-system`.person order by personId");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                int personid = rs.getInt("personId");
                String firstName = rs.getString("fname");
                String lastName = rs.getString("lname");
                String email = rs.getString("email");
                String tel = rs.getString("phone");
                String boxNumber = rs.getString("boxnumber");
                String type = rs.getString("ptype");
                PersonRegistration data = new PersonRegistration(firstName, lastName, type, email, tel, boxNumber);
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }finally {
	    	  connection.close();
	      }
        return list;
    }

    public PersonRegistration saveContactFormData(PersonRegistration registrationData) throws SQLException {
        try {
             connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("insert into `mum-mail-notification-system`.person (`firstName`, `lastName`, `type`, `email`, `tel`, `boxNumber`) values (?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, registrationData.getFname());
            pstmt.setString(2, registrationData.getLname());
            pstmt.setString(3, registrationData.getPtype());
//            pstmt.setInt(3, registrationData.get);
            pstmt.setString(4, registrationData.getEmail());
            pstmt.setString(5, registrationData.getPhone());
            pstmt.setString(6, registrationData.getBoxnumber());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        }finally {
	    	  connection.close();
	      }
        return registrationData;
    }

	


public boolean deletePerson(PersonRegistration registrationData) throws SQLException {
    String sql = "DELETE FROM `mum-mail-notification-system`.person where personId = ?";
     
    Connection connection = dataSource.getConnection();
     
    PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setInt(1, registrationData.getPersonId());
    
    pstmt.executeUpdate();
     
    boolean rowDeleted = pstmt.executeUpdate() > 0;
    pstmt.close();
    System.out.println(rowDeleted);
    return rowDeleted;     
}
 
public boolean updateBook(PersonRegistration registrationData) throws SQLException {
    String sql = "UPDATE `mum-mail-notification-system`.person SET firstName = ?, lastName = ?, email = ?, type = ?, tel = ?, boxNumber = ?";
    sql += " WHERE personId = ?";
    Connection connection = dataSource.getConnection();
     
    PreparedStatement pstmt = connection.prepareStatement(sql);
    pstmt.setString(1, registrationData.getFname());
    pstmt.setString(2, registrationData.getLname());
    pstmt.setString(3, registrationData.getEmail());
    pstmt.setString(4, registrationData.getPtype());
    pstmt.setString(5, registrationData.getPhone());
    pstmt.setString(6, registrationData.getBoxnumber());
     
    boolean rowUpdated = pstmt.executeUpdate() > 0;
    pstmt.close();
    System.out.println(rowUpdated);
    return rowUpdated;     
}

}