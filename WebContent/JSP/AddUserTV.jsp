<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.model.user.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="css/groupStyleSheet.css" type="text/css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add User</title>
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
<p>Add a user below: </p>

<div id="queryContents">
	<form method="POST" action="GroupFormationSoftware?dispatcher=application.dispatcher.AddUserDispatcher" enctype="multipart/form-data">
		<table border="1" style="border-collapse: collapse;">
		
			<tr>
				<th>Upload .csv File (File Path)</th>
				<th>CSV file should be in format of sthiel,1234,Stuart,Thiel</th>
			</tr>
			<tr>
				<td><input type="file" name="uploadFile" size="200" style="width:300px;"></td>
				<!-- <td><input type="text" name="csvFile" size="200" style="width:300px;"> -->
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="AddUser"></td>
			</tr>
			
			</table>
	</form>
	
</div> <!--closing queryContents -->
</div>  <!--closing contents -->
<div id="footer">
Copyright ©2012, GROUPS ONLINE - SOEN 387
</div> <!-- closing footer -->
</div> <!-- closing wrapper -->

</body>
</html>
