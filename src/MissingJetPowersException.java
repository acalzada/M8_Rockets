
public class MissingJetPowersException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MissingJetPowersException(String errorMessage, Throwable causeErr)  {
		super(errorMessage, causeErr);
	}
	
	public MissingJetPowersException(String errorMessage)  {
		super(errorMessage);
	}
	
	public MissingJetPowersException()  {
		this("The Rocket being configured has more jet engines than the number of input jet powers passed.");
	}
	
	
}
