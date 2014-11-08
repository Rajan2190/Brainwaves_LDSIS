<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/Socgen.css" rel="stylesheet">
<title>ABC Bank</title>

</head>
<body>
	<h1 align="center">ABC Bank</h1>
	<div class="container" style="margin-top: 10%; margin-left: 40%">
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">
						<strong>Sign In </strong>
					</h3>
				</div>
				<div class="panel-body">
					<form role="form" action="CheckDetails" method="post">
						<div class="form-group">
							<label for="CustomerID">Customer ID</label> <input
								type="text" class="form-control" id="CustomerID"
								name="CustomerID" placeholder="Enter Customer ID">
						</div>
						<div class="form-group">
							<label for="Password">Password </label> <input
								type="password" class="form-control" id="Password"
								name="Password" placeholder="Password">
						</div>
						
						<button type="submit" class="btn btn-sm btn-default">Login</button>
					</form>
				</div>
			</div>
		</div>
		<script src="dist/js/jquery.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
</body>
</html>