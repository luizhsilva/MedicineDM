package generalManager;

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
	
	/**
	 * Private constructor of main, only used to create Singleton Main.
	 */
	private Main() {
		this.isRunning = false;
		dm = DialogManager.getDM();
		//Loads keywordsfile
		NLU.getNLU().loadKeywordsFromFile("resources/keywords/keywords.bgram");
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
