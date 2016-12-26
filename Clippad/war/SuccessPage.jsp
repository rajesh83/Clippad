<%@page errorPage="ErrorPage.jsp"%>
<!doctype html>
<html lang="en">

<jsp:useBean id="success" scope="session" type="com.clippad.Success" />

<head>
<meta charset="UTF-8">
<title>${success.title}</title>
<link rel="stylesheet" type="text/css" href="Styles/global.css">
</head>

<body>
	<h3>${success.header}</h3>

	<p>${success.message}</p>

</body>