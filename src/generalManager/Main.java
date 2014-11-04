package generalManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import languageManager.NLU;
import dm.DialogManager;

/**
 * Main class. Used as Singleton.
 * @author luizhsilva
 *
 */
public class Main {

	private InputReader inputReader = new InputReader();
	private String nextLine = "";
	
	//Statics
	private static Main singleMain = null;
	private static DialogManager dm;
	
	//Flags
	private boolean isRunning;
	//private boolean isLoaded;
	
	/**
	 * Private constructor of main, only used to create Singleton Main.
	 */
	private Main() {
		this.isRunning = false;
		//this.isLoaded = false;
		dm = DialogManager.getDM();
		//Loads keywords files
		NLU.getNLU().loadKeywords();
		
		this.callPrompt();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		getMain().run();
	}
	
	/**
	 * Runs Dialog Manager until user stops.
	 */
	public void run() {
		isRunning = true;
		
		//TODO maybe write it in a more elegant way
		//Loops until user shuts it down.
		do{
			System.out.print("\n#> ");
			nextLine = inputReader.readKeyboard();
			//if (nextLine.equals("shut down")) isRunning = false;
			if (nextLine.equals("shut down")) {
				isRunning = false;
			} else {
				//Gives the control to Dialog Manager.
				dm.go(nextLine);
			}
			
		} while(isRunning);
	}
	
	private void callPrompt() {
		try {
			//URL url = getClass().getResource("resources/keywords/commands.bgram"); 
			InputStream input = getClass().getResourceAsStream("prompt/init_prompt.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
		    }
			
			//System.out.print("#> ");
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return Single instance of Main (Singleton)
	 */
	private static Main getMain() {
		if (singleMain == null) {
			singleMain = new Main();
			return singleMain;
		} else return singleMain;
	}

}
