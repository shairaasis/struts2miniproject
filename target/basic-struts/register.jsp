<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="css/styles.css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Register</title>
  </head>
  <body>
    <s:include value="navbar.jsp"/>
    <div class="container">
    <h3>Register an account by completing this form.</h3>

    <s:form action="register">
      <s:textfield name="personBean.username" label="Username" />
      <s:password name="personBean.password" label="Password" /> 
      <s:textfield name="personBean.firstName" label="First name" />
      <s:textfield name="personBean.lastName" label="Last name" /> 
      <s:textfield name="personBean.age"  label="Age"  />
      <s:textfield name="personBean.email"  label ="Email"/> 
      <s:submit style="padding: 5px; background-color:#004C64; color: white; border: none;"/>
    </s:form>
  </div>
  </body>
</html>