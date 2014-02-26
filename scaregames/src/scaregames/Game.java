package scaregames;

//import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {

	public static void main(String[] args) throws IOException {
		String[] deck1 = ScareIO.getDeck(args[1]);
		String[] deck2 = ScareIO.getDeck(args[3]);
		
		// Creating the players
		Player p1 = new Player(new ArrayList<String>(Arrays.asList(deck1)), args[0]);
		Player p2 = new Player(new ArrayList<String>(Arrays.asList(deck2)), args[2]);
					
		//Starts the game
		while(!p2.hasLost() && !p1.hasLost()){
			//Player 1 goes first
			p1.myTurn = true;
			//Player 1 turn start
			p1.draw();
			p1.chooseAction(p2);
			//Player 1 turn end
			if(!p2.hasLost() && !p1.hasLost()){
				p2.draw();
				p2.myTurn = true;
				//Player 2 turn start\
				p2.chooseAction(p1);
			}
		}
		
		
		//Checks end game conditions
		if(!p1.hasLost()){
			System.out.println("The game is over and Player 1 has won!");
		} else{
			System.out.println("The game is over and Player 2 has won!");
		}
		
		//--------------------------------------------------------------------------------
		//---------------TEST CASES-------------------------------------------------------
		System.out.println("RUNNING TEST SUITE");
		UndergradRandy ur = new UndergradRandy();
		System.out.println(!ur.isExiled());
		System.out.println(ur.getTurns() == 0);
		System.out.println(!ur.hasSpecial());
		System.out.println(ur.isMonster());
		ur.addTurn();
		ur.addTurn();
		ur.addTurn();
		System.out.println(ur.life == 0);
		System.out.println(ur.turns == 3);
		Monster upgrade = ur.advanceCareer();
		System.out.println(upgrade.toString().equals("Rookie Randall"));
		ur.attack(upgrade);
		System.out.println(upgrade.cp == 60);
		ArrayList<String> deck = new ArrayList<String>();
		deck.add("Undergrad Randy");
		deck.add("Career Advance");
		deck.add("Undergrad Carrie");
		Player p = new Player(deck, "Player 1");
		p.myTurn = true;
		System.out.println(!p.hasLost());
		p.playCard(0);
		p.clearExiles();
		p.attack(p);
		p.attack(p);
		p.printField();
		p.printHand();
		p.pass();
		p.pass();
		p.pass();
		p.playCard(0);
		System.out.println("INPUT 5 to test");
		p.printField();
	}

}
