/*
Yirui Jiang, 64137163
Haoming Li, 20426226
Kristina Wong, 76513468
Shengjie Xu, 10616769
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchEngine {

	public static void main(String[] args) {
		System.out.println("Enter your search query here: ");
		Scanner userInput = new Scanner( System.in );
		String nextInput = userInput.nextLine(); // Saves the user's input
		String termId = getTermID(nextInput); 

	}
	
	// Get the ID of a given term
	public static String getTermID (String term) { 
		
		String id = new String("");
		File file = new File("id_term_index.txt"); // References file with terms and term IDs

		try {
			Scanner termScanner = new Scanner(file);
		    String text = null;

		    while ((text = termScanner.nextLine()) != null) {
		        if (term.equals(text.split(" : ")[1])) { // Checks if a term in the file matches input term
		        	id = text.split(" : ")[0]; // Obtains the id of the matching term
		        	break;
		        }
		    }
		    termScanner.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} 
		return id;
	}
		
}
