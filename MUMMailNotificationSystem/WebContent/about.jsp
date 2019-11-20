<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About</title>
	<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-8nq3OiMMgrVFAHyRMMO+DTfMEciSY+c3Awhj/5ljQ1xck1Uv2BUtMjsjLD8GT5Er" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <%@ include file="fragments/header.jsp"%>

    <div class="container">
        <div class="container">
            <br/>
            <span style="float:right;" class="text-muted"><c:out value="${currDateTime}"></c:out></span>
        </div>
        <p>
            <br/>
            <div class="card">
                <div class="card-header">
                    <h2>Team Members:</h2>
                </div>
                <div class="card-body">
                    <h4 class="card-title">Name: <c:out value="${contactFormData.name}"></c:out></h4>
                    <br/>
                    <h5 class="card-subtitle mb-2 text-muted">Gender: <c:out value="${contactFormData.gender}"></c:out></h5>
                    <br/>
                    <h5 class="card-subtitle mb-2 text-muted">Category: <c:out value="${contactFormData.category}"></c:out></h5>
                    <br/>
        <p class="card-text">Message: <c:out value="${contactFormData.message}"></c:out></p>
        <br/><br/>
        <p>Please feel free to <a href="./contact-form" class="card-link">Contact Us</a> again</p>
    </div>
    </div>
    </p>
    <div class="container">
        <span class="text-muted">Hit Count for this page: 1</span>
        <span style="float:right;" class="text-muted">Total Hit Count for the entire WebApp: 8</span>
    </div>
    </div>

    <%@include file="fragments/footer.jsp"%>

</body>
</html>
