<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="domain.model.requestInvite.RequestInvite" %>
<%@ page import="domain.model.group.Group" %>
<%@ page import="domain.model.group.IGroup" %>
<%@ page import="domain.model.group.mapper.GroupInputMapper" %>
<%@ page import="domain.model.user.User" %>   
<%@ page import="domain.model.user.IUser" %> 
<%@ page import="domain.model.user.mapper.UserInputMapper" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/groupStyleSheet.css" type="text/css"/>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<title>Browse Requests</title>
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
<p>View Request Information below: </p>

<div id="queryContents">

		<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>User Name</th>
				<th>Accept Request</th>
				<th>Decline Request</th>
			</tr>
			<%
				List<RequestInvite> requests = (List<RequestInvite>)request.getAttribute("requestList");
				for(RequestInvite requestI: requests)
				{
					User u = UserInputMapper.find(requestI.getUser().getId());
					
			%>
				<tr>
			 		<td>
			 			<a href="" onclick="showUser(<%=u.getId()%>); return false;" ><%=u.getFirstName()%></a>
						<div id="user_box_<%=u.getId()%>" style="display: none; text-align:left;">
							<br />
								- <%=u.getFirstName()%> <%=u.getLastName()%><br />
						</div>
					</td>
					<td><a href="AcceptDecline?accepted=true&userid=<%=u.getId()%>&requestInviteversion=<%=requestI.getVersion()%>"><button>Accept</button> </a> </td>
					<td><a href="AcceptDecline?accepted=false&userid=<%=u.getId()%>&requestInviteversion=<%=requestI.getVersion()%>"><button>Decline</button> </a> </td>
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