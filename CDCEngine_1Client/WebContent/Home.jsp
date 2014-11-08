<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="dist/css/bootstrap.min.css" rel="stylesheet">
<link href="css/Socgen.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<%String token=(String)request.getAttribute("tokenID"); %>

	<FORM METHOD="post" ACTION="DigitalToken">
		<TABLE BORDER="0" align="center">
			<tr>
				<td><label>Account Number: </label> <%=request.getParameter("AccountNo") %></td>
				
			</tr>
			<tr>
				<td><label>Balance: </label><%=request.getParameter("Balance") %></td>
				
			</tr>
			<TR>
				<input type="hidden" name="AccNo" value="<%=request.getParameter("AccountNo") %>"/>
				<td><input type="text" class="form-control" id="Amount"	name="Amount" placeholder="Amount"></td>
				<TD><INPUT TYPE="submit" VALUE="Get Digital Cash"></TD>
			</tr>

		</TABLE>
	</FORM>
	<FORM METHOD="post" ACTION="http://www.cnn.com">
		<TABLE BORDER="0" align="center">
			<tr>
				<TD><input id="txtSearch" name="txtSearch" type="text" value="<%=token %>" />
				</TD>

				<TD><INPUT TYPE="submit" VALUE="Use Digital Cash"></TD>
			</tr>
			<tr>
				<TD><INPUT TYPE="submit" VALUE="Show Tokens"></TD>
			</tr>

		</TABLE>
	</FORM>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="dist/js/bootstrap.min.js"></script>
	<script src="js/Socgen.js"></script>
</body>
</html>
