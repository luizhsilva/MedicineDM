package generalManager;

import java.util.Scanner;

/**
 * This class manages the input of data to the Dialog Manager.
 * 
 * @author luizhsilva
 *
 */
public class InputReader {

	/** For reading from the keyboard*/
	Scanner keyboard;
	
	public InputReader() {
		this.keyboard = new Scanner(System.in);
	}
	
	/**
	 * Reads a string from the keyboard
	 * @return the string from the keyboard
	 */
	public String readKeyboard() {
		return keyboard.nextLine();
	}
	
	/**
	 * Reads a string from a file
	 * #TODO
	 */
	public void readFile() {
		
	}
	
}
