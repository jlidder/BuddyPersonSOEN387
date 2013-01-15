	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.model.group.IGroup"%>
<%@ page import="domain.model.user.IUser"%>

<!-- The below java code gives the group name and description -->
<%
	//long groupID = (Long)session.getAttribute("usergroup");
	IGroup userGroup = (IGroup) request.getAttribute("userGroup");
	if (userGroup.getId() == 0) {
		request.getRequestDispatcher("/BrowseGroups").forward(request,response);
	}
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/groupStyleSheet.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Viewing Your Current Group</title>
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
			<%@include file="menu.jsp" %>
		</div>
		<!--closing leftMenu -->
		<div id="logout">
			Welcome <b>${loggedinfname}</b> <a href="GroupFormationSoftware?dispatcher=application.dispatcher.LogoutDispatcher">logout</a>
		</div>
		<!--closing logout -->
		<div id="contents">

			<h2>${title}</h2>

			<p>View Your Current Group Below:</p>
			<p>
				<b>Group Name is:</b>
				<%=userGroup.getName()%></p>
			<p>
				<b>Group Description:</b>
				<%=userGroup.getDescription()%>
			</p>
			<p></p>

			<!-- 
Below is ending the for loop and if statement above
 -->

			<div id="queryContents">

				<table border="1" style="border-collapse: collapse;">
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
					</tr>
					<%
						List<IUser> members = (List<IUser>) request.getAttribute("members");
						for (IUser member : members)
						{
					%>
					<tr>
						<td><%=member.getFirstName()%></td>
						<td><%=member.getLastName()%></td>
					</tr>
					<%
						}
					%>
				</table>


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