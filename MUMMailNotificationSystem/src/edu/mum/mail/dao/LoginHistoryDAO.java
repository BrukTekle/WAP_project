package edu.mum.mail.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.cj.result.LocalDateTimeValueFactory;

import edu.mum.mail.model.LoginHistory;
import edu.mum.mail.model.User;

public class LoginHistoryDAO {
	//================================================

	  private DataSource dataSource;
	  Connection connection=null;
	  public LoginHistoryDAO() {
	      try {
	          Context initContext = new InitialContext();
	          Context envContext = (Context) initContext.lookup("java:comp/env");
	          this.dataSource = (DataSource) envContext.lookup("jdbc/mum-mail-notification-system");
	      } catch (NamingException e) {
	          System.err.println(e);
	      }
	  }

	  public List<LoginHistory> getLoginHistory() throws SQLException {
	      List<LoginHistory> list = new ArrayList<>();
	      try {
	    	  
	           connection = dataSource.getConnection();
	          PreparedStatement pstmt = connection.prepareStatement("SELECT userName, loginDate, logOutDate, ipAddress FROM `mum-mail-notification-system`.`loging_history`"
	          		+ "order by loginDate");// acending
	          ResultSet rs = pstmt.executeQuery();
	          while(rs.next()) {
	              String username = rs.getString("userName");
	              java.sql.Timestamp logingDate = rs.getTimestamp("loginDate");
	              java.sql.Timestamp logOutDate = rs.getTimestamp("logOutDate");
//	              Date logOutDate = rs.getDate("logOutDate");
	              String ipAddress = rs.getString("ipAddress");
	              LoginHistory data = new LoginHistory(username, logingDate, logOutDate, ipAddress);
	              list.add(data);
//	              System.out.println("login history data is: " + data.toString());
	          }
	      } catch (SQLException e) {
	          System.err.println(e);
	      }finally {
	    	  connection.close();
	      }
	      return list;
	  }
	
	  public LoginHistory saveLoginHistory(User user, String ipAddress) throws SQLException {
		  
		  LoginHistory loggedIn = null;
	      try {
	           connection = dataSource.getConnection();
	          PreparedStatement pstmt = connection.prepareStatement("insert into `mum-mail-notification-system`.`loging_history` (userName, loginDate, ipAddress) values (?, ?, ?)");
	          pstmt.setString(1, user.getUserName());
	          //pstmt.setDate(2, new java.sql.Date(System.currentTimeMillis()));
	          Date date= new Date();
	          
	          long time = date.getTime();
	             
	          Timestamp ts = new Timestamp(time);
	          
	          pstmt.setTimestamp(2, ts);
	          pstmt.setString(3, ipAddress);
	          loggedIn=new LoginHistory(user.getUserName(), ts, null, ipAddress);
	          pstmt.executeUpdate();
	          return loggedIn;
	      } catch (SQLException e) {
	          System.err.println(e);
	      }finally {
	    	  connection.close();
	      }
	      return loggedIn;
	  }
	  
	  public boolean updateLoginHistory(LoginHistory  user) throws SQLException {
		  boolean loggedIn = false;
		  LoginHistory currentUser=null;
	      try {
	           connection = dataSource.getConnection();
	          
	          PreparedStatement pstmt1 = connection.prepareStatement("SELECT  * FROM `mum-mail-notification-system`.loging_history where userName=? order by loginDate desc LIMIT 0,1");
	          PreparedStatement pstmt2 = connection.prepareStatement("update `mum-mail-notification-system`.`loging_history` set `logoutDate` = ? where (userName = ? and loginDate=?)");
	          pstmt1.setString(1, user.getUserName());
	          ResultSet rs = pstmt1.executeQuery();
	          while(rs.next()) {
	        	  Date date= new Date();
		          
		          long time = date.getTime();
		             
		          Timestamp ts = new Timestamp(time);
		        
		          pstmt2.setTimestamp(1, ts);
		          pstmt2.setString(2, user.getUserName());
		          pstmt2.setTimestamp(3, rs.getTimestamp("loginDate"));
		          pstmt2.executeUpdate();
	          }
	          
	          loggedIn = true;
	      } catch (SQLException e) {
	          System.err.println(e);
	      }finally {
	    	  connection.close();
	      }
	      return loggedIn;
	  }
	//===============================================	
}
