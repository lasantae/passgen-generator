/**
 * 
 */
package dev.lasantae.generators;

import java.io.File;
import java.security.SecureRandom;

import javax.naming.directory.InvalidAttributeValueException;

import dev.lasantae.Cases;
import dev.lasantae.Wordlist;
import dev.lasantae.utils.WordlistUtils;

/**
 * @author Ernesto Rosa La Santa
 *	
 */
public class PassphraseGenerator {
	
	public static String getPassphrase(Wordlist w, int numWords, String wordSeparator, Cases c) throws InvalidAttributeValueException {
		// TODO: Generate Passphrase.
		
		StringBuilder passphrase = new StringBuilder();
		
		
		for (int i = 0; i < numWords; i++) {
			// get random word
			SecureRandom secureRandom = new SecureRandom();
			
			int randomInt = secureRandom.nextInt(w.getSize() + 1);
			String word = WordlistUtils.getWord(w, randomInt);
			
			switch (c) {
				case TITLE_CASE -> word = word.substring(0, 1).toUpperCase().concat(word.substring(1));
				case LOWERCASE -> word.toLowerCase();
				case UPPERCASE -> word.toUpperCase();
			}
			
			// add word and word separator (delimiter)
			passphrase.append(word);
			
			// add word separator if it is not the last word.
			if (i == numWords - 1) continue;
			passphrase.append(wordSeparator);
		}
		
		return passphrase.toString();
	}
	
	
}
