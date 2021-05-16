<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Blank</title>

<!-- Custom fonts for this template-->
<link href="/assests/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="/assests/css/sb-admin-2.min.css" rel="stylesheet">

<!--These jQuery libraries for 
           chosen need to be included-->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.4.2/chosen.min.css" />
<link href='/assests/dist/dropzone.css' type='text/css' rel='stylesheet'>
<link
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css"
	rel="stylesheet" />

<!--These jQuery libraries for select2 
  
            need to be included-->


</head>

<body id="page-top">

	<jsp:include page="header.jsp"></jsp:include>
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">
			<jsp:include page="nav.jsp"></jsp:include>


			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->
				<h1 class="h3 mb-4 text-gray-800 text-center">Add Support</h1>

			</div>
			<div class="container">
				<form action="saveTicket" method="POST" id="myform"
					enctype="multipart/form-data" class="dropzone" id="my-awesome-dropzone">
				<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
					Select a customer <select class="js-example-basic-single" name="customerVO.customer_id"
						style="width: 700px; margin: 10px 20px 30px;" >
						<c:forEach items="${detailsCustomer}" var="i">
							<option value="${i.customer_id}">${i.custromerName}</option>
						</c:forEach>
						<!-- <option value="1">India</option>
						<option value="2">Japan</option>
						<option value="3">France</option>
					 -->
					 </select>
					<div class="form-floating">
						<label for="floatingTextarea">Ticket Subject</label>

						<textarea class="form-control" placeholder="Leave a comment here"
							id="floatingTextarea" name="ticketTitle"></textarea>
					</div>
					<div class="form-floating">
						<label for="floatingTextarea">Ticket Description</label>

						<textarea class="form-control" placeholder="Leave a comment here"
							id="floatingTextarea" name="ticketDescription"></textarea>
					</div>
					<div id="myId">
						<label for="formFileLg" class="form-label">Large file
							input example</label> <input type="file" name="file" id="file" multiple/>

					</div>

						<input type="submit" value="submit" class="btn btn-danger">
					
				</form>
			</div>
		</div>

		<!-- End of Main Content -->

		<!-- Footer -->
		<footer class="sticky-footer bg-white">
			<div class="container my-auto">
				<div class="copyright text-center my-auto">
					<span>Copyright &copy; Your Website 2020</span>
				</div>
			</div>
		</footer>
		<!-- End of Footer -->

	</div>
	<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
		</div>
	</div>
	<!-- Bootstrap core JavaScript-->
	<script src="/assests/vendor/jquery/jquery.min.js"></script>
	<script src="/assests/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/assests/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/assests/js/sb-admin-2.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.1/js/select2.min.js">
		
	</script>
	<script src="/assests/dropzone-5.7.0/dist/dropzone.js"></script>

	<script>
	Dropzone.autoDiscover = false;
		$(document).ready(function() {
			$('.js-example-basic-single').select2();
			 /* $("div#myId").dropzone({
				url : "/file/post"
 			}); */

		});

				
			
	</script>

</body>

</html>