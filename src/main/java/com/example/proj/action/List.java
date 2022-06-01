package com.example.proj.action;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.Connection;                
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.opensymphony.xwork2.ActionSupport;
import com.example.proj.model.Person;

public class List extends ActionSupport {
    public ArrayList listOfNames = new ArrayList();
    ArrayList<Person> persons = new ArrayList<Person>();
    public String nameInput;
    private Person accountBean;
    
   
    public ArrayList getListOfNames() {
        return listOfNames;
    }
    public void setListOfNames(ArrayList listOfFirstNames) {
        this.listOfNames = listOfFirstNames;
    }
    public String getNameInput() {
        return nameInput;
    }
    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public Person getAccountBean() {
        return accountBean;
    }
    public void setAccountBean(Person accountBean) {
        this.accountBean = accountBean;
    }

    public ArrayList<Person> getPersons() {  
        return persons;  
    }  
    public void setList(ArrayList<Person> persons) {  
        this.persons = persons;  
    }  

    public String execute() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            String URL = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, "root", "password");

            if (connection != null) {
                String sql = "SELECT * FROM users ORDER BY last_name ASC";
                preparedStatement = connection.prepareStatement(sql);
                ResultSet rs= preparedStatement.executeQuery();

                while(rs.next()){  
                    Person person=new Person();
                    person.setUsername(rs.getString(2));
                    person.setLastName(rs.getString(7));   
                    person.setFirstName(rs.getString(6)); 
                    person.setEmail(rs.getString(9));
                    person.setAge(rs.getInt(8)); 
                    persons.add(person);  
                    listOfNames.add(person.getFirstName());
                    listOfNames.add(person.getLastName());
                }
            } 
         } catch (Exception e) {

         } finally {
            if (preparedStatement != null) try { preparedStatement.close(); } catch (SQLException ignore) {}
            if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
         }

         return SUCCESS;
    }

    public String displayUser() {
        
        nameInput = getNameInput();
        if(nameInput.length() != 0){
            Connection con = null;
                PreparedStatement ps = null;
                try{  
                    Class.forName("com.mysql.jdbc.Driver");  
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC","root","password");  
                    
                    if (con != null) {
                        ps = con.prepareStatement("select * from users where first_name =? or last_name=?");  
                        ps.setString(1, nameInput);
                        ps.setString(2, nameInput);
                        ResultSet rs=ps.executeQuery();  
                        Person person=new Person();
                        while(rs.next()){
                            person.setUserId(rs.getInt(1));
                            person.setUserType(rs.getString(4));
                            person.setUsername(rs.getString(2));
                            person.setLastName(rs.getString(7));   
                            person.setFirstName(rs.getString(6)); 
                            person.setEmail(rs.getString(9));
                            person.setAge(rs.getInt(8)); 
                            setAccountBean(person);
                        }
                    }

                }catch (Exception e) {

                } finally {
                if (ps != null) try { ps.close(); } catch (SQLException ignore) {}
                if (con != null) try { con.close(); } catch (SQLException ignore) {}
                }

                return SUCCESS;
            }

            else{
                return "error";
            }

    }
    
}
