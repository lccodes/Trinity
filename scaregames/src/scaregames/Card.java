package scaregames;

public interface Card {
	
	/**
	 * Gives us a string name
	 * @return string name
	 */
	public String toString();
	
	/**
	 * Checks if I'm a monster
	 * @return true
	 */
	public boolean isMonster();

}
