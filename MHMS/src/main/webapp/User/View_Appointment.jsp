<%@page import="com.emtity.User"%>
<%@page import="com.oracle.wls.shaded.org.apache.bcel.generic.NEW"%>
<%@page import="comm.Dao.AppointmentDao"%>
<%@page import="com.emtity.Appointment"%>
<%@page import="javax.print.Doc"%>
<%@page import="com.emtity.Doctor"%>
<%@page import="comm.Dao.DoctorDao"%>
<%@page import="com.emtity.Specalist"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.db.SpecialistDao"%>
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
	 height:450px;
}
.b1{
background-color: red;
color: red;

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
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-success">Appointment
							List</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Gender</th>
									<th scope="col">Age</th>
									<th scope="col">Appoint Date</th>
									<th scope="col">Diseases</th>
									<th scope="col">Doctor Name</th>
									<th scope="col">Status</th>
								</tr>
							</thead>
								<tbody>
								<%
									//User id = (User)session.getAttribute("UserObj");
									User user =(User)session.getAttribute("UserObj");
								AppointmentDao dao=new AppointmentDao(DBConnect.getconn());
								DoctorDao dao2=new DoctorDao(DBConnect.getconn());
								
								//List<Appointment> list=dao.getPatient();
								
								List<Appointment>list=dao.getPatient(user.getId());
								
								for(Appointment ap:list)
								{
								
									Doctor d = dao2.getDoctorById(ap.getDoctorId());
								%>
								<tr>
									
									<th><%=ap.getFullname() %></th>
									<td><%=ap.getGender() %></td>
									<td><%=ap.getAge() %></td>
									<td><%=ap.getAppoinDate() %></td>
									<td><%=ap.getDiseases() %></td>
									<td><%=d.getFullName() %></td>
									<td>
									<%
									 
									   if("Pending".equals(ap.getStatus())){%>
										   <a href="#" class="btn btn-sm btn-worning">Pending</a>
									   <%}else{%>
										   <%=ap.getStatus() %>
									   <%}
									 
									 %>
									</td>
								
										
									
								</tr>
							
									
								<%}
								%>	
								
							</tbody>
					
						</table>

					</div>
				</div>
			</div>
			<div class="col-md-3 p-3">
				<img alt="" src="../img/user1.jpg">
			</div>
		</div>
	</div>

</body>
</html>
