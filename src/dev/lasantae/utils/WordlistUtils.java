package dev.lasantae.utils;

import java.io.File;

import dev.lasantae.pojos.Wordlist;

public class WordlistUtils {
	public static boolean validate(File wordlist) {
		/*
		 *  TODO: Check if wordlist is either a txt or a csv file and if it is comma delimited. 
		 *  The file is comma delimited if it contains a comma.
		 */ 
		
		boolean isValid = false;
		
		 return isValid;
	}
	
	public static int getWordlistSize(Wordlist w) {
		// TODO: Read the entire wordlist and return the number of words separated by commas.
		int size = 0;
		
		return size;
	}
	
	public static String getWord(Wordlist w, int n) {
		/*
		 *  TODO: Return the nth word.
		 *  If n > wordlist size, return the last word in the wordlist.
		 */
		
		return null;
	}
	
	public static void calculatePasswordStrength() {
		
	}
}
