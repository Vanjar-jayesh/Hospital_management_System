<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Signup page</title>
<%@include file="componet/allcss.jsp" %>
  
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0.3);
}

</style>
</head>
<body>
<%@include file="componet/navbar.jsp" %>

<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">User Register</p>
						
						<c:if test="${not empty sucMsg}">
						
						<p class="text-center text-success fs-3">${sucMsg}</p>
						<c:remove var="${sucMsg}"/>
						</c:if>
						
						
							<c:if test="${not empty ErrorMsg}">
						
						<p class="text-center text-success fs-3">${ErrorMsg}</p>
						<c:remove var="${ErrorMsg}"/>
						</c:if>
						
						<form action="User_Rigister" method="post">
						<div class="mb-3">
								<label class="form-label"> name</label> <input required
									name="name" type="text" class="form-control">
							</div>
							
							<div class="mb-3">
								<label class="form-label">email</label> <input required
									name="email" type="email" class="form-control">
							</div>
							
							
							<div class="mb-3">
								<label class="form-label">Password</label> <input required
									name="password" type="password" class="form-control">
							</div>
							<button type="submit" class="btn bg-success text-white col-md-12">Register</button>
						</form>		
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>
