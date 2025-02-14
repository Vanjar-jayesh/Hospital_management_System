<%@page import="com.emtity.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="comm.Dao.AppointmentDao"%>
<%@page import="com.emtity.Appointment"%>
<%@page import="com.oracle.wls.shaded.org.apache.bcel.generic.AALOAD"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

      <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="../componet/allcss.jsp" %>
<style type="text/css">
.paint-card:hover {
	box-shadow: 0 0 10px 0 rgba(245,255,71);
   color:red; 
}



</style>

</head>
<body>
 <c:if test="${empty doctObj }">
   	<c:redirect url="../doctor_login.jsp"></c:redirect>
   </c:if>
<%@include  file="navbar.jsp"%>
<div class="container p-3">
<div class="row">
<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				
				<p class="fs-3 text-center">Patient Details</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment</th>
							<th scope="col">Aadhar Number</th>
							<th scope="col">Mob No</th>
							<th scope="col">Diseases</th>
							<th scope="col">Status</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					<%
						Doctor d = (Doctor)session.getAttribute("doctObj");
						AppointmentDao dao=new AppointmentDao(DBConnect.getconn());
						List<Appointment> list = dao.getallAppointmentsbyDoctorLoing(d.getId());
						
						
						for(Appointment ap :list){%>
							
						<tr>
							<th><%=ap.getFullname() %></th>
							<td><%=ap.getGender() %></td>
							<td><%=ap.getAge() %></td>
							<td><%=ap.getAppoinDate()%></td>
							<td><%=ap.getAadharNumber() %></td>
							<td><%=ap.getPhNo() %></td>
							<td><%=ap.getDiseases() %></td>
							<td><%=ap.getStatus()%></td>
							<td>
							
							<a href="#" class="btn btn-success btn-sm">Comment</a>
							
							</td>
						
						</tr>
						
							
							
						<%}
					%>
						
					

					</tbody>
				</table>

			</div>
		</div>
	</div>
</div>
</div>
</body>
</html>