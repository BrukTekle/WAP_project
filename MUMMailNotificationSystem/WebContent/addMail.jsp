<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add mail</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-8nq3OiMMgrVFAHyRMMO+DTfMEciSY+c3Awhj/5ljQ1xck1Uv2BUtMjsjLD8GT5Er" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp"%>
    
    <div class="container"><br/>
        <form id="formCustomerContact" method="post" action="AdminAddMailController">
            <fieldset>
                <legend>Add Mail</legend>
                <c:if test="${isErrMsgsPresent}">
                    <div>
                        <p>
                            ${errMsgs}
                        </p>
                    </div>
                </c:if>
                <div class="form-group">
                    <label for="deliveredDate">Delivered Date:</label>
                    <input type="date" class="form-control" name="deliveredDate" autofocus>
                </div>
                <div class="form-group">
                    <label for="sender">Sender:</label>
                    <input type="text" class="form-control" name="sender">
                </div>
                <div class="form-group">
                    <label for="deliveredBy">Delivered By:</label>
                    <input type="text" class="form-control" name="deliveredBy">
                </div>
             	<input type='hidden' value='${personId}' name='personId'/>
                <button id="btnSubmit" type="submit" class="btn btn-primary btn-block">Send Notification</button>
            </fieldset>
        </form>
    </div>


    <%@include file="fragments/footer.jsp"%>
</body>
</html>
