<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="domain.model.user.User"%>
<%@ page import="domain.model.group.Group"%>
<%@ page import="domain.model.requestInvite.RequestInvite" %>
<%@ page import="domain.model.group.mapper.GroupInputMapper" %>
<%@ page import="domain.model.user.IUser" %>  
<%@ page import="domain.model.group.IGroup" %>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<link rel="stylesheet" href="css/groupStyleSheet.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<title>Request Group Invite</title>
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
<div>${msg}</div>
		
		<div id="queryContents">
		
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>Name</th>
				<th>&nbsp;</th>
			</tr>
			<%
				List<Group> groups = (List<Group>)request.getAttribute("groups");
				List<User> users = (List<User>)request.getAttribute("users");
				List<Integer> invitedUsers = (List<Integer>)request.getAttribute("invitedList");
				List<Integer> requestedGroups = (List<Integer>)request.getAttribute("requestedList");
				for(Group group: groups)
				{
			%>
				
				<tr>
					<td><%=group.getName()%></td>
					<td>
					<% if( requestedGroups.contains( group.getId() )) {%>
						<i>Requested</i>
					<% }else{ %>
					<form method="POST" action="RequestInvite">
						<!--  <a href="RequestInvite?userId=<%=group.getId()%>&groupId=${groupId}&userversionForInvitation=<%=group.getVersion()%>">Invite</a> -->
						<input type="hidden" value="<%=group.getId()%>" name="groupId" />
						<input type="hidden" value="${userId}" name="userId" />
						<input type="hidden" value="<%=group.getVersion()%>"  name="groupversionForRequestInvitation"/>
						<input type="submit" value="RequestInvite"/>
					</form>
					<%} %>
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