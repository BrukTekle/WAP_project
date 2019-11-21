<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Check Mail</title>
<link href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/solar/bootstrap.min.css" rel="stylesheet" integrity="sha384-8nq3OiMMgrVFAHyRMMO+DTfMEciSY+c3Awhj/5ljQ1xck1Uv2BUtMjsjLD8GT5Er" crossorigin="anonymous">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <%@ include file="fragments/header.jsp"%>
<!--     <div class="container"><br/> -->
<!--         <h2>List of Customer</h2> -->
<!--         <table class="table"> -->
<!--             <thead> -->
<!--             <tr> -->
<!--                 <th scope="col">mail id</th> -->
<!--                 <th scope="col">Customer name</th> -->
<!--                 <th scope="col">delivery Date</th> -->
<!--                 <th scope="col">sender</th> -->
<!--                 <th scope="col">delivered By</th> -->
<!--                 <th scope="col">status</th> -->
<!--                 <th scope="col">Send notification</th> -->
<!--             </thead> -->
<!--             <tbody> -->
<%--                 <c:forEach var="list" items="${mailList}" varStatus="iteration"> --%>
<!--                     <tr> -->
<%--                         <td><c:out value="${list.personId}"></c:out></td> --%>
<%--                         <td><c:out value="${list.firstName}"></c:out></td> --%>
<%--                         <td><c:out value="${list.lastName}"></c:out></td> --%>
<%--                         <td><c:out value="${list.email}"></c:out></td> --%>
<%--                         <td><c:out value="${list.tel}"></c:out></td> --%>
<%--                         <td><c:out value="${list.boxNumber}"></c:out></td> --%>
<%--                         <td><c:out value="${list.type}"></c:out></td> --%>
<!--                         <td><form action='./updateMailController' method='POST'> -->
<!--                         		<input type='submit' value="Send notification"/> -->
<%--                         		<input type='hidden' value='${list.personId}' name='mailId'/> --%>
<!--                         	</form> -->
<!--                         </td> -->
<!--                     </tr> -->
<%--                 </c:forEach> --%>
<!--             </tbody> -->
<!--         </table> -->
<!--     </div> -->


<!-- 	============================================================== -->
	<div class="container"><br/>
	<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
			  <thead>
			    <tr>	
			      
			      <th scope="col" class="th-sm">Person id</th>
                <th scope="col" class="th-sm">First name</th>
                <th scope="col" class="th-sm">Last Name</th>
                <th scope="col" class="th-sm">Email</th>
                <th scope="col" class="th-sm">Tel</th>
                <th scope="col" class="th-sm">Box number</th>
                <th scope="col" class="th-sm">Type</th>
                <th scope="col" class="th-sm">send notification</th>
                
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach var="list" items="${mailList}" varStatus="iteration">
                    <tr>
                        <td><c:out value="${list.personId}"></c:out></td>
                        <td><c:out value="${list.firstName}"></c:out></td>
                        <td><c:out value="${list.lastName}"></c:out></td>
                        <td><c:out value="${list.email}"></c:out></td>
                        <td><c:out value="${list.tel}"></c:out></td>
                        <td><c:out value="${list.boxNumber}"></c:out></td>
                        <td><c:out value="${list.type}"></c:out></td>
                        <td><form action='AdminAddMailController' method='GET'>
                        		<input type='submit' value="Send notification"/>                     		
                        		<input type='hidden' value='${list.personId}' name='personId1'/>
                        	</form>
                        </td>
                    </tr>
                </c:forEach>
			    		    
			  </tbody>
<!-- 			  <tfoot> -->
<!-- 			    <tr> -->
<!-- 			      <th>Name -->
<!-- 			      </th> -->
<!-- 			      <th>Position -->
<!-- 			      </th> -->
<!-- 			      <th>Office -->
<!-- 			      </th> -->
<!-- 			      <th>Age -->
<!-- 			      </th> -->
<!-- 			      <th>Start date -->
<!-- 			      </th> -->
<!-- 			      <th>Salary -->
<!-- 			      </th> -->
<!-- 			    </tr> -->
<!-- 			  </tfoot> -->
			</table>
		</div>

	
	
    <%@include file="fragments/footer.jsp"%>
         <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script> 
     <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script> 
     <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script> 
    <script src="js/app.js"></script>
</body>
</html>
