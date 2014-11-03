package languageManager;

import dm.CommandState;
import dm.DialogManager;;

/**
 * 
 * @author luizhsilva
 *
 */
public class NLG {
	
	public NLG() {
		
	}
	
	/**
	 * TODO
	 * Prototype
	 * @return
	 */
	public static String getResult(KeywordCapsule capsule) {
		CommandState currentState = DialogManager.getDM().getCurrentState();
		if (currentState == CommandState.ZEIGMIR) {
			return "Zeigen " + capsule.getAnatStructKeywords().get(0);
		} else if (currentState == CommandState.WOIST) {
			
		} else if (currentState == CommandState.BLENDEAUS) {
			
		} else if (currentState == CommandState.BLENDEEIN) {
			
		} else if (currentState == CommandState.MESSEN) {
			
		} else if (currentState == CommandState.STARTE) {
			
		} else if (currentState == CommandState.BEENDE) {
			
		};
		
		return "Nicht verstanden";
	}

}
