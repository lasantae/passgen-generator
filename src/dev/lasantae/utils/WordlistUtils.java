package dev.lasantae.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.naming.directory.InvalidAttributeValueException;

import dev.lasantae.pojos.Wordlist;

public class WordlistUtils {
	public static boolean validate(File wordlist) {
		/*
		 *  TODO: Check if wordlist is either a txt or a csv file and if it is comma delimited. 
		 *  The file is comma delimited if it contains a comma.
		 */ 
		boolean isValid = false;
		
		if (!(wordlist.isFile())) return isValid;
		if (!(getExtension(wordlist).equals("csv")) && !(getExtension(wordlist).equals("txt"))) return isValid;
		
		try (BufferedReader br = new BufferedReader(new FileReader(wordlist))) {
			String line = br.readLine();
			if (line.contains(",")) isValid = true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return isValid;
	}
	
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
	
	public static String getWord(Wordlist w, int n) throws InvalidAttributeValueException {
		/*
		 *  TODO: Return the nth word.
		 *  If n > wordlist size, return the last word in the wordlist.
		 */

		if (n < 1) throw new InvalidAttributeValueException("Unable to get word.");
		
		File wordlist = new File(w.getFilePath());
		String word = "";
		int lineNumber = 0;
		
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
	
	private static String getExtension(File f) {
		String fileName = f.getName();
		String extension = fileName.substring(fileName.length() - 3, fileName.length());
		
		return extension;
	}
	
	/**
	 * Work-in-progress; not implemented.
	 */
	private static void calculatePasswordStrength() {
		
	}
}
