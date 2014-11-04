package languageManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Natural Language Understanding. This class provides methods to analyze
 * an input, returning possible states.
 * @author luizhsilva
 *
 */
public class NLU {

	/** Singleton from class NLU */
	private static NLU singleNLU = null;
	
	//keywords separated per type
	private ArrayList<String> commandKeywords;
	private ArrayList<String> anatStructKeywords;
	private ArrayList<String> processKeywords;
	private ArrayList<String> objectsKeywords;
	private ArrayList<String> articles;
	
	/**
	 * Private constructor to be called only by {@link #getNLU()}.
	 */
	private NLU() {
		this.anatStructKeywords = new ArrayList<String>();
		this.commandKeywords = new ArrayList<String>();
		this.objectsKeywords = new ArrayList<String>();
		this.processKeywords = new ArrayList<String>();
		this.articles = new ArrayList<String>();
	}
	
	/**
	 * Analyzes input and retrieve keywords
	 * @param input the given user input
	 * @return a list with the found keywords
	 */
	public KeywordCapsule analyze(String input) {
		/*TODO analyze input and extract important keywords! List the keywords and return them to the DM*/
		
		ArrayList<String> foundCommandKeywords = new ArrayList<String>();
		ArrayList<String> foundAnatStructKeywords = new ArrayList<String>();
		ArrayList<String> foundObjectsKeywords = new ArrayList<String>();
		ArrayList<String> foundProcessKeywords = new ArrayList<String>();
		
		//Analysis using regex to make sure to get the right keyword.
		for (String key: this.commandKeywords) {
			if (input.toLowerCase().matches(".*\\b" + key.toLowerCase() + "\\b.*")) {
				foundCommandKeywords.add(key);
			}
		}
		
		for (String key: this.anatStructKeywords) {
			if (input.toLowerCase().matches(".*\\b" + key.toLowerCase() + "\\b.*")) {
				foundAnatStructKeywords.add(key);
			}
		}
		
		for (String key: this.objectsKeywords) {
			if (input.toLowerCase().matches(".*\\b" + key.toLowerCase() + "\\b.*")) {
				foundObjectsKeywords.add(key);
			}
		}
		
		for (String key: this.processKeywords) {
			if (input.toLowerCase().matches(".*\\b" + key.toLowerCase() + "\\b.*")) {
				foundProcessKeywords.add(key);
			}
		}
		
		return new KeywordCapsule(foundCommandKeywords, foundAnatStructKeywords, foundObjectsKeywords, foundProcessKeywords);
	}
	
	/**
	 * 
	 * @return single instance of NLU
	 */
	public static NLU getNLU() {
		if (singleNLU == null) {
			singleNLU = new NLU();
			return singleNLU;
		} else return singleNLU;
	}
	
	/**
	 * Loads predefined keywords to {@link #keywords} from file.
	 * @param filename the path of the file to be read
	 */
	public void loadKeywords() {
		this.loadAnatStructKeywords();
		this.loadCommandKeywords();
		this.loadObjectsKeywords();
		this.loadProcessesKeywords();
		this.articles.add("die");
		this.articles.add("der");
		this.articles.add("das");
		this.articles.add("den");
		this.articles.add("dem");
	}
	
	/**
	 * Loads the content of the Commands Keywords File into a List
	 */
	private void loadCommandKeywords() {
		
		try {
			//URL url = getClass().getResource("resources/keywords/commands.bgram"); 
			InputStream input = getClass().getResourceAsStream("keywords/commands.bgram");
			if (input == null) {
				System.out.println("Shit");
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.equals("") && !line.startsWith("//")) //ignore comments
					this.commandKeywords.add(line);
		    }
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads the content of the Processes Keywords File into a List
	 */
	private void loadProcessesKeywords() {
		try {
			InputStream input = getClass().getResourceAsStream("keywords/processes.bgram");
			//BufferedReader reader = new BufferedReader(new FileReader("resources/keywords/processes.bgram"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.equals("") && !line.startsWith("//")) //ignore comments
					this.processKeywords.add(line);
		    }
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads the content of the Anatomic Structures Keywords File into a List
	 */
	private void loadAnatStructKeywords() {
		try {
			InputStream input = getClass().getResourceAsStream("keywords/anat_structs.bgram");
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			//BufferedReader reader = new BufferedReader(new FileReader("resources/keywords/anat_structs.bgram"));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.equals("") && !line.startsWith("//")) //ignore comments
					this.anatStructKeywords.add(line);
		    }
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Loads the content of the Objects Keywords File into a List
	 */
	private void loadObjectsKeywords() {
		try {
			InputStream input = getClass().getResourceAsStream("keywords/other_objects.bgram");
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			//BufferedReader reader = new BufferedReader(new FileReader("resources/keywords/other_objects.bgram"));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.equals("") && !line.startsWith("//")) //ignore comments
					this.objectsKeywords.add(line);
		    }
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
