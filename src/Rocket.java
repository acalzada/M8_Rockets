
public class Rocket {
	
	private int rocketIdLengthRequired = 8;  // Defines the length of the Rocket Id attribute.
	
	char[] id = new char[8];
	int numJets;
	
	
	/**
	 * Rocket class constructor.
	 *  
	 * @param id 8 char String identifying the rocket.
	 * @param numJets Number of jets in the rocket.
	 * 
	 * @throws WrongRocketIdException If the Rocket Id attribute does not have the required length. 
	 */
	public Rocket(String id, int numJets) throws WrongRocketIdException {
		
		if (id.length() != rocketIdLengthRequired) {
			throw new WrongRocketIdException("Rocket ID must be " + rocketIdLengthRequired + " parameters ");
		}
		this.id = id.toCharArray();
		this.numJets = numJets;
	}
	
	
	
	/**
	 * 
	 * Returns the Rocket identifier and the number of jets.
	 * 
	 */
	public String toString() {
		return "Rocket: '" + new String(this.id) + "'  with  '" + this.numJets + "' jets.\n";
	}
	
	
	
}
