<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>

section {
    padding: 10px 0;
    text-align: center;
}
select.frecuency {
    border: none;
    font-style: italic;
    background-color: transparent;
    cursor: pointer;
    -webkit-transform: translateY(0);
    transform: translateY(0);
    -webkit-transition: -webkit-transform .35s ease-in;
    transition: -webkit-transform .35s ease-in;
    border-bottom: none;
}
select.frecuency:focus {
    outline: none;
    border-bottom: 5px solid #39b3d7;
    -webkit-transform: translateY(-5px);
    transform: translateY(-5px);
    -webkit-transition: -webkit-transform .35s ease-in;
    transition: -webkit-transform .35s ease-in;
}
.free {
    text-transform: uppercase;
}
.input-group {
    margin: 20px auto;
    width: 100%;
    
}
input.btn.btn-lg,
input.btn.btn-lg:focus {
    outline: none;
    width: 60%;
    height: 60px;
    border-top-right-radius: 0;
    border-bottom-right-radius: 0;
}
button.btn {
    width: 40%;
    height: 60px;
    border-top-left-radius: 0;
    border-bottom-left-radius: 0;
}
.promise {
    color: #999;
}

</style>

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
<body background="sativa.png">

<%
	String token=(String)request.getAttribute("tokenID"); 
	String custid=(String)session.getAttribute("CustomerID");
	String accno=(String)session.getAttribute("AccountNo");
	String balance=(String)session.getAttribute("balance");
%>
<h1 align="center">Welcome to ABC Bank</h1>
<label>Account Number: </label> <%=(accno!=null)?accno:"12345" %>
<label>Balance: </label><%=(balance!=null)?balance:"10000" %>
<section>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
         <div class="well">
             <form action="DigitalToken" method="post">
              <div class="input-group">
              		<input type="hidden" name="AccNo" value="<%=(accno!=null)?accno:"12345" %>"/>
                 <input class="btn btn-lg" name="Amount" id="Amount" type="text" placeholder="Amount" required>
                 <button class="btn btn-info btn-lg" type="submit">Get Digital Cash</button>
                 
              </div>
             </form>
    	 </div>
           <label id="tokenval" name="tokenval"><%=(token!=null)?token:"" %> </label>
           
		</div>
		<div class="col-md-6 col-md-offset-3">
         <div class="well">
             <form action="UseToken" method="post">
              <div class="input-group">
                 <input class="btn btn-lg" name="token" id="txtSearch" type="text" placeholder="Token" required>
                 <button class="btn btn-info btn-lg" type="submit">Use Digital Cash</button>
              </div>
             </form>
    	 </div>
         
		</div>
	</div>
</div>
</section>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="dist/js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="dist/js/bootstrap.min.js"></script>
	<script src="js/Socgen.js"></script>
</body>
</html>
