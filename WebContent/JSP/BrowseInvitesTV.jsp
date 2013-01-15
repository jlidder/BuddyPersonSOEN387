<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="domain.model.invite.Invite" %>
<%@ page import="domain.model.group.Group" %>
<%@ page import="domain.model.group.mapper.GroupInputMapper" %>
<%@ page import="domain.model.user.User" %>   
<%@ page import="domain.model.user.IUser" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<link rel="stylesheet" href="css/groupStyleSheet.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<title>Browse Invites</title>
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
<p>View Invites Information below: </p>

<script type="text/javascript">

// Hide and display advanced search
$(document).ready(function() {
	//$("#adv_search_container").hide();
	});
	function showTeam(group)
	{
		$("#group_box_" + group).slideToggle(400);
		return false;
	}
</script> 

<div id="queryContents">

 		<%
				List<Invite> invites = (List<Invite>)request.getAttribute("inviteList");
				
				if(invites.isEmpty())
				{
					%>
					<h2>You have no invites</h2>
					<%
				}
		%>
		
		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>Group Name</th>
				<th>Accept Invite</th>
				<th>Decline Invite</th>
			</tr>
		   <%
				
				//List<User> users = (List<User>)request.getAttribute("users");
				for(Invite invite: invites)
				{
					Group g = GroupInputMapper.find(invite.getGroup().getId());
					List<IUser> users = g.getMemberList();
			%>
				<tr>
			 		<td>
			 			<a href="" onclick="showTeam(<%=g.getId()%>); return false;" ><%=g.getName()%></a>
						<div id="group_box_<%=g.getId()%>" style="display: none; text-align:left;">
							<br />
							<% for(IUser u: users)
							   {
							%>
								- <%=u.getFirstName()%> <%=u.getLastName()%><br />
							<% 	
							   }
							%>
						</div>
					</td>
					<td><a href="GroupFormationSoftware?dispatcher=application.dispatcher.AcceptDeclineInviteDispatcher&accepted=true&inviteid=<%=invite.getId()%>&inviteversion=<%=invite.getVersion()%>"><button>Accept</button> </a> </td>
					<td><a href="GroupFormationSoftware?dispatcher=application.dispatcher.AcceptDeclineInviteDispatcher&accepted=false&inviteid=<%=invite.getId()%>&inviteversion=<%=invite.getVersion()%>"><button>Decline</button> </a> </td>
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