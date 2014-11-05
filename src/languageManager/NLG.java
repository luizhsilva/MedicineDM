package languageManager;

import dm.CommandState;
import dm.DialogManager;;

/**
 * The NLG is responsible for producing and deciding which result should be output to the
 * user, based on which state the program is.
 * 
 * @author luizhsilva
 *
 */
public class NLG {
	
	public NLG() {
		
	}
	
	/**
	 * TODO improve NLG. Maybe just build a sentence in a String and return just once at the end.
	 *
	 * Prototype
	 * @return
	 */
	public static String getResult(KeywordCapsule capsule) {
		CommandState currentState = DialogManager.getDM().getCurrentState();
		
		//Zeig mir
		if (currentState == CommandState.ZEIGMIR) {
			if (capsule.getAnatStructKeywords().size() != 0) {
				//Zeig mir Tumor in Organ
				if(capsule.getAnatStructKeywords().contains("Tumor")) {
					if(capsule.getAnatStructKeywords().size() > 1) {
						return ">> Zeige Tumor in " + capsule.getAnatStructKeywords().get(0) + " <<";
					}
					else {
						//return "xx Richtiger Satzbau: Zeig mir Tumor in + anatomische Struktur xx";
						return ">> Zeige Tumor <<";
					}
				}
				return ">> Zeige " + capsule.getAnatStructKeywords().get(0) + " <<";
			} else {
				return "-- Richtiger Satzbau: Zeig mir + anatomische Struktur --";
			}
		//Wo ist
		} else if (currentState == CommandState.WOIST) {
			if (capsule.getAnatStructKeywords().size() != 0) {
				return ">> Hier ist " + capsule.getAnatStructKeywords().get(0) + " <<";
			} else {
				return "-- Richtiger Satzbau: Wo ist + anatomische Struktur --";
			}
		//Blende aus
		} else if (currentState == CommandState.BLENDEAUS) {
			if (capsule.getObjectsKeywords().size() != 0) {
				return ">> " + capsule.getObjectsKeywords().get(0) + " wird ausgeblendet" + " <<";
			} else if (capsule.getAnatStructKeywords().size() != 0) {
				return ">> " + capsule.getAnatStructKeywords().get(0) + " wird ausgeblendet" + " <<";
			}
		//Blende ein
		} else if (currentState == CommandState.BLENDEEIN) {
			if (capsule.getObjectsKeywords().size() != 0) {
				return ">> " + capsule.getObjectsKeywords().get(0) + " wird eingeblendet" + " <<";
			} else if (capsule.getAnatStructKeywords().size() != 0) {
				return ">> " + capsule.getAnatStructKeywords().get(0) + " wird eingeblendet" + " <<";
			}
		//Messen
		} else if (currentState == CommandState.MESSEN) {
			//TODO check if Darmvermessung began
			return "Messe";
		//Starte
		} else if (currentState == CommandState.STARTE) {
			if (capsule.getProcessKeywords().size() != 0) {
				return ">> " + capsule.getProcessKeywords().get(0) + " wird gestartet." + " <<";
			} else return "-- Richtiger Satzbau: Starte + Prozessname --";
		//Beende
		} else if (currentState == CommandState.BEENDE) {
			if (capsule.getProcessKeywords().size() != 0) {
				return ">> " + capsule.getProcessKeywords().get(0) + " wird beendet." + " <<";
			} else return "-- Richtiger Satzbau: Beende + Prozessname --";
		};
		
		return "-- Nicht verstanden --";
	}

}
