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
	public static String getResult() {
		if (DialogManager.getDM().getCurrentState() == CommandState.ZEIGMIR) {
			return "Zeigen --";
		}
		return "Nicht verstanden";
	}

}
