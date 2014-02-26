package scaregames;

public class Scaring101 extends TrainingCard{
	
	@Override
	public Monster play(Monster m) {
		m.upCP(20, 20);
		return m;
	}
	
	@Override
	public String toString() {
		return "Scaring 101";
	}
	
	@Override
	public boolean needsMonster(){
		return true;
	}
}
