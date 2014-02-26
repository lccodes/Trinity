package scaregames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player {
	
	private ArrayList<Card> hand;
	private ArrayList<String> deck;
	private Monster arena = null;
	//Field has a mutable size but only between games
	public Monster[] bench = new Monster[5];
	private String name;
	private boolean hasLost = false;
	public boolean myTurn;
	public Player opponent;
	private static boolean shuffle = false;
	
	/**
	 * Constructor, takes in a deck
	 * @param d
	 */
	public Player(ArrayList<String> d, String nm){
		hand = new ArrayList<Card>();
		for(int i = 0; i < 6; i++) {
			if(d.size() > 0){
				hand.add(toCard(d.get(0)));
				d.remove(0);
			}
		}
		//Saves the rest of the deck
		deck = d;
		if(shuffle)
			Collections.shuffle(deck);
		//Saves the name
		name = nm;
	}
	
	/**
	 * Prints the player's hand
	 */
	public void printHand(){
		System.out.println(name + "'s cards are:");
		
		for (int j = 0; j < hand.size(); j++) {
			System.out.println(j + ": " + hand.get(j));
		}
		/* for(Card c : hand){
			System.out.println(i + ": " + c.toString());
			i++;
		} */
		System.out.println();
	}
	
	/**
	 * Checks to see if anyone is in the field
	 * @return true or false
	 */
	public boolean isArenaEmpty(){
		return (arena == null);
	}
	
	/**
	 * Converts a string to a card
	 * @param string to be converted
	 */
	public static Card toCard(String s){
		switch(s){
		case "Undergrad James": return (new UndergradJames());
		case "Undergrad Johnny": return (new UndergradJohnny());
		case "Undergrad Mike": return (new UndergradMike());
		case "Undergrad Celia": return (new UndergradCelia());
		case "Undergrad Carrie": return (new UndergradCarrie());
		case "Undergrad Randy": return (new UndergradRandy());
		case "Professor Derek": return (new ProfessorDerek());
		case "Professor Hardscrabble": return (new ProfessorHardscrabble());
		case "Boo": return (new Boo());
		case "Career Advance": return (new AdvanceCareerCard());
		case "Team Confidence Potion ROR": return (new TeamConfidencePotionROR());
		case "Team Confidence Potion OK": return (new TeamConfidencePotionOK());
		case "Team Confidence Potion PNK": return (new TeamConfidencePotionPNK());
		case "Team Confidence Potion ADM": return (new TeamConfidencePotionADM());
		case "Scaring 101": return (new Scaring101());
		case "Rush Week": return (new RushWeek());
		case "Shuffle": shuffle = true;
		}
		//For Java's sake
		System.out.println(s);
		return null;
	}
	
	/**
	 * Draws a card
	 */
	public void draw(){
		if (deck.size() > 0) {
			hand.add(toCard(deck.get(0)));
			deck.remove(0);
		} else {
			System.out.println("No more cards!");
		}

	}
	
	/**
	 * Called by the Game class to get player's commands
	 */
	public void moveToArena(){
		Scanner difscan = new Scanner(System.in);
		printField();
		boolean select = true;
		while(select){
			System.out.println("Please select a valid monster");
			int choice = -1;
			try{
				choice = Integer.parseInt(difscan.nextLine());
			}catch(Exception e){System.out.println("Only numbers between 0 and 5 plz");}
			
			if(choice >= 0 && choice < 5) {
				if(bench[choice] != null){
					swapMonster(choice);
					select = false;
				}else 
					System.out.println("Please enter something valid next time!");
			}//end if
		}// end while
		if(false)
			difscan.close();
	}
	
	/**
	 * Prints the arena and bench
	 */
	public void printField(){
		System.out.println(name + "'s field contains:");
		
		int i = 0;
		for(Monster m : bench){
			if (m != null) {
				System.out.println(i + ": " + m.toStringExtended());
			} else{
				System.out.println(i + ": Empty");
			}
			i++;
		}
		if(arena != null)
			System.out.println("Arena(5): " + arena.toStringExtended());
		else
			System.out.println("Arena(5): Empty");
	}
	
	/**
	 * Puts a Monster into the thicket
	 */
	public void addToField(Monster m){
		if(isArenaEmpty()){
			arena = m;
			System.out.println("Your monster is in the arena");
			arena.life = 0;
		} else {
			boolean check = true;
			int i = 0;
			while(check && i < bench.length) {
				if(bench[i] == null){
					bench[i] = m;
					System.out.println("Your monster is on the bench");
					check = false;
				}
			i++;
			}
		}
	}
	
	/**
	 * Moves the arena monster into the arena
	 */
	public void toArena(Monster m){
		if(isArenaEmpty()){
			arena = m;
		}else{
			addToField(m);
		}
	}
	
	/**
	 * Swaps n bench monster with the arena monster
	 */
	public void swapMonster(int location){
		if(isArenaEmpty()){
			arena = bench[location];
			bench[location] = null;
			arena.life = 0;
		} else {
			Monster temp = arena;
			arena = bench[location];
			bench[location] = temp;
			arena.life = 0;
		}
		if(arena != null)
			System.out.println(arena.toString() + " is now in the arena");
	}
	
	/**
	 * Play card
	 * @param toPlay 
	 * @throws IOException 
	 */
	public void playCard(int toPlay) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		if(toPlay >= 0 && toPlay <= hand.size()){
			Card selection = hand.get(toPlay);
			System.out.println("Playing " + selection.toString());
			hand.remove(toPlay);
			if(selection.isMonster()){
				addToField((Monster) selection);
			}else {
				TrainingCard c = (TrainingCard) selection;
				if(!c.needsMonster()){
					if(c.toString().equals("Rush Week")){
						System.out.println(name + " uses Rush Week!");
						draw();
						draw();
						draw();
					} else if (c.toString().equals("Wrong Door")) {
						System.out.println("Here's your opponent's field; ripe for the picking");
						System.out.println("-1 will free you from this hell");
						opponent.printField();
						int num = 7;
						while(num >= 4 || num < -1){
							try {
								num = Integer.parseInt(reader.readLine());
							} catch (Exception e) {
								System.out.println("That's invalid... :/");
							}
							System.out.println("Choose a number between 0 and 4");
						}
						if(opponent.bench[num] != null) {
							addToField(opponent.bench[num]);
						}else{
							System.out.println("Nada? Such a waste :'(");
						}
					}
					else{
						c.play();
					}
				}else{
					boolean done = false;
					int select = 0;
					printField();
					System.out.println("-1 to discard this card");
					while(!done){
						try {
							select = Integer.parseInt(reader.readLine());
						} catch (Exception e) {
							System.out.println("Number plis");
						}
						if(select <= bench.length && select >= 0 || select == -1){
							done = true;
						} else{
							System.out.println("Please select something valid next time!");
						}
					}
					if(select != -1) {
						if(select < bench.length && bench[select] != null){
							int cpDif = bench[select].CPMAX - bench[select].cp;
							bench[select] = c.play(bench[select]);
							bench[select].upCP(-cpDif, 0);
						}else if(arena != null){
							int cpDif = arena.CPMAX - arena.cp;
							 arena = c.play(arena);
							 arena.upCP(-cpDif, 0);
						} else{
							System.out.println("There's no one there and you know that");
						}
					} else{
						System.out.println(name + " dicarded their card");
					}
					
				}
			}
		}else{
			System.out.println("Come the fuck on");
		}
	}
	
	/**
	 * Attack
	 */
	public void attack(Player other){
		if(arena != null && arena.life > 0){
			other.getAttacked(arena);
		} else{
			pass();
		}
		myTurn = false;
		giveTurn();
	}
	
	/**
	 * get attacked
	 */
	public void getAttacked(Monster m){
		if(arena == null){
			hasLost = true;
			System.out.println("Oh no! " + name + " has been conqurerd!");
		} else{
			m.attack(arena);
			if (arena.isExiled()){
				System.out.println(name + "'s arena is empty and vulerable!");
			}
		}
	}
	
	/**
	 * Pass
	 */
	public void pass(){
		System.out.println(name + " has passed to the next player!");
		myTurn = false;
		arena.life++;
		giveTurn();
	}
	
	/**
	 * Ups every monster on the field's turn count by 1
	 */
	public void giveTurn(){
		if(arena != null){
			arena.addTurn();
			if(arena.name.equals("Monster Inc. Mae")){
				for(int i = 0; i < bench.length; i++) {
					if (bench[i] != null) {
						bench[i].upCP(5, 0);
					}
				}
			}
			for(int i = 0; i < bench.length; i++){
				if(bench[i] != null){
					bench[i].addTurn();
				}
			}
		}
	}
	
	/**
	 * Let's us know that it's all over
	 */
	public boolean hasLost(){
		return hasLost;
	}
	
	/**
	 * Clear exiles
	 */
	public void clearExiles(){
		if(arena != null && arena.isExiled()){
			arena = null;
		}
		for(int i = 0; i < bench.length; i++){
			if(bench[i] != null && bench[i].isExiled()){
				bench[i]= null;
			}
		}
	}
	
	/**
	 * Choose an action
	 * This runs the player's turn
	 * @throws IOException 
	 */
	public void chooseAction(Player oppo) throws IOException{
		//Clears exiles
		clearExiles();
		boolean select = false;
		//Updates opponent
		opponent = oppo;
		BufferedReader difscan = new BufferedReader(new InputStreamReader(System.in));
		//Choose a damn action
			while(!select && myTurn){
				System.out.println("Hello "+ name+ ", Please choose an action: \n"
						+ "(print hand) Print your hand \n"
						+ "(print field) Print your field \n"
						+ "(switch #) Swap a bench monster into the arena \n"
						+ "(play #) Play a card \n"
						+ "(attack) Attack \n"
						+ "(pass) Pass");
				String buff = "";
				try {
					buff = difscan.readLine();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				String[] spaces = buff.split(" ");
				
				if(buff.equals("print hand")){
					printHand();
				}else if(buff.equals("print field")){
					printField();
				}else if(spaces[0].equals("switch")){
					int toSwitch = -1;
					try{
						toSwitch = Integer.parseInt(spaces[1]);
					}catch(Exception e){
						System.out.println("We need valid input, fuckwad");
					}
					if(toSwitch >= 0 && toSwitch <= 4){
						swapMonster(toSwitch);
					} else{
						System.out.println("Let's select something real, dick.");
					}
				}else if(spaces[0].equals("play")){
					int toPlay = -1;
					try{
						toPlay = Integer.parseInt(spaces[1]);
					}catch(Exception e){
						System.out.println("This isn't a game...lol jk...just give us valid input");
					}
					if(toPlay >= 0 && toPlay <= hand.size()){
						playCard(toPlay);
					}
				}else if(buff.equals("attack")){
					select = false;
					attack(oppo);
				}else if(buff.equals("pass")){
					select = false;
					pass();
				} else{
					System.out.println("Let's select something real, dick.");
				}

			}//end while

	}//end method
}
