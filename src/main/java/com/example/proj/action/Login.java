package com.example.proj.action;
import com.example.proj.model.*;
import java.sql.PreparedStatement;
import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
    public String errorMessage; 

    private static Person accountBean;
    public String execute() throws Exception {
        accountBean = getAccountBean();
        if(validate(accountBean.getUsername(), accountBean.getPassword())){  
            return "success";  
        }  
        else{  
            errorMessage = "Login failed. Username and/or password is incorrect.";
            return "error";  
        } 
    }
    public static boolean validate (String username,String password){  
        boolean status=false;  
         try{  
          Class.forName("com.mysql.jdbc.Driver");  
          Connection con=DriverManager.getConnection(  
          "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC","root","password");  
            
          PreparedStatement ps=con.prepareStatement(  
            "select * from users where username=? and password=?");  
          ps.setString(1,username);  
          ps.setString(2,password);  
          ResultSet rs=ps.executeQuery();
          status=rs.next();   
            accountBean.setUserId(rs.getInt(1));
            accountBean.setUserType(rs.getString(4));
            accountBean.setUsername(rs.getString(2));
            accountBean.setLastName(rs.getString(7));   
            accountBean.setFirstName(rs.getString(6)); 
            accountBean.setEmail(rs.getString(9));
            accountBean.setAge(rs.getInt(8)); 
         }catch(Exception e){e.printStackTrace();}  
        return status;  
    } 


    public Person getAccountBean() {
        return accountBean;
    }

    public void setAccountBean(Person accountBean) {
        Login.accountBean = accountBean;
    }
}