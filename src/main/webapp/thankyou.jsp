<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Registration Successful</title>
  </head>
  <body>
    <s:include value="navbar.jsp"/>
    <main>
    <h3>Thank you for registering an account <s:property value="personBean.firstName" />.</h3> 
    <p><s:a href="login.jsp">Continue to Login.</s:a></p> 
    </main>
  </body>
</html>