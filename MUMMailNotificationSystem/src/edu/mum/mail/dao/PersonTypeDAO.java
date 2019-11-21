package edu.mum.mail.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import edu.mum.mail.model.PersonType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonTypeDAO {

    private DataSource dataSource;
  
    public PersonTypeDAO() {
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            this.dataSource = (DataSource) envContext.lookup("jdbc/mum-mail-notification-system");
        } catch (NamingException e) {
            System.err.println(e);
        }
    }

    public List<PersonType> getAllPersonTypeFormData() {
        List<PersonType> list = new ArrayList<>();
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM `mum-mail-notification-system`.person_type order by personTypeId");
           
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	
                int personTypeId = rs.getInt("personTypeId");
                String type = rs.getString("type");
                
                PersonType data = new PersonType (type);
                list.add(data);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        return list;
    }
}