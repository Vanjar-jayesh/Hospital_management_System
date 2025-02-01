<%@page import="com.emtity.Specalist"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.db.SpecialistDao"%>
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
<%@include  file="navbar.jsp"%>

<div class="contaniner-fluid p-3">
		
		<div class="row">
		
				<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Doctor</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form action="../addDoctor" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label> <input type="text"
									required name="fullname" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label> <input type="date"
									required name="dob" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label> <input required
									name="qualification" type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Specialist</label> <select name="spec"
									required class="form-control">
									<option>--select--</option>
									
									<%
									
									  SpecialistDao dao = new SpecialistDao(DBConnect.getconn());
									     List<Specalist> list = dao.getAllSpecilist();
									     
									     for(Specalist s : list)
									     {%>
									     
									    	 <option><%=s.getSpecialistName()%></option>
									     <%}
									    %>
									
									
									
								</select>
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text"
									required name="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text"
									required name="mobno" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
			
			
			<div class="col-md-8">
			<div class="card paint-card">
				<div class="card-body">
					<p class="fs-3 text-center">Doctor Details</p>
					<table class="table">
						
						<thead>
							<tr>
								
								<th scope="col">Full Name</th>
								<th scope="col">DOB</th>
								<th scope="col">Qualification</th>
								<th scope="col">Specialist</th>
							    <th scope="col">Email</th>
								<th scope="col">Mob No</th>
								<th scope="col">Password</th>
								
														
							
							</tr>
					
					</table>
				</div>
			</div>
			</div>
					
	</div>

</div>

</body>
</html>