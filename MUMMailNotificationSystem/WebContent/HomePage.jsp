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
		  
		  <c:if test="${userRole=='Admin'}">
		   <table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
			  <thead>
			    <tr>
			      <th class="th-sm">UserName
			
			      </th>
			     
			      <th class="th-sm">UserRole
			
			      </th>
			      <th class="th-sm">Person ID
				  </th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach var = "users" items = "${allUsers}">
		  		<tr>
			      <td><c:out value = "${users.userName}"> </c:out></td>
			      
			      <td>
			      	<c:choose>
					  <c:when test="${users.role == 1}">
					    <c:out value = "Administrator"> </c:out>
					  </c:when>
					  <c:when test="${users.role == 2}">
					    <c:out value = "Student"> </c:out>
					  </c:when>
					  <c:otherwise>
					     <c:out value = "Faculty"> </c:out>
					  </c:otherwise>
					</c:choose>
			      </td>
			      <td><c:out value = "${users.personId}"> </c:out></td>
		    	</tr>
			  </c:forEach>
			   
			  </tbody>
			  <tfoot>
			    <tr>
			      <th>Name
			      </th>
			      <th>UserRole
			      </th>
			      <th>Person ID
			      </th>
			      
			     
			    </tr>
			  </tfoot>
			</table>
		  </c:if>
		 		 
      </div>
      
      
      
    </div>
    <%@include file="fragments/footer.jsp"%>
    
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
     <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script> 
     <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script> 
    <script src="js/app.js"></script>
</body>
</html>
