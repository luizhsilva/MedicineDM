package dm;

import languageManager.KeywordCapsule;
import languageManager.NLG;
import languageManager.NLU;

/**
 * This class is a Singleton used to manage the phases of a Dialog.
 * Including the NLU (Natural Language Understand), the internal states,
 * and the NLG (Natural Language Generation).
 * 
 * @author luizhsilva
 *
 */
public class DialogManager {

	private String currentInput;
	private CommandState currentState;
	private static DialogManager singleDm = null;
	
	private DialogManager() {
		
	}
	
	/**
	 * Runs the Dialog Manager
	 * @param currentInput
	 */
	public void go(String currentInput) {
		this.currentInput = currentInput;
		
		//Calls the NLU to analyze input and return list of found keywords
		KeywordCapsule capsule = NLU.getNLU().analyze(currentInput);
		decideState(capsule);
		showResult(capsule);
		//TODO continue implementation of DM.go()
	}
	
	/**
	 * 
	 * @return Single instance of Dialog Manager
	 */
	public static DialogManager getDM() {
		if (singleDm == null) {
			singleDm = new DialogManager();
			return singleDm;
		} else return singleDm;
	}
	
	//TODO
	private void showResult(KeywordCapsule capsule) {
		System.out.println(NLG.getResult(capsule));
	}

	public String getCurrentInput() {
		return currentInput;
	}

	public void setCurrentInput(String currentInput) {
		this.currentInput = currentInput;
	}

	public CommandState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(CommandState currentState) {
		this.currentState = currentState;
	}
	
	/**
	 * Decides for a next state based on the list of keywords.
	 * @param keywords the list of found keywords in a phase (NLU normally)
	 */
	private void decideState(KeywordCapsule keywordsCapsule) {
		//TODO implement decideState
		if (keywordsCapsule.getCommandKeywords().contains("Zeig mir")) {
			this.setCurrentState(CommandState.ZEIGMIR);
		} else if (keywordsCapsule.getCommandKeywords().contains("Wo ist")) {
			this.setCurrentState(CommandState.WOIST);
		} else if (keywordsCapsule.getCommandKeywords().contains("Starte")) {
			this.setCurrentState(CommandState.STARTE);
		} else if (keywordsCapsule.getCommandKeywords().contains("Blende ein")) {
			this.setCurrentState(CommandState.BLENDEEIN);
		} else if (keywordsCapsule.getCommandKeywords().contains("Blende aus")) {
			this.setCurrentState(CommandState.BLENDEAUS);
		} else if (keywordsCapsule.getCommandKeywords().contains("Beende")) {
			this.setCurrentState(CommandState.BEENDE);
		} else if (keywordsCapsule.getCommandKeywords().contains("Messen")) {
			this.setCurrentState(CommandState.MESSEN);
		} else this.setCurrentState(CommandState.NOTFOUND);
		
	}
	
}
