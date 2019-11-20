<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-8nq3OiMMgrVFAHyRMMO+DTfMEciSY+c3Awhj/5ljQ1xck1Uv2BUtMjsjLD8GT5Er" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div id="container">
    <%@ include file="fragments/header.jsp"%>
 
    <div id="container">
        <h1>Login Credentials</h1>
        <form id="input" method="post" action="login">
            <%
                String value = "", checkbox = "";
                Cookie[] cookies = request.getCookies();
                if(cookies != null){
                    for(Cookie c : cookies){
                        if(c.getName().equals("userCookie")){
                            value = c.getValue();
                            checkbox = "checked";
                            break;
                        }
                    }
                }
                //  value = request.getCookies()[0].getValue();
            %>
            User Name:
            <input id="userName" name="userName" required value='<%=value%>'/></br></br>
            Password:
            <input id="password" name="password" type='password' required/></br></br>
            <div id="warn">

            </div>
            <button id="btn" type="button">Login</button>
            <input id="submitBtn" type="submit" hidden>
            <label><input id="cb" type='checkbox' name='remember' value="on" <%=checkbox%>/> Remember Me</label>
        </form>
    </div>

    <%@include file="fragments/footer.jsp"%>
</div>

</body>
</html>
