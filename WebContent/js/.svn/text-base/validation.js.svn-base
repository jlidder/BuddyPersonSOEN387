//$(document).ready(testprint());

function validateEditGroup()
{

	var gname = document.getElementById('groupname').value;
	var gdesc = document.getElementById('description').value;	

	if(gname == "" || gdesc == "")
	{
		alert("No blank names or descriptions allowed");
		return false;
	}

	var matches1 = gname.search(/^[\w\s*]+$/);
	var matches2 = gdesc.search(/^[\w\s*]+$/);

	if (matches1 == -1)
	{
		alert("Invalid characters used in name\nPlease enter only letters and numbers");
		return false;
	}
	if (matches2 == -1)
	{
		alert("Invalid characters used in description\nPlease enter only letters and numbers");
		return false;
	}

	return true;

}

function showTeam(group)
{
	$("#group_box_" + group).slideToggle(400);
	return false;
}


function testprint()
{
	alert("LOADED");
}
