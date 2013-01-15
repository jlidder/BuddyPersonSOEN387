package domain.model.user.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import domain.model.user.User;

public class UserIdentityMap {

	private HashMap<Long,User> knownUsers;
	
	public UserIdentityMap()
	{
		knownUsers = new HashMap<Long,User>();
	}
	
	public void put(long id, User val)
	{
		knownUsers.put(id, val);
	}
	
	public User get(long id)
	{
		return knownUsers.get(id);
	}
	
	public List<User> getAll()
	{
		List<User> uList = new ArrayList<User>();
		Collection uList1 = knownUsers.values();
		Iterator<User> users = uList1.iterator();
		
		while(users.hasNext())
		{
		uList.add(users.next());
		}
			 
		
		return uList;
	}
	
	
}
