<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
  
<h3>All User Records:</h3>  
<s:iterator  value="persons">  
<fieldset>  
<s:property value="firstName"/><br/>  
<s:property value="lastName"/><br/>  
<s:property value="email"/><br/>
<s:property value="age"/><br/>  
</fieldset>  
</s:iterator>
<p><a href="<s:url action='index' />" >Return to home page</a>.</p>  