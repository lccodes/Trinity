package scaregames;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Parses a file into an array for use with Decks
 */
public class ScareIO {

    BufferedReader reader;
    
    /**
     * Constructor to specify a file to read from
     * @param fileName the filepath to load a file from
     */
    public ScareIO(String fileName) {
        try {
		reader = new BufferedReader(new FileReader(fileName));
	} catch (FileNotFoundException e) {
		System.out.println("Input file not found!");
	}
    }

    /**
     * Constructor which uses System.in
     */
    public ScareIO() {
    	reader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    
    /**
     * Reads in a line from the preexisting reader
     * @return get the next line of output from the reader
     */
    public String getNextInput() throws IOException {
        return reader.readLine();
    }
    
    /**
     * Gets a deck file and parses it into an array of card items
     * @param fileName the deck's file name
     * @return a string array representing the deck's contents
     */
    public static String[] getDeck(String fileName) throws IOException {
        BufferedReader fReader = new BufferedReader(new FileReader(fileName));
        LinkedList<String> toReturn = new LinkedList<String>();
        
        String s = fReader.readLine();
        while (s != null) {
            // Shuffles the deck so far when the word "shuffle is found"
            if (s.equals("shuffle")) {
                Collections.shuffle(toReturn);
            } else {
              toReturn.addLast(s); 
            }
            s = fReader.readLine();
        }
        fReader.close();
        return toReturn.toArray(new String[(toReturn.size())]);
    }
}
