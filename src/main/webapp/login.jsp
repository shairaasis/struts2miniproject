<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login</title>
</head>

<body>
    <s:include value="navbar.jsp"/>
    <div class="container">
        <h3>Login</h3>
        <s:form action="Login">
        <p style="color: red; float: left;"><s:property value="errorMessage" /> </p>
        <s:textfield name="accountBean.username" label="Username"/>
        <s:password name="accountBean.password" label="Password" />
        <s:submit key="submit" value="Login" style="padding: 5px; background-color:#004C64; color: white; border: none;"/>
        </s:form>
    </div>
</body>
</html>
