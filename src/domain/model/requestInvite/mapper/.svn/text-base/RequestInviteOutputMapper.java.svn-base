package domain.model.requestInvite.mapper;

import java.sql.SQLException; 

import domain.model.requestInvite.RequestInvite;
import domain.model.requestInvite.data.RequestInviteTDG;

public class RequestInviteOutputMapper {

	public static int insert(RequestInvite requestInvite) throws SQLException
	{
			return RequestInviteTDG.insert( requestInvite.getUser().getId(), requestInvite.getGroup().getId() );
	}

	public static int delete(RequestInvite requestInvite) throws SQLException
	{
			return RequestInviteTDG.delete(requestInvite.getUser().getId(), requestInvite.getGroup().getId(), requestInvite.getVersion());
	}
	
}
