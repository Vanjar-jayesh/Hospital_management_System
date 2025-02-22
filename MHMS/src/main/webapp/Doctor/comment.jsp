<%@page import="com.emtity.Appointment"%>
<%@page import="com.db.DBConnect"%>
<%@page import="comm.Dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../componet/allcss.jsp" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css">
<style type="text/css">
.paint-card:hover {
	box-shadow: 0 0 10px 0 rgba(245,255,71);
   color:red; 
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("../img/mariuser1.png");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>


</head>
<body>
   <c:if test="${empty doctObj }">
   	<c:redirect url="../doctor_login.jsp"></c:redirect>
   </c:if>
<%@include  file="navbar.jsp"%>


<div class="container-fulid backImg p-5">

		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">

			<div class="col-md-6 offset-md-3">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-4">Patient Comment</p>
						
						
						
						
						<%
							int id = Integer.parseInt(request.getParameter("id"));
							AppointmentDao dao = new AppointmentDao(DBConnect.getconn());
							
						     Appointment ap = dao.getallAppointmentsById(id);
						%>
						
						
						
						<form class="row" action="../UpdateStatus" method="post">
							<div class="col-md-6">
							
								<label>Patient Name</label> <input type="text" readonly
									value="<%=ap.getFullname() %>" class="form-control">
							</div>

							<div class="col-md-6">
								<label>Age</label> <input type="text" value="<%=ap.getAge() %>"
									readonly class="form-control">
							</div>


							<div class="col-md-6">
								<br> <label>Mob No</label> <input type="text" readonly
									value="<%=ap.getPhNo() %>" class="form-control">
							</div>

							<div class="col-md-6">
								<br> <label>Diseases</label> <input type="text" readonly
									value="<%=ap.getDiseases() %>" class="form-control">
							</div>

							<div class="col-md-12">
								<br> <label>Comment</label>
								<textarea required name="comm" class="form-control" row="3"
									cols=""></textarea>
							</div>
							<input type="hidden" name="id" value="<%=ap.getId() %>"> <input
								type="hidden" name="did" value="<%=ap.getDoctorId() %>">

							<button class=" mt-3 btn btn-primary col-md-6 offset-md-3">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>