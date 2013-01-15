package domain.model.invite.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import domain.model.invite.Invite;

public class InviteIdentityMap {

	private HashMap<Long,Invite> knownInvites;
	
	public InviteIdentityMap()
	{
		knownInvites = new HashMap<Long,Invite>();
	}
	
	public void put(long id, Invite val)
	{
		knownInvites.put(id, val);
	}
	
	public Invite get(long id)
	{
		return knownInvites.get(id);
	}
	
	public List<Invite> getAll()
	{
		List<Invite> iList = new ArrayList<Invite>();
		Collection iList1 = knownInvites.values();
		Iterator<Invite> Invites = iList1.iterator();
		
		while(Invites.hasNext())
		{
		iList.add(Invites.next());
		}
			 
		
		return iList;
	}
	
	
	
}
