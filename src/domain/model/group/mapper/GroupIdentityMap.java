package domain.model.group.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import domain.model.group.Group;

public class GroupIdentityMap {

	
private HashMap<Long,Group> knownGroups;
	
	public GroupIdentityMap()
	{
		knownGroups = new HashMap<Long,Group>();
	}
	
	public void put(long id, Group val)
	{
		knownGroups.put(id, val);
	}
	
	public Group get(long id)
	{
		return knownGroups.get(id);
	}
	
	public List<Group> getAll()
	{
		List<Group> gList = new ArrayList<Group>();
		Collection gList1 = knownGroups.values();
		Iterator<Group> groups = gList1.iterator();
		
		while(groups.hasNext())
		{
		gList.add(groups.next());
		}
			 
		
		return gList;
	}
	
	
}
