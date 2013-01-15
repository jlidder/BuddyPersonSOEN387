<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type = "text/javascript"  src = "js/validation.js" ></script>
<link rel="stylesheet" href="css/groupStyleSheet.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Group</title>
</head>
<body>

<div id="header" class="center">
<div id="title" class="center">
</div> <!--closing title -->
<div id="logo" class="center">
</div> <!--closing logo -->
</div> <!--closing header -->
<div id="wrapper" class="center">
<div id="leftMenu">
<%@include file="menu.jsp" %>
</div>  <!--closing leftMenu -->
<div id="logout"> Welcome <b>${loggedinfname}</b> <a href="GroupFormationSoftware?dispatcher=application.dispatcher.LogoutDispatcher">logout</a>
</div> <!--closing logout -->
<div id="contents"> 
<h2> ${title} </h2>
<p>Create a New Group Below: </p>

<div id="queryContents">

	<table border="0">	
		<form method="POST" action="GroupFormationSoftware?dispatcher=application.dispatcher.CreateGroupDispatcher" onsubmit="return validateEditGroup()">

			<legend id="legend">Create Group</legend>
			<tr><td>Group Name</td><td>:</td><td><input type="text" name="groupname" id="groupname" size="20"></td></tr>
			<tr><td>Description</td><td>:</td><td><input type="test" name="groupdesc" id="description" size="50"></td></tr>
		<tr><td>&nbsp;</td><td></td><td><input type="submit" value="Create"></td></tr>

		</form>
	</table> <!--closing table -->
	
</div> <!--closing queryContents -->
</div>  <!--closing contents -->
<div id="footer">
Copyright ©2012, GROUPS ONLINE - SOEN 387
</div> <!-- closing footer -->
</div> <!-- closing wrapper -->

</body>
</html>