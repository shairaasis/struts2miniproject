<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1>Welcome!</h1>
    <p>Token: <s:property value="token" /></p>
    <p><a href="https://alta.hub.loginradius.com/auth.aspx?action=logout&return_url=http://localhost:8080/basic-struts/index.jsp">Logout</a></p>
</body>
</html>