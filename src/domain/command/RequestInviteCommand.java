package domain.command;

import java.sql.SQLException;   
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.impl.Command;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.command.DomainCommand;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

import application.VersionException;

import domain.model.group.Group;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;

import domain.model.requestInvite.RequestInvite;
import domain.model.requestInvite.mapper.RequestInviteInputMapper;
import domain.model.requestInvite.mapper.RequestInviteOutputMapper;


public class RequestInviteCommand extends Command{

	public RequestInviteCommand(Helper helper) {
		super(helper);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setUp() throws CommandException {
		// TODO Auto-generated method stub

	}

	@Override
	public void process() throws CommandException {
		
		User requestingUser = null;
		long uid = -1;
		long gid = -1;
		List<Group> gList = null;
		List<Group> filteredGList = new ArrayList<Group>();
		
		try
		{
			// get the requesting user
			
			uid = (Long) helper.getSessionAttribute("userId");
			gid = (Long) helper.getSessionAttribute("groupId");
			
			//Group group = GroupInputMapper.find( Integer.parseInt(uid) );
			requestingUser = UserInputMapper.find(uid); 
			
			//long requestingUserId = (Long)(helper.getSessionAttribute("userid"));
			long requestingUserId = uid;
			
			int groupversionForRequestInvitation = Integer.parseInt(helper.getString("groupversionForRequestInvitation"));
			
			// a Group has been requested
			//Group requestedGroup = GroupInputMapper.find( Long.parseLong(gid) );
			
			
			//here to...
			
			//if(requestedGroup.getVersion() != groupversionForRequestInvitation) //VERSION CHECK.
				//throw new VersionException("");
			

	
			// create the request
			//RequestInvite requestInvite = new RequestInvite(0, requestingUser.getId(), requestedGroup.getId(),1);
			//RequestInviteOutputMapper.insert(requestInvite);
	
			String title = "Request Invitation to a Group";
			String msg = "The group has been requested by the user: " + requestingUser.getFirstName() + " " + requestingUser.getLastName();
			//String msg = "The group " + requestedGroup.getName() + ", has been requested by the user: " + requestingUser.getFirstName() + " " + requestingUser.getLastName();
	
			//get list of all groups
			gList = GroupInputMapper.findAll();	
			//List<Group> filteredGList = new ArrayList<Group>();
	
			// get a list of requests
			List<RequestInvite> requestInviteList = RequestInviteInputMapper.findAll();
			List<Long> requestedGroups = new ArrayList<Long>();
	
			// filter the groups that have already been requested by the user
			for(RequestInvite rInv: requestInviteList) //list of request groups
			{
				if(rInv.getUser().getId() == requestingUserId)
				{
					requestedGroups.add(rInv.getGroup().getId());
				}
			}
	
			// filter the list to remove groups that are already requested by the user
			for(Group g: gList)
				for(Long rGroups: requestedGroups)
				{
					if(g.getId() != rGroups)
						for(Group fGList: filteredGList)
							{
								if(g.getId() != fGList.getId())
									filteredGList.add(g);
							}
				}
	
			helper.setRequestAttribute("groups", filteredGList);
			helper.setRequestAttribute("title", title);
			helper.setRequestAttribute("msg", msg);
			helper.setRequestAttribute("requestedList", requestedGroups);  
			helper.setRequestAttribute("userId", requestingUserId);
			
			DbRegistry.closeDbConnectionIfNeeded();
			//helper.getRequestDispatcher("JSP/RequestInviteTV.jsp").forward(request, response);
			
			
			
			
			
			
			
			//...to here
		}
		catch (SQLException e)
		{
			throw new CommandException(e.getMessage());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DomainObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void tearDown() throws CommandError {
		// TODO Auto-generated method stub
		
	}
}
