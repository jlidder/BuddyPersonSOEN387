<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="domain.model.group.Group" %>
<%@ page import="domain.model.user.User" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="css/groupStyleSheet.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script type = "text/javascript"  src = "js/validation.js" ></script>
<title>Browse Groups</title>
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
<p>View Groups Information below: </p>

<div id="queryContents">

		
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>Group Name</th>
				<th>Description</th>
			</tr>
			<%
			
				List<Group> groups = (List<Group>)request.getAttribute("groups");
				List<User> users = (List<User>)request.getAttribute("users");
				for(Group group: groups)
				{
			%>
				<tr>
					<td>
						<a href="" onclick="showTeam(<%=group.getId()%>); return false;" ><%=group.getName()%></a>
						<div id="group_box_<%=group.getId()%>" style="display: none; text-align:left;">
							<br />
							<% for(User u: users)
							   {
								if(u.getGroup().getId() == group.getId())
								{
							%>
								- <%=u.getFirstName()%> <%=u.getLastName()%><br />
							<% 	} 
							   }
							%>
						</div>
					</td>
					<td><%=group.getDescription()%></td>
				</tr>
			<%
				}
			%>
		</table>
</div> <!--closing queryContents -->
</div>  <!--closing contents -->
<div id="footer">
Copyright ©2012, GROUPS ONLINE - SOEN 387
</div> <!-- closing footer -->
</div> <!-- closing wrapper -->
</body>
</html>