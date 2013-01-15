package domain.model.person;

import java.util.List;

import org.dsrg.soenea.domain.role.IRole;
import org.dsrg.soenea.domain.user.User;

import domain.model.user.IUser;

/**
*	This class is called Person rather than user because we had already implemented a lot of user classes and it would be too much work
*	to change around the names from user to Person and label this as User, therefore its done like this to save on time.
*/


public class Person extends User implements IPerson{

	private IUser user;
	public Person(long id, long version, String username, String password, List<IRole> roles, IUser user) {
		super(id, version, username, roles);
		setPassword(password);
		this.user = user;
	}

	@Override
	public void setUser(IUser user) {
		// TODO Auto-generated method stub
		this.user = user;
	}

	@Override
	public IUser getUser() {
		// TODO Auto-generated method stub
		return this.user;
	}

}
