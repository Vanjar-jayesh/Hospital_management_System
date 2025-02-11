<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      
  
      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../componet/allcss.jsp" %>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0.3);
}

</style>



</head>
<body>
   <c:if test="${empty doctObj }">
   	<c:redirect url="../doctor_login.jsp"></c:redirect>
   </c:if>
<%@include  file="navbar.jsp"%>
<h1>Doctor Dashboard</h1>
</body>
</html>