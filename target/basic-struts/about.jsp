<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        
        <style>
            body {
            font-family: Arial, Helvetica, sans-serif;
            margin: 0;
            }
            main {
            padding: 232px 200px;
            text-align: center;
            background: white;
            color: #00242f
            }
            h1 {
                font-size: 60px;
            }
        </style>
            <title>About</title>
    </head>
    <body>
            <s:include value="navbar.jsp"/>
            <main>
                    <h1>A LEGACY OF EXCELLENCE</h1>
                    <p><s:property value="websiteDescr" /></p>
            </main>
            <footer>
            </footer>    
</body>
</html>