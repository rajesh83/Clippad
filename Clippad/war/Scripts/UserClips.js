/**
 * Adds a form-field for another user clip 
 */

var clipsForm;

function onLoad(){
	clipsForm = document.getElementById("clipsForm");
	msg.innerHTML = "     ";
}
		
function addAnotherClip(){
	
	document.location.href = "ClipDetails?index=new";
}

function copyClip(clipIndex){
	var msg = document.getElementById("msg");
	var clip = document.getElementById("clipText" + clipIndex);
	clip.hidden = false;
	clip.select();

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
		alert("exception" + err);
		msg.innerHTML = "Unsupported browser-operation! Copy selected text manually..";
		msg.style.color = "red";
	}	
	finally{
		clip.hidden = true;
	}
}

function viewClip(clipIndex){
	document.location.href = "ClipDetails?index=" + clipIndex;
}

function addSaveButton(){
	
	if(!document.getElementById("saveButton")){
		var saveButton = document.createElement("button");
		saveButton.id = "saveButton";
		saveButton.type = "submit";
		saveButton.innerHTML = "Save";
		clipsForm.appendChild(saveButton);
	}
}

function moveClip(direction, clipIndex){
	
	if(direction == "Up"){
		exchangeClips(clipIndex-1, clipIndex);
	}
	else if(direction == "Down"){
		exchangeClips(clipIndex, clipIndex+1);
	}
	
	addSaveButton();
	var newClipButton = document.getElementById("newClipButton");
	newClipButton.parentNode.removeChild(newClipButton);
	msg.innerHTML = "Please save your changes before you view/copy any clip..";
}

function exchangeClips(a,b){

	var tempTitle, tempText;
	var aText = document.getElementById("clipText" + a);
	var aTitle = document.getElementById("clipTitle" + a);
	var bText = document.getElementById("clipText" + b);
	var bTitle = document.getElementById("clipTitle" + b);	
	
	tempTitle = aTitle.value;
	tempText = aText.value;
	aTitle.value = bTitle.value;
	aText.value = bText.value;
	bTitle.value = tempTitle;
	bText.value = tempText;
}