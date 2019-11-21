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

import edu.mum.mail.model.User;
import edu.mum.mail.utils.PasswordHashing;

public class userDAO {
//================================================
//  @Resource(name = "mum-mail-notification-system")
  private DataSource dataSource;
  private Connection connection;
  public userDAO() {
      try {
          Context initContext = new InitialContext();
          Context envContext = (Context) initContext.lookup("java:comp/env");
          this.dataSource = (DataSource) envContext.lookup("jdbc/mum-mail-notification-system");
      } catch (NamingException e) {
          System.err.println(e);
      }
  }
   
  
  public User login(User user) throws Exception {
	  try {
		  
           connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("SELECT userName, password, role, personId FROM `mum-mail-notification-system`.users "
          		+ "where userName=? AND  password=?");
          pstmt.setString(1,user.getUserName() );
          pstmt.setString(2,user.getPassword());
          //pstmt.setString(2,PasswordHashing.decrypt(user.getPassword().getBytes()));

          ResultSet rs = pstmt.executeQuery();
          if(rs.next()) {
        	  user.setRole(rs.getInt("role"));
              user.setPersonId(rs.getInt("personId"));
        	  return user;
          }
      } catch (SQLException e) {
          System.err.println(e);
      }finally {
    	  connection.close();
      }
      return null;
  }
  public String getUserType(User user) throws SQLException {
	  try {
         connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("SELECT r.role FROM `mum-mail-notification-system`.users s inner join `mum-mail-notification-system`.user_role r  on s.role=r.roleId where s.userName=?");
          pstmt.setString(1,user.getUserName() );
       
//          System.out.println(pstmt.toString());
          ResultSet rs = pstmt.executeQuery();
        
          if(rs.next()) {
        	  return rs.getString("role");
          }
      } catch (SQLException e) {
          System.err.println(e);
      }
	  finally {
		  connection.close();
	  }
      return null;
  }
  
  public User getUser(User user) throws SQLException {
     try {
           connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("SELECT userName, password, role, role, personId FROM `mum-mail-notification-system`.users "
          		+ "where userName=? AND  password=?");
          pstmt.setString(1, user.getUserName());
          pstmt.setString(2, user.getPassword());
          ResultSet rs = pstmt.executeQuery();

          while(rs.next()) {
        	  System.out.println("Succesfull");

          }
      } catch (SQLException e) {
          System.err.println(e);
      }finally {
    	  connection.close();
      }
      return null;
  }
  public User saveUser(User user) throws Exception {
      try {
           connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("insert into `mum-mail-notification-system`.users (userName, password, role, personId) values (?, ?, ?, ?)");
          pstmt.setString(1, user.getUserName());
          pstmt.setString(2, user.getPassword());
          //pstmt.setString(2, PasswordHashing.encrypt(user.getPassword()).toString());
          pstmt.setInt(3, user.getRole());
          pstmt.setInt(4, user.getPersonId());
         // pstmt.setBytes(5, user.getKey().toString().getBytes());
          pstmt.executeUpdate();
          System.out.println(pstmt.toString());
      } catch (SQLException e) {
          System.err.println(e);
      }finally {
    	  connection.close();
      }
      return user;
  }
	
  public List<User> getAllUsers() throws SQLException {
	  List<User> allUsers = new ArrayList<>();
	 
     try {
           connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("SELECT userName, role, personId FROM "
          		+ "`mum-mail-notification-system`.users ");
          ResultSet rs = pstmt.executeQuery();
          
          while(rs.next()) {
        	 
	              String userName = rs.getString("userName");
	              int role = rs.getInt("role");
	              int personId = rs.getInt("personId");
	              User data = new User(userName, role, personId);
	              allUsers.add(data);
          }
      } catch (SQLException e) {
          System.err.println(e);
      }finally {
    	  connection.close();
      }
     return allUsers;
  }
//===============================================	
}
