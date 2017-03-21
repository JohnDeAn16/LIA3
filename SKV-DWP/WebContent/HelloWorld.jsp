<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet"
			href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<title>Insert title here</title>
		<style>
  			.hide { position:absolute; top:-1px; left:-1px; width:1px; height:1px; }
		</style>
	</head>
	<iframe name ="hiddenFrame" class="hide"></iframe>
	<body>
		<b>INSERT</b>
		<form action="${pageContext.request.contextPath}/DBModelTestServlet" method="GET">
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
		<b>SEARCH</b>
		<form action="SearchServlet" method="GET">
			<div class="form-group">
				<label for="id">ID:</label> <input type="number"
					class="form-control" id="id" name="id">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</body>
</html>