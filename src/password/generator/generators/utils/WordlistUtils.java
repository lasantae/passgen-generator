package password.generator.generators.utils;

import password.generator.data.Wordlist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Ernesto Rosa La Santa.
 *	Utilities for the PassphraseGenerator class.
 */
public class WordlistUtils {
	/**
	 *  Checks if wordlist is a text file, if it contains more than one word and if it is 
	 *  delimited by new lines.
	 *  
	 *  @param wordlist - File object of the wordlist.
	 *  @return boolean value that indicates if wordlist is valid.
	 */ 
	public static boolean validate(File wordlist) {
		
		boolean isValid = false;
		
		if (!(wordlist.isFile())) return isValid;
		if (!(getExtension(wordlist).equals("txt"))) return isValid;
		
		try (BufferedReader br = new BufferedReader(new FileReader(wordlist))) {
			
			 // Check if there is more than one word and if they are new line delimited.
			String line = br.readLine();
			if (line.isBlank()) return isValid;
			if (line.contains("\n")) return isValid;
			line = br.readLine();
			if (line.isBlank()) return isValid;
			
			isValid = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return isValid;
	}
	
	/**
	 * Gets the amount of words inside a Wordlist object.
	 * @param w - Wordlist
	 * @return int value of the amount of words in the wordlist.
	 */
	public static int getWordlistSize(Wordlist w) {
		// TODO: Read the entire wordlist and return the number of words separated by commas.
		int size = 0;
		File wordlist = new File(w.getFilePath()); 
		
		try (BufferedReader br = new BufferedReader(new FileReader(wordlist))) {
			while (br.readLine() != null) size++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return size;
	}
	
	/**
	 * Returns the nth word in the passed wordlist.
	 * @param w - Wordlist
	 * @param n - Word number to return from the wordlist.
	 * @return String value of the nth word.
	 * @throws IllegalArgumentException if the wordlist has fewer words than specified n.
	 */
	public static String getWord(Wordlist w, int n) throws IllegalArgumentException {
		/*
		 *  TODO: Return the nth word.
		 *  If n > wordlist size, return the last word in the wordlist.
		 */

		if (n < 1) throw new IllegalArgumentException("Unable to get word.");
		if (n > w.getSize()) n = w.getSize();
		
		File wordlist = new File(w.getFilePath());
		String word = "";
		
		try (BufferedReader br = new BufferedReader(new FileReader(wordlist))) {
			for (int i = 0; i < n; i++) {
				word = br.readLine();
				
				if (word == null) break;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return word;
	}
	
	/**
	 * Gets the extension of a File object.
	 * @param f - File object
	 * @return String of the file extension.
	 */
	private static String getExtension(File f) {
		String fileName = f.getName();

		return fileName.substring(fileName.length() - 3, fileName.length());
	}
	
}
