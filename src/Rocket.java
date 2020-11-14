import java.util.ArrayList;

/**
 * @author angel
 *
 */
public class Rocket {
	
	private int rocketIdLengthRequired = 8;  // Defines the length of the Rocket Id attribute.
	
	char[] id = new char[8];
	int numJets;
	ArrayList<Jet> jetsPower;
	ArrayList<Thread> jetsStatus; // Watch list to know when all jet engines have reached target power level.
	
	
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
			throw new WrongRocketIdException("Rocket ID must be " + rocketIdLengthRequired + " characters long.\n");
		}
		this.id = id.toCharArray();
		this.numJets = numJets;
		this.jetsPower = new ArrayList<Jet>(this.numJets);
		this.jetsStatus = new ArrayList<Thread>();
	}
	
	/**
	 * Rocket constructor from constructor ID and the power of its jet engines.
	 * 
	 * @param id id 8 char String identifying the rocket.
	 * @param jetsPowers int[] with the power of the jets in Watts.
	 * @throws WrongRocketIdException If the Rocket Id attribute does not have the required length. 
	 */
	public Rocket(String id, int[] jetsPowers) throws WrongRocketIdException {
		
		this(id, jetsPowers.length);
		
		this.setJetsPowers(jetsPowers);
	}
	
	
	
	
	/**
	 * Method for setting the power of the Rocket jets.
	 * 
	 * @param jetsPowers int[] with the power of each jet in the Rocket.
	 * 
	 * @throws MissingJetPowersException If the number of jet engine power values differs from the rocket's number of jet engines.
	 */
	public void setJetsPowers(int[] jetsPowers) {
		
		this.checkJetPowersLength(jetsPowers.length);
		
		// Set all jet engine powers.
		for (int idx = 0; idx < this.numJets; idx++) {
			this.jetsPower.add(idx, new Jet(jetsPowers[idx]));
		}
	}
	
	public void accelerate(int[] jetPowers) {
		
		this.checkJetPowersLength(jetPowers.length);
		
		for (int idx = 0; idx < this.numJets; idx++) {
			Jet jet = this.jetsPower.get(idx);
			try{
				jet.setTargetPower(jetPowers[idx]);
			}catch(TargetPowerOutOfRangeException ex) {
				// No need to halt the program because the jet engine already has safety measures.
				// But We want to notify the user that is requesting too much and its demands won't be satisfied.
				ex.printStackTrace();
			}
			Thread jetThread = new Thread(jet);
			jetThread.start();
			this.jetsStatus.add(jetThread);  // Add thread to watch list to know when all jet engines have reached target power level.
		}
	}
	
	public void decelerate(int[] jetPowers) {
		
		this.checkJetPowersLength(jetPowers.length);
		
		for (int idx = 0; idx < this.numJets; idx++) {
			Jet jet = this.jetsPower.get(idx);
			try{
				jet.setTargetPower(jetPowers[idx]);
			}catch(TargetPowerOutOfRangeException ex) {
				// No need to halt the program because the jet engine already has safety measures.
				// But We want to notify the user that is requesting too much and its demands won't be satisfied.
				ex.printStackTrace();
			}
			Thread jetThread = new Thread(jet);
			jetThread.start();
			this.jetsStatus.add(jetThread);  // Add thread to watch list to know when all jet engines have reached target power level.
		}
	}
	
	
	private void checkJetPowersLength(int numOfJetPowersPassed) {
		// Chech that the number of jet powers passed is appropriate for the rocket. 
		if(numOfJetPowersPassed > this.numJets) {
			throw new MissingJetPowersException("Too many jet power values: The number of jet powers passed was " + numOfJetPowersPassed + 
												" but this rocket has " + this.numJets + " jet engines.\n");
		}
		if(numOfJetPowersPassed < this.numJets) {
			throw new MissingJetPowersException("Too few jet power values: The number of jet powers passed was " + numOfJetPowersPassed + 
					" but this rocket has " + this.numJets + " jet engines.\n");
		}
	}
	
	
	/**
	 * 
	 * Returns the Rocket identifier and the number of jets.
	 * 
	 */
	public String toString() {
		//FASE 1 -->  return "Rocket: '" + new String(this.id) + "'  with  '" + this.numJets + "' jets.\n";
		
		String info = "Rocket id: '" + new String(this.id) +"': [";
		
		for(Jet jet : this.jetsPower) {
			info = info + jet.getMaxPower() + ", ";
		}
		
		if(this.jetsPower.size() == 0)
			return info + "]\n";
		else
			return info.substring(0,  info.length() - 2) + "]\n";
	}
	
	
	/**
	 * Method to halt the execution to wait for jet's threads to finish 
	 * and remove them from the jetsStatus arrayList. 
	 */
	public void waitForJetThreadsToFinish() {
		// Check if there are any threads in the status list.
		while(!this.jetsStatus.isEmpty()) {
			
			ArrayList<Thread> jetsToDelete = new ArrayList<>();
			
			for(Thread t : this.jetsStatus) {
				// If thread is not alive, remove it from status ArrayList
				if(!t.isAlive())
					jetsToDelete.add(t);
			}

			for(int idx = 0; idx < jetsToDelete.size(); idx++) {
				this.jetsStatus.remove(jetsToDelete.get(idx));
			}
		}
	}
	
	
}
