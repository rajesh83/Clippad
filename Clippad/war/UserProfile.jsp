<%@page errorPage="ErrorPage.jsp"%>

<!doctype html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>User Profile Details</title>

<link rel="stylesheet" type="text/css" href="Styles/global.css">
<link rel="stylesheet" type="text/css" href="Styles/UserProfile.css">

<script src="Scripts/UserProfile.js" type="text/javascript"></script>

</head>

<% String mode = request.getParameter("mode");
   if (mode != null) {
      if (mode.equals("signup")){
         session.removeAttribute("user");
      }
      else {
         request.setAttribute("readOnly","readOnly"); 
      }      
      request.setAttribute("mode",mode);   
   }   
%>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>Enter/Edit user profile details..</h1>
		</div>
		<div id="details">
			<div id=error>${error}</div>
			<div id="user-form">
				<form name="userform" onSubmit="return validate();" method="post"
					action="Signup">
					<p>
						<label>User id</label><input type="text" name="user"
							value="${user.user}" ${readOnly}> <br>
					</p>
					<p>
						<label>Password</label> <input type="password" name="pswd"
							value="${user.pswd}"><br>
					</p>
					<p>
						<label> Re-type password</label> <input type="password"
							name="repswd" value="${user.pswd}"><br>
					</p>
					<p>
						<label>Name</label> <input type="text" name="name"
							value="${user.name}"><br>
					</p>
					<p>
						<input type="submit" value="Submit">
					</p>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
