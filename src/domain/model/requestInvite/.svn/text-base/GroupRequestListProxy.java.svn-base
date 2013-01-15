package domain.model.requestInvite;

import java.util.ArrayList;  
import java.util.List;

import org.dsrg.soenea.domain.proxy.ListProxy;

import domain.model.requestInvite.mapper.RequestInviteInputMapper;

public class GroupRequestListProxy extends ListProxy<IRequestInvite>{

	private long groupId;
	
	public GroupRequestListProxy(long groupId)
	{
		super();
		this.groupId = groupId;
	}
	
	@Override
	protected List<IRequestInvite> getActualList() throws Exception 
	{
		List<RequestInvite> allRequests = RequestInviteInputMapper.findAll();
		List<IRequestInvite> groupRequestInvites = new ArrayList<IRequestInvite>();
		
		for(RequestInvite requestI: allRequests)
		{
			if(requestI.getGroup().getId() == this.groupId)
			{
				groupRequestInvites.add(requestI);
			}
		}
		
		return groupRequestInvites;		
	}
	
}
