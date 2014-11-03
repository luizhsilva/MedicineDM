package dm;

import java.util.ArrayList;

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
		decideState(NLU.getNLU().analyze(currentInput));
		showResult();
		//TODO continue implementation of DM.go()
	}
	
	/**
	 * Decides for a next state based on the list of keywords.
	 * @param keywords the list of found keywords in a phase (NLU normally)
	 */
	private void decideState(ArrayList<String> keywords) {
		//TODO implement decideState
		if (keywords.contains("Zeig mir"))
			this.setCurrentState(CommandState.ZEIGMIR);
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
	private void showResult() {
		System.out.println(NLG.getResult());
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
	
}
