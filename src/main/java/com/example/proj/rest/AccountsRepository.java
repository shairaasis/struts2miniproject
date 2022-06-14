package com.example.proj.rest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.example.proj.model.Person;
import com.mysql.cj.xdevapi.Result;


public class AccountsRepository {
    private String error = "Random";
    private static Map<String, Person> map = new HashMap<String, Person>();
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String result;
    public AccountsRepository(){
      
    }
    
    public Map<String, Person> findAllAccounts() throws SQLException{
        connectToDb();
        if (connection != null) {
            String sql = "SELECT * FROM users";
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs= preparedStatement.executeQuery();

            while(rs.next()){  
                Person person=new Person();
                person.setUserId(rs.getInt(1));
                person.setUsername(rs.getString(2));
                person.setLastName(rs.getString(7));   
                person.setFirstName(rs.getString(6)); 
                person.setEmail(rs.getString(9));
                person.setAge(rs.getInt(8)); 
                map.put(rs.getString(1), person);  
            }
        } 
        return map;
    }


   /*POST SAVE TO DB */
    public Map<String, Person> save(Person account) throws Exception{
        connection = connectToDb();
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO users(username, password,first_name, last_name, age, email) VALUES('"+account.getUsername()+"','"+account.getPassword()+"','"+account.getFirstName()+"','"+account.getLastName()+"','"+account.getAge()+"','"+account.getEmail()+"')";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            
        } 
        return map;
    }
    //GET accounts/id/
    public Person getAccountById(String id) {
        return map.get(id);
    }
    //delete accounts/id/
    public String remove(String id) throws Exception{
        connection = connectToDb();
        if(connection != null){
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM users where user_id = '"+id+"'";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        }
        return result;
    }
    //update accounts/id/
    public Map<String, Person> update(String id, Person account) throws Exception{
        connection = connectToDb();
        if(connection != null){
            Statement statement = connection.createStatement();
            String sql = "UPDATE users SET first_name = '"+account.getFirstName()+"', last_name = '"+account.getLastName()+"' WHERE user_id = '"+id+"'";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();
        }
        return map;
    }
    
   public Connection connectToDb(){
    try {
        String URL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(URL, "root", "password");
    } catch (Exception e) {
        error = e.toString();
        
    } 
    return connection;
   }
}