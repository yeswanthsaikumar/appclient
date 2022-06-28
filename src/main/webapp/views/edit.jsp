<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<title>Edit book page</title>
</head>
<body>
<!-- header -->

	<div class="container" style="min-height: 100vh">
		<form action="/home/update" method="post">
			<div class="text-center my-4 mb-5">
				<h3>Edit Book Details</h3>
			</div>
			
			<div class="form-group">
				<div class="row">
					<div class="col-5">
						<input type="hidden" class="form-control" id="id"
							name="id" value="${book.getId()}">
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-3">
						<label for="bookCode">Book Code</label>
					</div>
					<div class="col-5">
						<input type="text" class="form-control" id="bookcode"
							name="bookcode" value="${book.getBookcode()}" readonly>
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-3">
						<label for="bookName">Book Name</label>
					</div>
					<div class="col-5">
						<input type="text" class="form-control" id="bookname"
							name="bookname" value="${book.getBookname()}">
					</div>
				</div>
			</div>


			<div class="form-group">
				<div class="row">
					<div class="col-3">
						<label for="authorName">Author</label>
					</div>
					<div class="col-5">
						<input type="text" class="form-control" id="author"
							name="author" value="${book.getAuthor()}">
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="row">
					<div class="col-3">
						<label for="createdDate">Date</label>
					</div>
					<div class="col-5">
						<input type="Date" class="form-control" id="dateadded"
							name="dateadded" value="${book.getDateadded()}" >
					</div>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>&nbsp;&nbsp;
			<button type="reset" class="btn btn-warning">Cancel</button>
		</form>
	</div>
	
</body>
</html>