package scaregames;

public class DeanHardscrabble extends Monster {
	
	/**
	 * Constructor uses the set values for Undergrad Mike
	 */
	public DeanHardscrabble(){
		setUp("Dean Hardscrabble", "Administration", "Masterful Scare", 50, 160);
	}
	
	/**
	 * Overrides attack to implement ballin
	 */
	@Override
	public void attack(Monster enemy){
		if(this.life > 0){
			int av = enemy.cp;
			enemy.getAttacked(av);
			System.out.println("DEAN HARDSCRABBLE BANISHES " + enemy.name);
			//DEAN TAKES A HIT
			this.getAttacked(60);//#ouch
		} else{
			System.out.println("This monster is too yung blud to attack.");
		}
	}

}
