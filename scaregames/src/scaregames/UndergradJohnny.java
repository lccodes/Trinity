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
		if(getTurns() >= 3){
			System.out.println("Undergrad Johnny advances to Fear Co. Worthington!");
			FearCoWorthington mon = new FearCoWorthington();
			int cpDif = this.CPMAX - this.cp;
			mon.upCP(-cpDif, 0);
			return mon;
		}
		else{
			System.out.println("Undergrad Johnny cannot advance yet!");
			return this;
		}
	}

}
