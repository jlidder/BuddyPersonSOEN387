package domain.model.group;

import java.util.List;

import org.dsrg.soenea.domain.proxy.ListProxy;

import domain.model.group.mapper.GroupInputMapper;
import domain.model.group.IGroup;

public class UserGroupProxyList extends ListProxy<IGroup>{

private long userid;
	
	public UserGroupProxyList(long userId)
	{
		super();
		this.userid = userId;
	}
	
	@Override
	protected List<IGroup> getActualList() throws Exception 
	{
		return GroupInputMapper.findGroupMembers(userid);
	}
	
}
