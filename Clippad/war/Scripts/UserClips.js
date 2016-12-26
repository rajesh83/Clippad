/**
 * Adds a form-field for another user clip 
 */

function addAnotherClip(){
	
	var clipList = document.getElementById("clipList");
	var newClipLi = document.createElement("li");
	var newClip = document.createElement("textarea");
	
	newClip.id = "newClip";
	newClip.type = "text";
	newClip.name = "clip";
	
	newClipLi.appendChild(newClip);
	clipList.appendChild(newClipLi);	
	newClip.focus();
	addSaveButton();	
}

function editClip(clipId){
	var clip = document.getElementById(clipId);
	clip.removeAttribute("readOnly");
	addSaveButton();	
}

function deleteClip(listItemId){
	
	var del = confirm("Do you really want to delete this item?");
	if(del){
		var list = document.getElementById("clipList");
		var listItem = document.getElementById(listItemId);
		list.removeChild(listItem);
		addSaveButton();
	}
}

function copyClip(clipId){
	var msg = document.getElementById("msg");
	var clip = document.getElementById(clipId);
	clip.select();
	try{
		var result = document.execCommand('copy');
		console.log(result);
		if(result){
			msg.innerHTML = "Clip-item copied to clipboard..";
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