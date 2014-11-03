package languageManager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
	
	/** List of predefined keywords */
	private ArrayList<String> keywords = null;
	
	/**
	 * Private constructor to be called only by {@link #getNLU()}.
	 */
	private NLU() {
		this.keywords = new ArrayList<String>();
	}
	
	/**
	 * Analyzes input and retrieve keywords
	 * @param input the given user input
	 * @return a list with the found keywords
	 */
	public static ArrayList<String> analyze(String input) {
		/*TODO analyze input and extract important keywords! List the keywords and return them to the DM*/
		
		return null;
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
	public void loadKeywordsFromFile(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				if (!line.equals("") && !line.startsWith("//")) //ignore comments
					keywords.add(line);
		    }
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
