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
	  	<p><a href=/>Home</a></p>		
	  	<p> Hello <b>${user.name}</b>! </p>					
		<p> You have <b>${count}</b> stored clip-items. Click on any to view in detail.. </p>

		<p> <label id="msg"> </label> </p>

		<form name="clipsForm" id="clipsForm" method="post" action="Update?mode=list">
			<ul id="clipList">
				<c:forEach var="clipItem" items="${user.clipTitle}" varStatus="clip">
				  
				    <li id="list${clip.index}"> 				    	
				    	<img src="Images/copy-icon.png" height="16" width="16" alt="Copy" title="Copy" onClick="return copyClip(${clip.index});">
				    	<input type="text" id="clipTitle${clip.index}" name="clipTitle" value="${fn:escapeXml(clipItem)}" readOnly onClick="return viewClip(${clip.index})">
				    	<textarea hidden id="clipText${clip.index}" name="clipText">${fn:escapeXml(user.clipText[clip.index])}</textarea> 
				    </li> 
				   
				</c:forEach>
			</ul>	
		</form>		

		<button onClick="return addAnotherClip();">New clip</button>	  	

	  </div>	
	</div>

</body>
</html>
