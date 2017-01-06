/**
 * Adds a form-field for another user clip 
 */

function addAnotherClip(){
	
	document.location.href = "ClipDetails?index=new";
}

function copyClip(clipIndex){
	var msg = document.getElementById("msg");
	var clip = document.getElementById("clipText" + clipIndex);
//	alert(clip.value)
//	clip.focus();
	clip.hidden = false;
	clip.select();
//	alert(document.getSelection());
	try{
		var result = document.execCommand('copy');
		console.log(result);
//		alert(result);
		if(result){
			msg.innerHTML = "Clip content copied to clipboard..";
		}
		else {
//			alert(result);
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
		var saveButton = document.createElement("input");
		saveButton.id = "saveButton";
		saveButton.type = "submit";
		saveButton.value = "Save";
		var clipsForm = document.getElementById("clipsForm");
		clipsForm.appendChild(saveButton);
	}
}