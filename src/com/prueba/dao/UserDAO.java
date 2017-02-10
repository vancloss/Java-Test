package com.prueba.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.prueba.beans.*;

public class UserDAO {
	
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
  
    
    public List<User> listAllUser() throws SQLException {
        List<User> listUser = new ArrayList<>();
         
        String sql = "SELECT DISTINCT id_usrio, nmbre_usrio, cntrsnna, codemail, codeidentification, indactivo, fec_caducidad_usrio FROM sst_usrios_sstma, mert_bitacora WHERE id_usrio = id_ubicacion";
        connect();
         
        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
         
        while (resultSet.next()) {
            String id = resultSet.getString("id_usrio");
            String firstname = resultSet.getString("nmbre_usrio");
            String password = resultSet.getString("cntrsnna");
            String mail = resultSet.getString("codemail");
            String codeidentification = resultSet.getString("codeidentification");
            String status = resultSet.getString("indactivo");
            Date expiration_date = resultSet.getDate("fec_caducidad_usrio");
             
            User user = new User(id, firstname, password, mail, codeidentification, status, expiration_date);
            listUser.add(user);
        }
         
        resultSet.close();
        statement.close();
         
        disconnect();
         
        return listUser;
    }
    
    
    public User getUser(String id) throws SQLException {
        User user = null;
        String sql = "SELECT * FROM sst_usrios_sstma WHERE id_usrio = ?";
         
        connect();
         
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
        	String firstname = resultSet.getString("nmbre_usrio");
            String password = resultSet.getString("cntrsnna");
            String mail = resultSet.getString("codemail");
            String codeidentification = resultSet.getString("codeidentification");
            String status = resultSet.getString("indactivo");
            Date expiration_date = resultSet.getDate("fec_caducidad_usrio");
             
            user = new User(id, firstname, password, mail, codeidentification, status, expiration_date);
        }
         
        resultSet.close();
        statement.close();
         
        return user;
    }

}
