<%@ taglib prefix="s" uri="/struts-tags" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="css/styles.css">
</head>

<body>
    <s:include value="navbar.jsp"/>
    <div class="container">
        <h1>Login Page</h1>
        <s:form action="Login" namespace="/example">
        <s:textfield name="accountBean.username" />
        <s:password name="accountBean.password" />
        <s:submit key="submit" />
        </s:form>
    </div>

    
</body>
</html>
