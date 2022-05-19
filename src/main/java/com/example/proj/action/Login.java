package com.example.proj.action;
import com.example.proj.model.*;
import java.sql.PreparedStatement;
import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {

    static Person person=new Person();
    private Person accountBean;
    public String execute() throws Exception {
        accountBean = getAccountBean();
        if(validate(accountBean.getUsername(), accountBean.getPassword())){  
            setAccountBean(person);
            return "success";  
        }  
        else{  
            return "error";  
        } 
    }
    public static boolean validate(String username,String password){  
        boolean status=false;  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC","root","password");  
            PreparedStatement ps=con.prepareStatement(  
            "select * from users where username=? and password=?");  
            ps.setString(1,username);  
            ps.setString(2,password);  
            ResultSet rs=ps.executeQuery();  
            status=rs.next(); 
            person.setUserId(rs.getInt(1));
            person.setUserType(rs.getString(4));
            person.setUsername(rs.getString(2));
            person.setLastName(rs.getString(7));   
            person.setFirstName(rs.getString(6)); 
            person.setEmail(rs.getString(9));
            person.setAge(rs.getInt(8)); 
        }catch(Exception e){e.printStackTrace();}  
        return status;  
       }
    public Person getAccountBean() {
        return accountBean;
    }

    public void setAccountBean(Person accountBean) {
        this.accountBean = accountBean;
    }
}