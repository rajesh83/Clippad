<%@page errorPage="ErrorPage.jsp"%>
<!doctype html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="Styles/global.css">
<link rel="stylesheet" type="text/css" href="Styles/Login.css">

<script src="Scripts/Login.js" type="text/javascript"></script>
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h1>Log in to Clippad..</h1>
		</div>
		<div id="details">
			<p>
			<form id="login-form" name="loginform" method="post" action="Login">
				<div id=error>${login.error}</div>
				<p>
					<span class="lable">Username</span> <input type="text" name="user"
						value=${login.user}> <br> 
					<span class="lable">Password</span>	<input type="password" name="pswd"><br>
				<p>
					<input type="submit" value="login" onClick="return validate();">
				<p>
					New User? <a href=UserProfile.jsp?mode=signup> Sign up! </a>
			</form>
		</div>
	</div>
</body>
</html>
