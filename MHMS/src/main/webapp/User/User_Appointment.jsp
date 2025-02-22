<%@page import="comm.Dao.DoctorDao"%>
<%@page import="javax.print.Doc"%>
<%@page import="com.emtity.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <!--%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        -->
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

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("../img/mariuser1.png");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
img {
	box-sizing: border-box;
	border: 2px solid blue;
	border-radius: 9px;
	box-shadow: 0 0 10px 0 rgba(0,0,0.5);
}
</style>
</head>
<body>

<%@include  file="navbar.jsp"%>

	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 p-5">
				<img height="450px" alt="" src="../img/user1.jpg" >
			</div>

			<div class="col-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">User Appointment</p>
						 <c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						
						<form class="row g-3" action="../AppointmentServlet" method="post">

							<input type="hidden" name="userid" value="${UserObj.id }">
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Full Name</label> <input
									required type="text" class="form-control" name="fullname">
							</div>

							<div class="col-md-6">
								<label>Gender</label> <select class="form-control" name="gender"
									required>
									<option value="male">Male</option>
									<option value="female">Female</option>
								</select>
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Age</label> <input
									required type="number" class="form-control" name="age">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Appointment Date</label> <input type="date" class="form-control" required
									name="appointdate">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Aadhar Number</label> <input
									required type="number" class="form-control" name="AadharNumber">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Phone No</label> <input
									maxlength="10" required type="number" class="form-control"
									name="phno">
							</div>


							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Diseases</label> <input
									required type="text" class="form-control" name="diseases">
							</div>

							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Doctor</label> <select
									required class="form-control" name="doct">
									<option value="">--select--</option>
									
									<%
										//DoctorDao dao=new DoctorDao(DBConnect.getconn());
										DoctorDao dao=new DoctorDao(DBConnect.getconn());
										List<Doctor> list = dao.getAllDoctor();
										//List<Doctor> list = dao.getAllDoctor();
										for(Doctor d :list){
											%>
											
											<option value="<%=d.getId()%>"><%=d.getFullName() %>(<%=d.getSpecialist()%>)</option>
											
											<% 
										}
										
									%>
										
									
									
								</select>
							</div>

							<div class="col-md-12">
								<label>Full Address</label>
								<textarea required name="address" class="form-control" rows="3"
									cols=""></textarea>
							</div>

							<c:if test="${empty UserObj }">
								<a href="../User_login.jsp" class="col-md-6 offset-md-3 btn btn-success">Submit</a>
							</c:if>
                            
							<c:if test="${not empty UserObj }">
								<button class="col-md-6 offset-md-3 btn btn-success">Submit</button>
							</c:if>
							 
							<!--  <button class="col-md-6 offset-md-3 btn btn-success">Submit</button>-->
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@include file="../componet/footer.jsp"%>

</body>
</html>