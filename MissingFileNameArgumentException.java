public class MissingFileNameArgumentException extends Exception
{
	private String msg;
	public MissingFileNameArgumentException(String msg)
	{
		this.msg = msg;
	}
}