<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>MUMMailNotificationSystem</title>
  <link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-8nq3OiMMgrVFAHyRMMO+DTfMEciSY+c3Awhj/5ljQ1xck1Uv2BUtMjsjLD8GT5Er" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp"%>
    <div class="container">
      <div class="jumbotron">
        <p>Welcome <c:out value="${userRole}"></c:out>, <c:out value="${user.userName}"></c:out> </p>
		  <c:if test="${user.userName==null}">
		  	<% response.sendRedirect("login.jsp"); %>
		  </c:if>
		  
		  
		  <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
			  <thead>
			    <tr>
			      <th class="th-sm">UserName
			
			      </th>
			     
			      <th class="th-sm">LoginDate
			
			      </th>
			      <th class="th-sm">LogoutDate
				  </th>
				  <th class="th-sm">IP Address
				  </th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var = "login" items = "${loginHistory}">
		  		<tr>
			      <td><c:out value = "${login.userName}"> </c:out></td>
			      <td><c:out value = "${login.loginDate}"> </c:out></td>
			      <td><c:out value = "${login.logOutDate}"> </c:out></td>
			      <td><c:out value = "${login.ipAddress}"> </c:out></td>
			      
		    	</tr>
			  </c:forEach>
			   
			  </tbody>
			  <tfoot>
			    <tr>
			      <th>UserName
			      </th>
			      <th>LoginDate
			      </th>
			      <th>LogoutDate
			      </th>
			      <th>IP Address
			      </th>
			     
			    </tr>
			  </tfoot>
			</table>
      </div>
      
      
      
    </div>
    <%@include file="fragments/footer.jsp"%>
    
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
     <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script> 
     <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script> 
    <script src="js/app.js"></script>
</body>
</html>
