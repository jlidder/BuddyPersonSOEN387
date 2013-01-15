package domain.model.group;

import java.sql.SQLException; 
import java.util.List;

import org.dsrg.soenea.domain.MapperException;
import org.dsrg.soenea.uow.UoW;

import domain.model.group.data.GroupFinder;
import domain.model.requestInvite.GroupRequestListProxy;
import domain.model.requestInvite.IRequestInvite;
import domain.model.user.GroupUserProxyList;
import domain.model.user.IUser;


public class GroupFactory 
{
	public static Group createNew(String name, String desc) throws SQLException, MapperException{
		return createNew(GroupFinder.getMaxId()+1, 1, name, desc );
	}
	
	public static Group createNew(long id, long version, String name, String desc) throws SQLException, MapperException{
		List<IUser> uList = new GroupUserProxyList(id);
		List<IRequestInvite> requestList = new GroupRequestListProxy(id);
		Group g = new Group(id, version, name, desc, uList, requestList);
		UoW.getCurrent().registerNew(g);  
		return g;
	}
	
	public static Group createClean(long id, long version, String name, String desc) {
		List<IUser> uList = new GroupUserProxyList(id);
		List<IRequestInvite> requestList = new GroupRequestListProxy(id);
		Group g = new Group(id, version, name, desc, uList, requestList);
		UoW.getCurrent().registerClean(g);   
		return g;
	}
}
