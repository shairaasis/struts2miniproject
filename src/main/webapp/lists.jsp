<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>

<html>
  <head>
    <sx:head />
    <title>User Records</title>
    <link rel="stylesheet" href="css/styles.css">

    <style>
        #customers {
          font-family: Arial, Helvetica, sans-serif;
          border-collapse: collapse;
          width: 100%;
        }
        
        #customers td, #customers th {
          border: 1px solid #ddd;
          padding: 8px;
        }
        
        #customers tr:nth-child(even){background-color: #f2f2f2;}
        
        #customers tr:hover {background-color: #ddd;}
        
        #customers th {
          padding-top: 12px;
          padding-bottom: 12px;
          text-align: left;
          background-color: #004d64d6;
          color: white;
        }
        </style>
  </head>
  <body>
    <s:include value="navbar.jsp"/>
      <div class="container">
        <s:form action="displayUser">
        <sx:autocompleter
            label="Search a user"
            list="listOfNames"
            key="nameInput"
        /><s:submit style="padding: 5px; background-color:#004C64; color: white; border: none;"/>
        </s:form>

        <h3>All Users Records:</h3>  
         
        <table id="customers">
            
            
            <tr>
              <th>Name</th>
              <th>Username</th>
              <th>Email</th>
              <th>Age</th>
            </tr>

            <s:iterator  value="persons">  
                <tr>
                     
                    
                  <td><s:property value="lastName"/>, <s:property value="firstName"/></td>
                  <td><s:property value="username"/></td>
                  <td><s:property value="email"/></td>
                  <td><s:property value="age"/></td>
                
                </tr>
        </s:iterator>
              </table> 
        
        </div>
        <p><a href="<s:url action='index' />" >Return to home page</a>.</p>  
    </body>
</html>