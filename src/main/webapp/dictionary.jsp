<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Dictionary</title>
    <link rel="stylesheet" href="css/styles.css">
  </head>
  <body>
      <s:include value="navbar.jsp"/>
      <main>
        
        <h1>Dictionary</h1>
        <p><a href="<s:url action='news'/>">View news</a></p>   
        <p><a href="<s:url action='dictionary'/>">View Dictionary</a></p>   


        <s:iterator value="DictionaryResponse.definitions">
        <fieldset>
            <s:property value="word"/>
            <h3><s:property value="definition"/></h3>
            <s:property value="partOfSpeech"/>
        </fieldset>
        </s:iterator>

      </main>
      <footer>
      </footer>
  </body>
</html>
