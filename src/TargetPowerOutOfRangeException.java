
public class TargetPowerOutOfRangeException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public TargetPowerOutOfRangeException(String errorMessage, Throwable causeErr)  {
		super(errorMessage, causeErr);
	}
	
	public TargetPowerOutOfRangeException(String errorMessage)  {
		super(errorMessage);
	}
	
	public TargetPowerOutOfRangeException()  {
		this("Power demanded is out of the jet engine capabilities!!");
	}
}
