package com.example.proj.action;

import com.opensymphony.xwork2.ActionSupport;                                                                                                            
import com.example.proj.model.Person;
                                        
import java.sql.Statement;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.SQLException;

public class Register extends ActionSupport {
    
    private static final long serialVersionUID = 1L;
                                 
    private Person personBean;
    private String error = "Random";
    private String encryptedPassword;

    public String execute() throws Exception {
        personBean = getPersonBean();
        if(saveToDB()) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public boolean saveToDB() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            if (connection != null) {
                statement = connection.createStatement();
                setEncryptedPassword(encryptMD5(personBean.getPassword()));
                String sql = "INSERT INTO users(username, password,first_name, last_name, age, email) VALUES('"+personBean.getUsername()+"','"+ getEncryptedPassword()+"','"+personBean.getFirstName()+"','"+personBean.getLastName()+"','"+personBean.getAge()+"','"+personBean.getEmail()+"')";
                statement.executeUpdate(sql);
                return true;
            } else {
                error = "DB connection failed";
                return false;
            }
         } catch (Exception e) {
             error = e.toString();
             return false;  
         } finally {
            if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }
    }

    private String encryptMD5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5"); 
        byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder s = new StringBuilder();  
        for(int i=0; i<  hash.length; i++)  
        {  
                s.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));  
        }  
        encryptedPassword = s.toString();
        return encryptedPassword;
    }

    public String getError() {
        return error;
    }
    
    public Person getPersonBean() {
        return personBean;
    }
    
    public void setPersonBean(Person person) {
        personBean = person;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    
}