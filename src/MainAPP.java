
public class MainAPP {

	public static void main(String[] args) {

		// ----   FASE 1    ----
		
		System.out.println("\n--- FASE 1 ---\n");
		
		try {
			
			Rocket rocket_1 = new Rocket("x", 3);
			
			System.out.println(rocket_1.toString());
			
		}catch(WrongRocketIdException ex) {
			ex.printStackTrace();
		}
		
		
		Rocket rocket_2 = new Rocket("LDSFJA32", 6);
		
		System.out.println("\n\n" + rocket_2.toString());
		
		
		
		// ----   FASE 2    ----
		
		System.out.println("\n--- FASE 2 ---\n");
		Rocket rocket_3 = new Rocket("32WESSDS", new int[]{10,30,80});
		
		System.out.println(rocket_3.toString());
		
		
		Rocket rocket_4 = new Rocket("LDSFJA32", 6);
		rocket_4.setJetsPowers(new int[] {30,40,50,50,30,10});
		
		System.out.println(rocket_4.toString());
		
	
	// ----   FASE 3    ----
		
		System.out.println("\n--- FASE 3 ---\n");
		
		Rocket rocket_5 = new Rocket("12345678", new int[] {10, 20, 40});
		System.out.println(rocket_5.toString());
		rocket_5.accelerate(new double[] {5,10,50});
		
		rocket_5.waitForJetThreadsToFinish();
		
		rocket_5.decelerate(new double[] {-2, 1, 0});
		rocket_5.waitForJetThreadsToFinish();


	// ----   FASE 4    ----
		
		System.out.println("\n--- FASE 4 ---\n");
		
		Rocket rocket_6 = new Rocket("Rocket_6", new int[] {10, 20, 40});;
		
		rocket_6.setRocketTargetSpeed(110);
		rocket_6.waitForJetThreadsToFinish();
		rocket_6.setRocketTargetSpeed(500);
		rocket_6.waitForJetThreadsToFinish();
		System.out.println("\n\n========================\n");
		System.out.println("--  Program Finished  --\n");
		System.out.println("========================\n");
	}

}
