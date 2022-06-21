<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>

<body>
    <s:include value="navbar2.jsp"/>
    <!-- ======= Contact Section ======= -->
    <main class="container">
    <section id="contact" class="contact section-bg" style="width: 50%; padding: 20px;
    margin: 50px 30%;">
   
        <div class="section-title">
            <br><br>
            <p style="text-align:center;">Login</p>
        </div>
  
            <div class="col-lg-6" style="width: 200%;
            margin-left: 50px;">
                <s:form action="login">
                   
                        <p style="color: red; float: left;"><s:property value="errorMessage" /> </p>
                        <div class="form-group mt-3" style="margin: 0px, 50%;">
                        <s:textfield name="accountBean.username" label="Username" class="form-control"/>
                        <s:password name="accountBean.password" label="Password" class="form-control"/>
                        </div>
                        <s:submit key="submit" value="Login" style="background: #ed502e;
                        border: 0; float: right;
                        padding: 5px 15px;
                        border-radius: 4px;
                        color: #fff;
                        transition: 0.4s;"/>
                  
                </s:form>
                <!-- <p><a href="https://alta.hub.loginradius.com/auth.aspx?action=login&return_url=https://alta.hub.loginradius.com/profile.aspx">Login via LoginRadius</a></p> -->
                <p><a href="https://alta.hub.loginradius.com/auth.aspx?action=register&return_url=http://localhost:8080/basic-struts/loginToken">Login via LoginRadius</a></p>
                <!-- <p><a href="https://alta.hub.loginradius.com/auth.aspx?action=logout&return_url=http://localhost:8080/basic-struts/index.jsp">Logout</a></p> -->
                <!-- <p>Token: <s:property value="token" /></p> -->

            </div>
  
    
  
        </div>
    </section><!-- End Contact Section -->
    </main>
        <!-- <section id="contact" class="contact section-bg">
            <div class="container">
            <h3>Login</h3>
            <s:form action="Login" class="php-email-form">
            <p style="color: red; float: left;"><s:property value="errorMessage" /> </p>
            <s:textfield name="accountBean.username" label="Username" class="form-group mt-3"/>
            <s:password name="accountBean.password" label="Password" class="form-group mt-3"/>
            <s:submit key="submit" value="Login" style="padding: 5px; background-color:#004C64; color: white; border: none;"/>
            </s:form>
            </div>
            </section> -->
</body>
</html>
