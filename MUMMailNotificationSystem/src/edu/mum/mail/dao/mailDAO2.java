package edu.mum.mail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import edu.mum.mail.model.mail;

public class mailDAO2 {
//================================================

  private DataSource dataSource;

  public mailDAO2() {
      try {
          Context initContext = new InitialContext();
          Context envContext = (Context) initContext.lookup("java:comp/env");
          this.dataSource = (DataSource) envContext.lookup("jdbc/mum-mail-notification-system");
      } catch (NamingException e) {
          System.err.println(e);
      }
  }

  //to get all mail of a specific person
  public List<mail> getMail(int personId) {
      List<mail> list = new ArrayList<>();
      try {
          Connection connection = dataSource.getConnection();     
//          PreparedStatement pstmt = connection.prepareStatement("SELECT mailId, deliveryDate, sender, deliveredBy, status FROM `mum-mail-notification-system`.mail"
//          		+ "where personId='"+personId+"' order by deliveryDate");
          PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `mum-mail-notification-system`.mail "
          		+ "where personId="+personId+" order by deliveryDate");
          ResultSet rs = pstmt.executeQuery();
          
          while(rs.next()) {
              int mailId = rs.getInt("mailId");
              Date deliveryDate = rs.getDate("deliveryDate");
              String sender = rs.getString("sender");
              String deliveredBy = rs.getString("deliveredBy");
              int status = rs.getInt("status");
              mail data = new mail(mailId, deliveryDate, sender, deliveredBy, status);
              list.add(data);
          }
      } catch (SQLException e) {
          System.err.println(e);
      }
      return list;
  }
  
  
  //to get filtered mail list
  public List<mail> getFilteredMail(String text) {
      List<mail> list = new ArrayList<>();
      try {
          Connection connection = dataSource.getConnection();     
//          PreparedStatement pstmt = connection.prepareStatement("SELECT mailId, deliveryDate, sender, deliveredBy, status FROM `mum-mail-notification-system`.mail"
//          		+ "where personId='"+personId+"' order by deliveryDate");
          PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `mum-mail-notification-system`.mail "
          		+ "where personId='"+text+"' OR deliveryDate LIKE '%"+text+"%' OR sender LIKE '%"+text+"%' OR " + 
          		"deliveredBy LIKE '%"+text+"%' OR status LIKE '%"+text+"%' OR personId LIKE '%"+text+"%' order by deliveryDate");
          ResultSet rs = pstmt.executeQuery();
          
          while(rs.next()) {
              int mailId = rs.getInt("mailId");
              Date deliveryDate = rs.getDate("deliveryDate");
              String sender = rs.getString("sender");
              String deliveredBy = rs.getString("deliveredBy");
              int status = rs.getInt("status");
              mail data = new mail(mailId, deliveryDate, sender, deliveredBy, status);
              list.add(data);
          }
      } catch (SQLException e) {
          System.err.println(e);
      }
      return list;
  }
  
  //to save new mail
  public boolean saveMail(mail mailOb) {
      try {
          Connection connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("insert into `mum-mail-notification-system`.mail (deliveryDate, sender, deliveredBy, status, personId) values (?, ?, ?, ?,?)");
          pstmt.setDate (1, mailOb.getDeliveryDate());
          pstmt.setString(2, mailOb.getSender());
          pstmt.setString(3, mailOb.getDeliveredBy());
          pstmt.setInt(4, mailOb.getStatus());
          pstmt.setInt(3, mailOb.getPersonId());
          pstmt.executeUpdate();
      } catch (SQLException e) {
          System.err.println(e);
      }
      return true;
  }
  
  //to update mail status
  public boolean updateMail(int mailId, int status) {
      try {
          Connection connection = dataSource.getConnection();
          PreparedStatement pstmt = connection.prepareStatement("UPDATE `mum-mail-notification-system`.mail SET `status`=? where mailId=?");
          
          
          pstmt.setInt (1, mailId);
          pstmt.setInt(2, status);
          pstmt.executeUpdate();
      } catch (SQLException e) {
          System.err.println(e);
      }
      return true;
  }
//===============================================	
  
}
