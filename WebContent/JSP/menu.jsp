<%@ page import="domain.model.user.mapper.UserInputMapper"%>
<%@ page import="domain.model.user.User"%>
<%
	User u99 = UserInputMapper.find((Long)(request.getSession().getAttribute("userid")));
	
	boolean isAdmin = (Boolean) request.getSession().getAttribute("userisadmin");
	if(u99.getGroup().getId() != 0) // if the user is in a group
	{
%>
<ul>
	<li><a href="GroupFormationSoftware?dispatcher=application.dispatcher.BrowseGroupsDispatcher">Home</a></li>
	<li><a href="GroupFormationSoftware?dispatcher=application.dispatcher.InviteUserDispatcher">Invite Users</a></li>
	<li><a href="GroupFormationSoftware?dispatcher=application.dispatcher.BrowseRequestsDispatcher">Browse Group Requests</a></li>
	<li><a href="GroupFormationSoftware?dispatcher=application.dispatcher.ViewCurrentGroupDispatcher">View Your Group</a></li>
	<li><a href="GroupFormationSoftware?dispatcher=application.dispatcher.EditGroupDispatcher">Edit Your Group</a></li>
	<li><a href="RemoveGroup">Remove Group </a></li>
	<li><a href="RemoveMember">Remove a Member</a></li>
	<%if( isAdmin ){ %><li><a href="GroupFormationSoftware?dispatcher=application.dispatcher.AddUserDispatcher">Add New User</a></li>
	<%} %>
</ul>
<%		
	}
	else
	{
%>
<ul>
	<li><a href="GroupFormationSoftware?dispatcher=application.dispatcher.BrowseGroupsDispatcher">Home</a></li>
	<li><a href="GroupFormationSoftware?dispatcher=application.dispatcher.BrowseInvitesDispatcher">Browse Your Invites</a></li>
	<li><a href="GroupFormationSoftware?dispatcher=application.dispatcher.RequestInviteDispatcher">Request Group Entry</a></li>
	<li><a href="GroupFormationSoftware?dispatcher=application.dispatcher.CreateGroupDispatcher">Create Group</a></li>
	<%if( isAdmin ){ %>
	<li>
		<a href="GroupFormationSoftware?dispatcher=application.dispatcher.AddUserDispatcher">Add New User</a>
	</li>
	<%} %>
</ul>
<%		
	}
%>