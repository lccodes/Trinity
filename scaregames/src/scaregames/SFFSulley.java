package scaregames;

public class SFFSulley extends Monster{
	/**
	 * Constructor uses the set values for SFF Sulley
	 */
	public SFFSulley(){
		setUp("SFF Sully", "Oozma Kappa", "Thunderous Roar", 50, 140);
	}
	
	/**
	 * Let's us know that there's a special
	 */
	@Override
	public boolean hasSpecial(){
		return true;
	}
	
	/**
	 * Uses his special
	 */
	@Override
	public void useSpecial(){
		this.attackValue+=5;
	}
	
	/**
	 * Overrides his attack to use his special
	 */
	@Override
	public void attack(Monster enemy){
		if(this.life > 0){
			int av = this.attackValue;

			System.out.println(name + " attacks with " + attackName + "!");
			if(enemy.house.equals("Administration")) {
				av+=20;
			}
			else if (enemy.house.equals("Roar Omega Roar")){
				av = (av-20 < 0) ? 0 : av-20; 
			}
			//Hit dat special
			useSpecial();
			enemy.getAttacked(av);
		} else{
			System.out.println("This monster is too yung blud to attack.");
		}
	}

}
