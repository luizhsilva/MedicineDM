package languageManager;

import java.util.ArrayList;

/**
 * This class is responsible for analyzing a given input, searching for pre-determined
 * keywords. The keywords can be either determined locally in code or in a Grammar File
 * TODO Define grammar file
 * 
 * @author luizhsilva
 * @deprecated
 */
public class KeywordsAnalyzer {

	//private String currentInput = null;
	
	private ArrayList<String> keywords = null;
	
	public KeywordsAnalyzer() {
		this.loadKeywords();
	}
	
	public ArrayList<String> analyze(String input) {
		//this.currentInput = input;
		
		
		return null;
	}
	
	/**
	 * Loads predefined keywords to {@link #keywords}
	 */
	private void loadKeywords() {
		this.keywords = new ArrayList<String>();
		
		//Commands
		this.keywords.add("Zeig mir");
		this.keywords.add("Wo ist");
		this.keywords.add("Starte");
		this.keywords.add("Beende");
		this.keywords.add("Messen");
		this.keywords.add("Blende ein");
		this.keywords.add("Blende aus");
		
		//Organs
		this.keywords.add("Ureter");
		this.keywords.add("Milz");
		this.keywords.add("Niere");
		this.keywords.add("Pankreas");
		this.keywords.add("Pankreaskopf");
		this.keywords.add("");
		this.keywords.add("");
	}

}
