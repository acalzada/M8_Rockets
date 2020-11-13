
public class MainAPP {

	public static void main(String[] args) {
		
		// ----   FASE 1    ----
		
		try {
			
			Rocket rocket_1 = new Rocket("x", 3);
			
			System.out.println(rocket_1.toString());
			
		}catch(WrongRocketIdException ex) {
			ex.printStackTrace();
		}
		
		
		Rocket rocket_2 = new Rocket("LDSFJA32", 6);
		
		System.out.println("\n\n" + rocket_2.toString());
		
		
		
		// ----   FASE 1    ----

	}

}
