
public class Jet implements Runnable {
	
	int maxPower;
	
	double currentPower = 0.0;
	
	double trgtPower;
	
	public Jet(int maxPower) {
		this.maxPower = maxPower;
	}
	
	/**
	 * Getter method for jet engine's max power.
	 * 
	 * @return int The maximum power the engine can deliver.
	 */
	public int getMaxPower() {
		return this.maxPower;
	}
	
	
	/**
	 * Set the target power to develop by the jet engine.
	 * 
	 * @param trgtPower integer value specifying the target power to achieve in Watts. It must be positive and lower than maxPower value of the engine.
	 * @throws TargetPowerOutOfRangeException When the target power requested is negative or exceeds the maximum power reachable for the jet engine.
	 */
	public void setTargetPower(double trgtPower) throws TargetPowerOutOfRangeException {
		
		// We allow the value to be set and delegate the control to the run() method delivering the power.
		this.trgtPower = trgtPower; 
		
		if(trgtPower < 0) 
			throw new TargetPowerOutOfRangeException("Target power unreachable!!!  Target power must be in the range [ 0-" + this.maxPower +" ]");
		
		if (trgtPower > this.maxPower)
			throw new TargetPowerOutOfRangeException("Target power unreachable!!!  Limited to maxPower(" + this.maxPower + ") and requested (" + trgtPower + ")");
	}
	
	@Override
	public void run() {
		
		double affordableTargetPower = Math.max(0, this.trgtPower);
		affordableTargetPower = Math.min(affordableTargetPower, this.maxPower);
		
		affordableTargetPower = (double) Math.round(affordableTargetPower * 100)/100; // Truncamos a 2 dígitos decimales para evitar quedarnos dando saltos alrededor del valor objetivo.
		
		while(this.currentPower != affordableTargetPower) {
			
			// Si el power es menor que zero tenemos que hacer incrementos menores de 1 o nos quedaremos dando saltos alrededor del valor objetivo.
			if (affordableTargetPower < 1 && affordableTargetPower > 0)
				this.currentPower = this.currentPower + (0.01 * Math.signum(affordableTargetPower - this.currentPower));
			else
				this.currentPower = this.currentPower + (int)Math.signum(affordableTargetPower - this.currentPower);
			
			this.currentPower = (double) Math.round(this.currentPower * 100)/100; // Truncamos a 2 dígitos decimales para evitar quedarnos dando saltos alrededor del valor objetivo.
			
			String info = "Thread: '" + Thread.currentThread() + "' -> pwr/trgt: " + this.currentPower + "/" + affordableTargetPower;
			if(this.trgtPower != affordableTargetPower)
				info = info + "[requested " + this.trgtPower + "]";
			
			System.out.println(info);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
