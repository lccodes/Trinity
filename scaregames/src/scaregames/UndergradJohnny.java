package scaregames;

public class UndergradJohnny extends Monster {
	
	/**
	 * Constructor uses the set values for Undergrad Randy
	 */
	public UndergradJohnny(){
		setUp("Undergrad Johnny", "Roar Omega Roar", "The Jaw", 0, 100);
	}
	
	/**
	 * Details how UndergradRandy advances his career
	 * @return a Fear Co Worthington
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3)
			System.out.println("Undergrad Johnny advances to Fear Co Worthington!");
		else
			System.out.println("Undergrad Johnny cannot advance yet!");
		
		return (getTurns() >= 3) ? new FearCoWorthington() : this;
	}

}
