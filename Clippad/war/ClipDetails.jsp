<%-- This JSP page displays the details of any selected clip --%>
<%@page errorPage="ErrorPage.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta charset="UTF-8">
<title>Clip Details</title>

<link rel="stylesheet" type="text/css" href="Styles/global.css">
<link rel="stylesheet" type="text/css" href="Styles/ClipDetails.css">
<script src="Scripts/ClipDetails.js" type="text/javascript"></script>

</head>

<body onload="onLoad();">

	<div id="wrapper">
	
	  <div id="profile">
	  	<b>${user.user}</b><br>
	  	<a href="Logoff">logoff<a>
	  </div>

	  <div id="details">
	    <p><a href=/>Home</a></p>	
	    <p> <h1> Clip Details </h1>		
		<p> <label id="msg"> </label> </p>

		<form name="clipsForm" id="clipsForm" method="post" action="Update" onSubmit="return onSubmit(event);">
		    <p><input type="hidden" name="clipIndex" value=${clipIndex}>
		       <input type="hidden" name="mode" value="clip"> </p>
			<p><li><input id="clipTitle" type="text" name="clipTitle" value="${clipTitle}" placeholder="Title (Optional)" ${readOnly}></li>
		 	   <li><textarea id="clipText" rows="10" cols="70" name="clipText" ${readOnly} placeholder="Enter Content here">${fn:escapeXml(clipText)}</textarea></p></li>
		       <button type="button" id="editSaveButton" onClick="return editSaveClip(this);">Edit</button>
		 	   <button type="button" id="backCancelButton" onClick="return backtoClips();">Back</button>
		 	<p><button type="button" id="copyButton" onClick="return copyClip();">Copy</button>
		 	<button type="button" id="deleteButton" onClick="return deleteClip();">Delete</button></p>
		</form>		
	  	
	  	</div>	
	</div>

</body>
</html>
