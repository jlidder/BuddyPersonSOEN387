package application;

public class VersionException extends Exception
{
	private String errormsg = "The versions do not match.";
	
	public VersionException(String extramsg)
	{
		errormsg = errormsg + " " + extramsg;
	}
	
	public String getString()
	{
		return errormsg;
	}
}
