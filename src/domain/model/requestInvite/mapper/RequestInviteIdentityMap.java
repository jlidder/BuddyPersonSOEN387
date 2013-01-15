package domain.model.requestInvite.mapper;

import java.util.ArrayList;  
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import domain.model.requestInvite.RequestInvite;

public class RequestInviteIdentityMap {


	private HashMap<Long,RequestInvite> knownRequests;
	
	public RequestInviteIdentityMap()
	{
		knownRequests = new HashMap<Long,RequestInvite>();
	}
	
	public void put(long id, RequestInvite val)
	{
		knownRequests.put(id, val);
	}
	
	public RequestInvite get(long id)
	{
		return knownRequests.get(id);
	}
	
	public List<RequestInvite> getAll()
	{
		List<RequestInvite> riList = new ArrayList<RequestInvite>();
		Collection<RequestInvite> riList1 = knownRequests.values();
		Iterator<RequestInvite> RequestInvites = riList1.iterator();
		
		while(RequestInvites.hasNext())
		{
			riList.add(RequestInvites.next());
		}
			 
		
		return riList;
	}
	
}
