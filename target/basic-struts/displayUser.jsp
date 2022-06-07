<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="s" uri="/struts-tags" %>

<html> 
    <head>
        
        <style>
            body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            }
            main {
            padding: 5%;
            background: white;
            color: #00242f;
            }
            .item1 { grid-area: greet;}
            .item2 { grid-area: profile; }
            .item3 { grid-area: bio; }
            .item4 { grid-area: revenue; }
       

            .grid-container {
            display: grid;
            grid-template-areas:
                'greet greet greet greet greet greet'
                'profile profile bio bio bio bio'
                'profile profile revenue revenue revenue revenue';
                gap: 5px;
                padding: 0 5px;
                background-color: #c2d9e065;
            }

            .grid-container > div {
            text-align: left;
            padding: 10px 20px;
            background-color: #0086af20;
            }
            .item1{
                text-align: center;
            }
        </style>
            <title>Profile</title>

        
    </head>
<body>
    
<main>
    <div class="grid-container">
        <s:set var="activeAccount" value="accountBean" />
        <div class="item1">
            <h1>PROFILE</h1>
            <p>First name: <s:property value="#activeAccount.firstName" /> Last Name: <s:property value="#activeAccount.lastName" /> </p>
        </div>
        <div class="item2">
            <img style="width: 150px; height: 150px;" src="https://cdn-icons-png.flaticon.com/512/149/149071.png" alt="profilepic">
            <h1><s:property value="#activeAccount.firstname" /> <s:property value="#activeAccount.lastname" /></h1>
            <p>@<s:property value="#activeAccount.username" /></p>
            <p><s:property value="#activeAccount.email" /></p>
            <p><s:property value="#activeAccount.age" /></p>
        </div>

        <s:set var="accountType" value="accountBean.userType" />
        <s:if test='%{#accountType == "1"}'>
            <div class="item3">
                <h1>User Type</h1>
                <p><s:property value="#activeAccount.userType" /></p>
            </div>
            <div class="item4">
                <h4>This user is an admin.</h4>   
                <p><a href="<s:url action='list'/>">Display user list</a></p>                    
                <h1>Revenue</h1>
                <h4>Yearly Revenue</h4>
                <p>P10,000,000.00</p>

                <h4>Monthly Revenue</h4>
                <p>P1,000,000.00</p>

                <h4>Daily Revenue</h4>
                <p>P33,000.00</p>
            </div>
        </s:if>
        <s:elseif test='%{#accountType == null}'>
            <div class="item3">
                <h1>User Type</h1>
                <h1>This user is not an admin.</h1>       
            </div>                
        </s:elseif>
        

    </div>
    <p><a href="<s:url action='list'/>">Display user list</a></p>   
</main>

</body>
</html>