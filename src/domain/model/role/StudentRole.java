package domain.model.role;

import org.dsrg.soenea.domain.role.IRole;
import org.dsrg.soenea.domain.role.Role;

public class StudentRole extends Role implements IRole  {

	private static final long ROLE_ID = 2L;
	private static final String ROLE_NAME = "StudentRole";
	
	public StudentRole()
	{
		super(ROLE_ID, 1, ROLE_NAME);
	}
	
	public String getName()
	{
		return ROLE_NAME;
	}
	
	public Long getId()
	{
		return ROLE_ID;
	}
	
	public long getVersion()
	{
		return 1;
	}
}
