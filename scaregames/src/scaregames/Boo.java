package scaregames;

public class Boo extends TrainingCard {

	public Boo() {
	}
	
	/**
	 * Takes action
	 */
	@Override
	public Monster play(Monster m){
		System.out.println(m.toString() + " has regained full health!!");
		m.resetCP();
		return m;
	}
	
	/**
	 * toString
	 * @return string
	 */
	public String toString(){
		return "Boo";
	}
	
	/**
	 * Needs monster returns true
	 */
	public boolean needsMonster(){
		return true;
	}

}
