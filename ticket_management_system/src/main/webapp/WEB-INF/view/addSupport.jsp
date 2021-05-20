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
<link
	href="https://cdn.jsdelivr.net/npm/select2@4.1.0-rc.0/dist/css/select2.min.css"
	rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="/assests/css/style.css">


<!--These jQuery libraries for select2 
  
            need to be included-->

</head>

<body id="page-top" class="p-0">

	<jsp:include page="header.jsp"></jsp:include>
	<!-- Content Wrapper -->
	<div id="content-wrapper" class="d-flex flex-column">

		<!-- Main Content -->
		<div id="content">
			<jsp:include page="nav.jsp"></jsp:include>


			<!-- Begin Page Content -->
			<div class="container-fluid">

				<!-- Page Heading -->

				<!--view all the details of the support ticket here using datatable -->
				<div class="col-lg-7 container">
					<div class="p-7 m-3">
						<div class="text-center">
							<h1 class="h4 text-gray-900 mb-4">Add Support Here</h1>
						</div>
						<form class="user" action="saveticket" method="POST" class="dropzone" id="file_upload"
											class="dropzone needsclick dz-clickable"
											enctype="multipart/form-data">

							<div class="form-group row">
								<div class="col-sm-6">
									<div class="form-group" style="width: 270px;margin-top:10px">
										<label>Select Customer</label> 
										<select id='mySelect2' name="customerVO.customerId" class="form-control">
											<option value='0'>CustomerName</option>
											
									    </select>
									</div>
								</div>
								<!-- add class=form-control in select2 -->
								<div class="col-sm-6">
									<label for="title">Enter Ticket title</label> <input
										type="text" class="form-control" id="exampleTextInput"
										placeholder="Enter Ticket Title" name="ticketTitle" style="margin-top:10px; width: 270px;">
								</div>
							</div>

							<div class="form-group row">
								<div class="form-group" style="width: 100%; height: 10%;">
									<label for="ticketDescription">Enter Ticket Description</label>
									<textarea class="form-control" name="ticketDescription"></textarea>
								</div>
							</div>
							<div class="form-group row">
								<div class="form-group">
									<label>Choose a File From Here</label> <input type="file" name="file" class="form-control text-center">
								</div>
								
							</div>
							<!-- <a href="#" class="btn btn-primary btn-user btn-block">
								Submit </a> -->
							<button type="submit" value="submit" class="btn btn-primary btn-user btn-block">Submit</button>
							<hr>

						</form>

					</div>
				</div>
			</div>



		</div>

		<!-- End of Main Content -->

		<!-- Footer -->
		<jsp:include page="footer.jsp"></jsp:include>
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
		<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
		<script
			src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
		<script src="/assests/js/jquery.spring-friendly.js"></script>
		<script src="/assests/js/main.js"></script>

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
			$(document).ready(function(){
				//$("#mySelect2").select2();
				  $("#mySelect2").select2({
				      placeholder: "Search CustomerName",
				      allowClear: 1,
				      ajax: {
				          url: "/customer/select/json",
				          dataType: "json",
				          type: "GET",
				          delay: 250,
				          data: function (e) {
				              return {
				                  customerName: e.term,
				                  page: e.page,
				                  
				              }
				          },
				          processResults: function (e, t) {
				              return t.page = t.page || 1, {
				                  results: e.items,
				                  pagination: {
				                      more: 30 * t.page < e.total_count
				                  }
				              }
				          },
				          cache: !0
				      },
				      escapeMarkup: function (markup) {
				          return markup;
				      },
				      
				      minimumInputLength: 3,
				      templateResult: function (e) {

				          if (e.loading) return e.text;

				          return e.text
				      },
				      templateSelection: function (data, container) {
				          return data.text;
				      }
				  });
			});
 	
 </script>

</body>

</html>