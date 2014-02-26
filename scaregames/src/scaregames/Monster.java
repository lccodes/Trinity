package scaregames;

public class Monster implements Card {
	
	//Monsters' universal characteristics
	public String house;
	public String name;
	public int attackValue;
	public String attackName;
	public int cp;
	public int CPMAX;
	public int life = 0;
	public int turns = 0;
	
	public Monster (){
		//Empty constructor for ease of use
	}
	
	/**
	 * Decreases the monster's value in response to an attack
	 * @param int value; how wounded we were
	 */
	public void getAttacked(int value){
		System.out.println(name + " has lost " + value + " confidence points!");
		cp = (cp-value < 0) ? 0 : cp-value;
		if(isExiled()){
			System.out.println(name + " has been exiled to the human world!");
		}
	}
	
	/**
	 * Attacks another Monster, viciously
	 * @param Monster; our victim
	 */
	public void attack(Monster enemy){
		if(life > 0){
			int av = attackValue;

			System.out.println(name + " attacks with " + attackName + "!");
			if((house.equals("Roar Omega Roar") && enemy.house.equals("Oozma Kappa")) ||
					(house.equals("Oozma Kappa") && enemy.house.equals("Administration")) ||
					(house.equals("Administration") && enemy.house.equals("Python Nu Kappa")) ||
					(house.equals("Python Nu Kappa") && enemy.house.equals("Roar Omega Roar"))) {
				av+=20;
			}
			else if ((house.equals("Oozma Kappa") && enemy.house.equals("Roar Omega Roar")) ||
						(house.equals("Administration") && enemy.house.equals("Oozma Kappa")) ||
						(house.equals("Python Nu Kappa") && enemy.house.equals("Administration")) ||
						(house.equals("Roar Omega Roar") && enemy.house.equals("Python Nu Kappa"))){
				av = (av-20 < 0) ? 0 : av-20; 
			}
			enemy.getAttacked(av);
		} else{
			System.out.println("This monster is too yung blud to attack.");
		}
	}
	
	/**
	 * Checks if this Monster should be gone with the wind
	 * @return true if dead else false
	 */
	public boolean isExiled(){
		return (cp <= 0) ? true : false;
	}
	
	/**
	 * Levels up the Monster!
	 * @return the Monster's new form
	 */
	public Monster advanceCareer(){
		//This will be overridden by the sub-classes
		System.out.println("This monster can't advance career!");
		return this;
	}
	
	/**
	 * Tells us the Monster's experience
	 * @return int with its # of turns
	 */
	public int getTurns(){
		return turns;
	}
	
	/**
	 * Another day, another $
	 */
	public void addTurn(){
		turns++;
	}
	
	/**
	 * Used by cards to increase CP
	 * @param CP change
	 * @param CPMAX change
	 */
	public void upCP(int change, int changeMax){
		CPMAX += changeMax;
		if (cp + change <= CPMAX){
			cp += change;} else{
			cp = CPMAX;			
		}
		
	}
	
	/**
	 * Resets the CP
	 */
	public void resetCP(){
		cp = CPMAX;
	}
	
	/**
	 * Sets up the Monster with its initial characteristics
	 * @param name is the Monster's name
	 * @param house is the Monster's greek life
	 * @param attackName is the Monster's attack
	 * @param attackValue is the Monster's attack's value
	 * @param CP is the Monster's starting CP value and henceforth its max
	 */
	public void setUp(String nm, String hse, String attackN, int aValue, int CP){
		name = nm;
		house = hse;
		attackName = attackN;
		attackValue = aValue;
		CPMAX = CP;
		cp = CPMAX;
	}
	
	/**
	 * @return name (string)
	 */
	public String toString(){
		return name;
	}
	
	/**
	 * @return name, rank, serial (string)
	 */
	public String toStringExtended(){
		return name + " (" + cp + "/" + CPMAX + ")";
	}

	/**
	 * Just true
	 */
	@Override
	public boolean isMonster() {
		return true;
	}
	
	/**
	 * Uses the Monster's special power if it has one
	 */
	public void useSpecial(){
		
	}
	
	/**
	 * Checks to see if the Monster has a special. Default is false
	 * @return false unless it's a special Monster
	 */
	public boolean hasSpecial(){
		return false;
	}

}
