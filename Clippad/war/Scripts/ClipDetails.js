
var readOnly;
var newClip;
var clipText;
var clipTitle;
var form;

function onLoad(){	
	form = document.getElementById("clipsForm");
	clipText = document.getElementById("clipText");
	clipTitle = document.getElementById("clipTitle");
	var editSaveButton = document.getElementById("editSaveButton");
	var backCancelButton = document.getElementById("backCancelButton");
	
	if(clipText.value){
		newClip = false;
	}
	else{
		newClip = true;
	}
	
	if(clipText.readOnly){
		readOnly = true;
	}
	else{
		readOnly = false;
		editMode(editSaveButton);
	}
}

function editMode(editSaveButton){
	
	editSaveButton.onclick = saveClip;
	editSaveButton.innerHTML = "Save";
	backCancelButton.innerHTML = "Cancel";
	backCancelButton.onclick = cancelViewEdit;
	removeDeleteButton();
	removeCopyButton();		
}

function editSaveClip(editSaveButton){	

	var backCancelButton = document.getElementById("backCancelButton");
	
	readOnly = false;
	clipTitle.readOnly = false;
	clipText.readOnly = false;
	editMode(editSaveButton);
}

function saveClip(){

	editSaveButton.type="submit";
}

function backtoClips(){
	document.location.href = "UserClips.jsp";
}

function cancelViewEdit(){

	var confirmCancel = confirm("Would you like to cancel the edits made?");
	if(confirmCancel){
		if(newClip){
			document.location.href = "UserClips.jsp";
		}
		else{
			document.location.href = "ClipDetails.jsp";
		}
	}
}

function deleteClip(){
	
	var del = confirm("Do you really want to delete this note?");
	if(del){
		form.elements["mode"].value = "delete";
		form.submit();
	}
}

function removeDeleteButton(){

	var button = document.getElementById("deleteButton");
	var para = button.parentNode;
	form.removeChild(para);
}	

function copyClip(){
	var msg = document.getElementById("msg");
	clipText.select();
	var a = window.getSelection().toString();
	try{
		var result = document.execCommand('copy');
		console.log(result);
		if(result){
			msg.innerHTML = "Clip content copied to clipboard..";
		}
		else {
			msg.innerHTML = "Unsupported browser-operation! Copy selected text manually..";
			msg.style.color = "red";
		}
	}
	catch(err){
		msg.innerHTML = "Unsupported browser-operation! Copy selected text manually..";
		msg.style.color = "red";
	}	
}

function removeCopyButton(){

	var button = document.getElementById("copyButton");
	var para = button.parentNode;
	form.removeChild(para);
}	

function onSubmit(event){

	if(!clipText.value){
		event.preventDefault();
		alert("You can't save an empty note!");
		return false;
	}
	if(!clipTitle.value){
		clipTitle.value = (clipText.value).split('\n')[0];

	}
}