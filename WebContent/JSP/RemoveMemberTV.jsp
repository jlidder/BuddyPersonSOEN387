<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="domain.model.group.Group" %>
<%@ page import="domain.model.user.User" %>
<%
int myGroupId = (Integer)session.getAttribute("usergroup");
if(myGroupId == 0)
{
	request.getRequestDispatcher("/BrowseGroups").forward(request, response);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="css/groupStyleSheet.css" type="text/css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remove a Group Member</title>
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
<p>Remove One of Group Members Below: </p>

<div id="queryContents">


	<table border="1" style="border-collapse: collapse;">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
			<%
				boolean isClicked = false;
				List<User> users = (List<User>)request.getAttribute("users");
				for(User user: users)
				{ 
					long grId = (Long)user.getGroup().getId();
					
					//NEED TO COMPARE THE SESSION GROUP ID TO ALL GROUP ID'S
					//HOWEVER, SESSION GROUP ID IS AN OBJECT, AND GR IS AN INTEGER
					//CANNOT COMPARE AN INTEGER TO A STRING, AND CONVERTING THE INTEGER TO A STRING DID NOT WORK
					if(grId == myGroupId)
					{ 
			%>
				<tr>
					<td><%=user.getFirstName()%> </td>
					<td><%=user.getLastName()%></td>
					<td><a href="RemoveMember?userId=<%=user.getId()%>&version=<%=user.getVersion()%>">Remove</a></td>
				</tr>
				
				
			<%
					}
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