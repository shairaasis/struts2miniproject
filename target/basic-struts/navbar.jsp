<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <link rel="stylesheet" href="css/styles.css">
    <body>
        <div class="navbar">
          <s:url var="indexPage" value="/" />
          <s:a href="index.jsp" class="logo">AltaSofia</s:a>
          <s:a href="register.jsp">Register</s:a>
          <s:a href="login.jsp">Login</s:a>
          <s:a href="contact.jsp">Contact</s:a>
          <s:a href="services.jsp">Services</s:a>
          <s:a href="about.jsp">About</s:a>
          <s:a href="index.jsp">Home</s:a>
      </div>
    </body>
</html>