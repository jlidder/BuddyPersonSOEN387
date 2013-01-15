package domain.command;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.dsrg.soenea.domain.command.CommandError;
import org.dsrg.soenea.domain.command.CommandException;
import org.dsrg.soenea.domain.command.DomainCommand;
import org.dsrg.soenea.domain.helper.Helper;
import org.dsrg.soenea.domain.mapper.DomainObjectNotFoundException;
import org.dsrg.soenea.service.threadLocal.DbRegistry;

import domain.JavaMD5Hashing;
import domain.model.group.Group;
import domain.model.group.mapper.GroupInputMapper;
import domain.model.person.Person;
import domain.model.person.mapper.PersonInputMapper;
import domain.model.role.AdminRole;
import domain.model.user.User;
import domain.model.user.mapper.UserInputMapper;


public class LoginCommand extends DomainCommand 
{

	public LoginCommand(Helper helper)
	{
		super(helper);
	}

	@Override
	public void setUp() throws CommandException 
	{
		
	}

	@Override
	public void process() throws CommandException 
	{
		String un, pw;
		un = helper.getString("username");
		
		if(un == "" || un == null)
		{
			throw new CommandException();
		}
		

		//convert user written password into a standardized hash md5, which is how we store it in the DB
		pw = JavaMD5Hashing.produceMD5Hash(helper.getString("password")); 

		List<Person> personlist = new ArrayList<Person>();

		try 
		{
			personlist = PersonInputMapper.findAll();
		} 
		catch (SQLException e) 
		{
			throw new CommandException("DB error: " + e.getMessage());
		} catch (DomainObjectNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean access = false;
		for(Person per: personlist)
		{
			if(un.equals(per.getUsername()))
			{
				System.out.println("Entered PW:" +pw);
				System.out.println("Onfile PW:"+ per.getPassword());

				//IF this is successful then you go to the BrowseGroups view....
				if(pw.equals(per.getPassword()))
				{					
					//Creates the session and sets the userid and first name variables to access.
					
					User usr = null;
					try {
						usr = UserInputMapper.find(per.getId());
					} catch (DomainObjectNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					helper.setSessionAttribute("userid", per.getId());
					//helper.setSessionAttribute("usergroup", usr.getGroupId());        //STUART WANTED THIS REMOVED FROM THE SESSION
					helper.setSessionAttribute("loggedinfname", usr.getFirstName());
					helper.setSessionAttribute("loggedinlname", usr.getLastName());
					helper.setSessionAttribute("userisadmin", per.hasRole(AdminRole.class));
					//helper.setSessionAttribute("sessionUserVersion", usr.getVersion());			//STUART WANTED THIS REMOVED FROM THE SESSION
					
					
					/* //STUART WANTED THIS REMOVED FROM THE SESSION
					long groupID = (Long) helper.getSessionAttribute("usergroup");	//These 3 lines of code gets the usergroup,
					Group currentGroup = null;
					try 
					{
						currentGroup = GroupInputMapper.find(groupID); //finds the group using the groupId,
					} 
					catch (SQLException e) 
					{
						throw new CommandException("DB error: " + e.getMessage());
					} catch (DomainObjectNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}							
					
					if( currentGroup!=null )
						helper.setSessionAttribute("sessionGroupVersion", currentGroup.getVersion());	//then sets the session version for the group you are in
					*/
					
					access = true;
					break;																					//group version will be more important than user version, as it is the only one that should allow concurrency
				}
			}
			
		}
		if(access == false)
		{
			// login failed
			helper.setRequestAttribute("loginerror", "The username and\\or password is incorrect.");
			throw new CommandException("The username and\\or password is incorrect.");
		}
	}

	@Override
	public void tearDown() throws CommandError 
	{

	}

}
