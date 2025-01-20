<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index page</title>
<%@include file="componet/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0.3);
}

.img1{
	height: 340px;
	width: 200px;
}
</style>
</head>
<body>
	<%@include file="componet/navbar.jsp"%>

	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/mira.png" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/mira2.png" class="d-block w-100" alt="..."
					height="500px">
			</div>
			<div class="carousel-item">
				<img src="img/mira.png" class="d-block w-100" alt="..."
					height="500px">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>

	<div class="container p-3">
		<p class="text-center fs-3">Key Features of our Hospital</p>
		<div class="row">
			<div class="col-md-8 p-5">
				<div class="row">
					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">100% safety</p>
								<p>lorem ipsum dolor sit amet,consectetur adipisicing elit,
									Voluptatem,inventore</p>
							</div>
						</div>
					</div>

					<div class="col-md-6">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Clean Enviroment</p>
								<p>lorem ipsum dolor sit amet,consectetur adipisicing elit,
									Voluptatem,inventore</p>
							</div>
						</div>
					</div>

					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Friendly doctors</p>
								<p>lorem ipsum dolor sit amet,consectetur adipisicing elit,
									Voluptatem,inventore</p>
							</div>
						</div>
					</div>


					<div class="col-md-6 mt-2">
						<div class="card paint-card">
							<div class="card-body">
								<p class="fs-5">Medical Research</p>
								<p>lorem ipsum dolor sit amet,consectetur adipisicing elit,
									Voluptatem,inventore</p>
							</div>
						</div>
					</div>





				</div>
			</div>
			<div class="col-md-4">
				<img class="img1"  alt="" src="img/doctoimg.png">
			</div>
		</div>
	</div>

	<hr>
	<div class="container p-2">
		<p class="text-center fs-2">Our Team</p>
		<div class="row">
			<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/barmt.png" width="250px" height="300px">
						<p class="fu-bold fs-5">DR. M V Brahmbhat</p>
						<p class="fs-7">(CED & Chairman)</p>
					</div>
				</div>
			</div>
			
				<div class="col-md-3">
				<div class="card paint-card">
					<div class="card-body text-center">
						<img alt="" src="img/drraj.png" width="250px" height="300px" >
						<p class="fu-bold fs-5">DR.Rajan Bhagora</p>
						<p class="fs-7">(CED & Chairman)</p>
					</div>
				</div>
			</div>
		</div>
	</div>

<%@include file="componet/footer.jsp" %>
</body>
</html>