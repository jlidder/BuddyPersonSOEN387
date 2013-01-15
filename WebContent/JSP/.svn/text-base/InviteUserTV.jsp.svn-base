<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="domain.model.user.User"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="css/groupStyleSheet.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>Invite Users</title>
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
<h2> Invite Users</h2>
<div>${msg}</div>
		
		<div id="queryContents">
		
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>Name</th>
				<th>&nbsp;</th>
			</tr>
			<%
				List<User> users = (List<User>)request.getAttribute("userList");
			
				if(users.isEmpty())
				{
					%>
					
					<h2>There are no users to invite</h2>
					
					<%
					
				}
				
				for(User user: users)
				{
			%>
				
				<tr>
					<td><%=user.getFirstName()%> <%=user.getLastName()%></td>
					<td>
					<form method="POST" action="">
						<!--  <a href="InviteUser?userId=<%=user.getId()%>&groupId=${groupId}&userversionForInvitation=<%=user.getVersion()%>">Invite</a> -->
						<input type="hidden" value="<%=user.getId()%>" name="userId" />
						<input type="hidden" value="${groupId}" name="groupId" />
						<input type="hidden" value="<%=user.getVersion()%>"  name="userversionForInvitation"/>
						<input type="submit" value="Invite"/>
					</form>
					</td>
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