<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>News</title>
</head>
<body>
    <s:include value="navbar2.jsp"/>
    <main class="container" style="margin-top:10%;">
        <h1 style="text-align: center;">News Page</h1>
        <s:form action="search">
            <select name="language" label="Select Language" id="selectLanguage"> 
                <option value="-1">Select Language</option> 
                <option value="en">English</option> 
                <option value="tl">Tagalog</option> 
                <option value="zh">Chinese</option> 
                
            </select> 
            <select name="sortBy" id="sortBy"> 
                <option value="relevancy">Relevancy</option> 
                <option value="popularity">Popularity</option> 
                <option value="publishedAt">Published At</option> 
            </select>
        <s:textfield name="searchPhrase" label="Search News" />
        
        <s:submit key="submit" value="Search" style="padding: 5px; background-color:#004C64; color: white; border: none;"/>
        </s:form>
        
        <s:iterator value="newsResponse.articles">
            <fieldset>
                <s:property value="publishedAt"/>
                <h3><s:property value="title"/> by <s:property value="author"/></h3>
                <s:property value="description"/>
                <p>Read more: <a href="#"><s:property value="url"/></a></p>
            </fieldset>
        </s:iterator>

    </main>
</body>
</html>