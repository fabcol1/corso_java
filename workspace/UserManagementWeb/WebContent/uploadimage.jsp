<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
			<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
				<title>File Uploading Form</title>
				<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
					<link rel="stylesheet" href="css/main.css"></head>
				</head>
				<body>
					<%
	session.setAttribute("email", session.getAttribute("email"));
%>

						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
							Upload Image
						</button>

						<!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog modal-lg" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h4 class="modal-title" id="exampleModalLabel">Upload Image</h4>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>

									<div class="modal-body">
										<div class="file-loading">
											<form class="form-horizontal divwith" action="UploadServlet" method="Post" enctype="multipart/form-data">
												<input id="input-b9" name="file" type="file" accept=".jpg,.png"></div>
												<div id="kartik-file-errors"></div>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
												<input class="btn btn-primary" type="submit" value="Upload File"/>
											</div>
										</form>
									</div>
								</div>
							</div>
							<script>
								$(document).on('ready', function () {
									$("#input-b9").fileinput({
										showPreview: false,
										showUpload: false,
										elErrorContainer: '#kartik-file-errors',
										allowedFileExtensions: ["jpg", "png"]
										//uploadUrl: '/site/file-upload-single'
									});
								});
							</script>


							<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
							<script src="bootstrap/js/bootstrap.min.js"></script>
						</body>
