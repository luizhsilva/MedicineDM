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
			if (capsule.getAnatStructKeywords().size() != 0) {
				return "Zeigen " + capsule.getAnatStructKeywords().get(0);
			} else {
				return "Richtiger Satzbau: Zeig mir + anatomische Struktur";
			}
		} else if (currentState == CommandState.WOIST) {
			if (capsule.getAnatStructKeywords().size() != 0) {
				return "Hier ist ";
			} else {
				return "Richtiger Satzbau: Hier ist + anatomische Struktur";
			}
		} else if (currentState == CommandState.BLENDEAUS) {
			if (capsule.getProcessKeywords().size() != 0) {
				return capsule.getObjectsKeywords().get(0) + " ausgeblendet";
			} else if (capsule.getAnatStructKeywords().size() != 0) {
				return capsule.getAnatStructKeywords().get(0) + " ausgeblendet";
			}
		} else if (currentState == CommandState.BLENDEEIN) {
			if (capsule.getProcessKeywords().size() != 0) {
				return capsule.getObjectsKeywords().get(0) + " eingeblendet";
			} else if (capsule.getAnatStructKeywords().size() != 0) {
				return capsule.getAnatStructKeywords().get(0) + " eingeblendet";
			}
		} else if (currentState == CommandState.MESSEN) {
			//TODO check if Darmvermessung began
			return "Messen";
		} else if (currentState == CommandState.STARTE) {
			if (capsule.getProcessKeywords().size() != 0) {
				return capsule.getProcessKeywords().get(0) + " wird gestartet.";
			} else return "Richtiger Satzbau: Starte + Prozessname";
		} else if (currentState == CommandState.BEENDE) {
			if (capsule.getProcessKeywords().size() != 0) {
				return capsule.getProcessKeywords().get(0) + " wird beendet.";
			} else return "Richtiger Satzbau: Beende + Prozessname";
		};
		
		return "Nicht verstanden";
	}

}
