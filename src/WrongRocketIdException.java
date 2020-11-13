
/**
 * 
 * Exception class to notify Rocket's ID does not conform with format requirements defined in Rocket class.
 * 
 * @author angel
 */
public class WrongRocketIdException extends RuntimeException{


		private static final long serialVersionUID = 1L;

		public WrongRocketIdException(String errorMessage, Throwable causeErr)  {
			super(errorMessage, causeErr);
		}
		
		public WrongRocketIdException(String errorMessage)  {
			super(errorMessage);
		}
}
