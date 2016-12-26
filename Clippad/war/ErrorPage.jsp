<%@page isErrorPage="true"%>

<html>
<head>
<title>An Error Has Occurred!</title>
<link rel="stylesheet" type="text/css" href="Styles/global.css">
</head>

<%
String message;
if((exception.getMessage() == null) || exception.getMessage().equals("")){
	message = exception.toString();
}
else {
	message = exception.getMessage();
}
%>

<body>
	<h3>An Error Has Occurred</h3>

	<p>
		Sorry, but this site is unavailable to render the service you
		requested. A bug in the system has caused an error to occur. Please
		send a description of the problem to <strong><%=application.getInitParameter("admin-email")%></strong>
		with, <strong>"<%=message%>"
		</strong>, listed as the cause of the error.
	</p>
</body>
</html>

