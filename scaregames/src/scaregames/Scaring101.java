package scaregames;

public class Scaring101 extends TrainingCard{
	
	@Override
	public Monster play(Monster m) {
		m.upCP(20, 20);
		System.out.println(m.name + " gained CP!");
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
