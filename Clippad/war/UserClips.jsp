<%-- This JSP page displays the user details passed from the user-authentication page --%>
<%@page errorPage="ErrorPage.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="UTF-8">
<title>User Clips</title>

<link rel="stylesheet" type="text/css" href="Styles/global.css">
<link rel="stylesheet" type="text/css" href="Styles/UserClips.css">
<script src="Scripts/UserClips.js" type="text/javascript"></script>

</head>

<body>

	<div id="wrapper">
	
	  <div id="profile">
	  	<b>${user.user}</b><br>
	  	<a href="Logoff">logoff<a>
	  </div>

	  <div id="details">			
	  	<p> Hello <b>${user.name}</b>! </p>					
		<p> You have <b>${count}</b> stored clip-items:- </p>
		<p> <label id="msg"> </label> </p>
		<form name="clipsForm" id="clipsForm" method="post" action="Update">
			<ul id="clipList">
				<c:forEach var="clipItem" items="${user.clips}" varStatus="clip">
				    <li id="list${clip.index}"> 
				    	<img src="Images/copy-icon.png" height="16" width="16" alt="Copy" title="Copy" onClick="return copyClip('clip${clip.index}');">
				    	<textarea id="clip${clip.index}" rows="1" cols="30" name="clip" readOnly>${fn:escapeXml(clipItem)}</textarea> 
				    	<img src="Images/edit-icon.png" height="16" width="16" alt="Edit" title="Edit" onClick="return editClip('clip${clip.index}');">
				    	<img src="Images/dustbin-icon.png" height="16" width="16" alt="Delete" title="Delete" onClick="return deleteClip('list${clip.index}');">
				    </li> 
				</c:forEach>
			</ul>	
		</form>		
		<button onClick="return addAnotherClip();">Add a clip</button>	  	
	  	</div>	
	</div>

</body>
</html>
