/**
This is the excpetion class if a user doesnt give a file name
@author Dakota Staples
*/
public class MissingFileNameArgumentException extends Exception
{
	/**
	The message to put in the exception
	*/
	private String msg;
	
	/**
	This is constructor for the exception
	@param msg The message to put in
	*/
	public MissingFileNameArgumentException(String msg)
	{
		this.msg = msg;
	}
}