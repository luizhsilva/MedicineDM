package languageManager;

import java.util.ArrayList;

public class KeywordCapsule {
	
	private ArrayList<String> commandKeywords;
	private ArrayList<String> anatStructKeywords;
	private ArrayList<String> objectsKeywords;
	private ArrayList<String> processKeywords;
	
	public KeywordCapsule() {
		
	}
	
	public KeywordCapsule(ArrayList<String> commandKeywords,
			ArrayList<String> anatStructKeywords,
			ArrayList<String> objectsKeywords, ArrayList<String> processKeywords) {
		super();
		this.commandKeywords = commandKeywords;
		this.anatStructKeywords = anatStructKeywords;
		this.objectsKeywords = objectsKeywords;
		this.processKeywords = processKeywords;
	}
	
	public ArrayList<String> getCommandKeywords() {
		return commandKeywords;
	}
	
	public void setCommandKeywords(ArrayList<String> commandKeywords) {
		this.commandKeywords = commandKeywords;
	}
	
	public ArrayList<String> getAnatStructKeywords() {
		return anatStructKeywords;
	}
	
	public void setAnatStructKeywords(ArrayList<String> anatStructKeywords) {
		this.anatStructKeywords = anatStructKeywords;
	}
	
	public ArrayList<String> getObjectsKeywords() {
		return objectsKeywords;
	}
	
	public void setObjectsKeywords(ArrayList<String> objectsKeywords) {
		this.objectsKeywords = objectsKeywords;
	}
	
	public ArrayList<String> getProcessKeywords() {
		return processKeywords;
	}
	
	public void setProcessKeywords(ArrayList<String> processKeywords) {
		this.processKeywords = processKeywords;
	}
}
