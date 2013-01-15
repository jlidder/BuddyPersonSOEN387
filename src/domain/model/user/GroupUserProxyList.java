package domain.model.user;

import java.util.List;

import org.dsrg.soenea.domain.proxy.ListProxy;

import domain.model.user.mapper.UserInputMapper;

public class GroupUserProxyList extends ListProxy<IUser>
{

	private long groupid;
	
	public GroupUserProxyList(long groupId)
	{
		super();
		this.groupid = groupId;
	}
	
	@Override
	protected List<IUser> getActualList() throws Exception 
	{
		return UserInputMapper.findGroupMembers(groupid);
	}

}
