package com.example.proj.action;
import com.example.proj.model.*;
import java.sql.PreparedStatement;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
    public String errorMessage;
    private String encryptedPassword; 
    private String token;


    private static Person accountBean;
    public String execute() throws Exception {
        accountBean = getAccountBean();
        if(validate(accountBean.getUsername(), accountBean.getPassword()) || token != ""){  
            return "success";  
        }  
        else{  
            errorMessage = "Login failed. Username and/or password is incorrect.";
            return "error";  
        } 
    }
    public boolean validate (String username,String password){  
        boolean status=false;  
         try{  
          Class.forName("com.mysql.jdbc.Driver");  
          Connection con=DriverManager.getConnection(  
          "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC","root","password");  
          setEncryptedPassword(encryptMD5(accountBean.getPassword()));
          PreparedStatement ps=con.prepareStatement(  
            "select * from users where username=? and password=?");  
          ps.setString(1,username);  
          ps.setString(2,encryptedPassword);  
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

    
    public String getEncryptedPassword() {
        return encryptedPassword;
    }
    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
    public Person getAccountBean() {
        return accountBean;
    }

    public void setAccountBean(Person accountBean) {
        Login.accountBean = accountBean;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    
}