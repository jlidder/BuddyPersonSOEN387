<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.model.group.IGroup"%>
<%@ page import="domain.model.group.mapper.GroupInputMapper"%>
<%@ page import="domain.model.user.User"%>
<%
	User tempuser = UserInputMapper.find((Long) (request.getSession().getAttribute("userid")));
	long groupID = tempuser.getGroup().getId();
	if (groupID == 0) {
		request.getRequestDispatcher("/BrowseGroups").forward(request,
				response);
	}
	long GroupVersionToBeSentBack = 0;
	//List<Group> groups = (List<Group>) request.getAttribute("groups");
	//for (Group group : groups) {
		//long gr = (Long) group.getId();
		//long gr2 = (Long) request.getAttribute("usergroup"); //convert both to an integer, to compare to the session object group ID
		//if (gr == groupID) {
			
	IGroup group = tempuser.getGroup();
			GroupVersionToBeSentBack = group.getVersion();
			
			String newtitle = "Edit Group";
			request.setAttribute("title", newtitle);
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type = "text/javascript"  src = "js/validation.js" ></script>
<link rel="stylesheet" href="css/groupStyleSheet.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Edit Your Group</title>
</head>
<body>
	<div id="header" class="center">
		<div id="title" class="center"></div>
		<!--closing title -->
		<div id="logo" class="center"></div>
		<!--closing logo -->
	</div>
	<!--closing header -->
	<div id="wrapper" class="center">
		<div id="leftMenu">
			<%@include file="menu.jsp"%>
		</div>
		<!--closing leftMenu -->
		<div id="logout">
			Welcome <b>${loggedinfname}</b> <a href="GroupFormationSoftware?dispatcher=application.dispatcher.LogoutDispatcher">logout</a>
		</div>
		<!--closing logout -->
		<div id="contents">

			<h2>${title}</h2>

			<p>Edit Group Information Below:</p>
			<p>
				<b>Current Group Name is:</b>
				<%=group.getName()%></p>
			<p>
				<b>Current Group Description is:</b>
				<%=group.getDescription()%>
			</p>
			<p></p>

			<!-- 
Below is ending the for loop and if statement above
 -->

			<div id="queryContents">


				<!-- CODE HERE -->
				<!-- We make text fields for the user to enter a new group name AND/OR a new group description -->

				<form method="POST" action="GroupFormationSoftware?dispatcher=application.dispatcher.EditGroupDispatcher" onsubmit="return validateEditGroup()">
					<table border="1" style="border-collapse: collapse;">

						<tr>
							<th>Enter a New Group Name</th>
							<th>Enter a New Description</th>
						</tr>
						<tr>
							<td><input type="text" name="groupname" id="groupname" size="50"></td>
							<td><input type="text" name="description" id="description" size="200"
								style="width: 300px;"></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td><input type="submit" value="Submit"></td>
						</tr>

					</table>
					<input type="hidden" name="groupversionedit"
						value="<%=GroupVersionToBeSentBack%>">
				</form>



			</div>
			<!--closing queryContents -->
		</div>
		<!--closing contents -->
		<div id="footer">Copyright ©2012, GROUPS ONLINE - SOEN 387</div>
		<!-- closing footer -->
	</div>
	<!-- closing wrapper -->


</body>
</html>