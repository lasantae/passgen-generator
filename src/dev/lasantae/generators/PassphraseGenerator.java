/**
 * 
 */
package dev.lasantae.generators;

import java.io.File;
import java.security.SecureRandom;

import javax.naming.directory.InvalidAttributeValueException;

import dev.lasantae.Wordlist;
import dev.lasantae.utils.WordlistUtils;

/**
 * @author Ernesto Rosa La Santa
 *
 */
public class PassphraseGenerator {
	
	public static String getPassphrase(Wordlist w, int numWords, String wordSeparator, boolean isLowercase, boolean isUppercase,
								  boolean isTitleCase) throws InvalidAttributeValueException {
		// TODO: Generate Passphrase.
		
		StringBuilder passphrase = new StringBuilder();
		
		
		for (int i = 0; i < numWords; i++) {
			// get random word
			SecureRandom secureRandom = new SecureRandom();
			
			int randomInt = secureRandom.nextInt(w.getSize() + 1);
			String word = WordlistUtils.getWord(w, randomInt);
			
			if (isLowercase) {
				word.toLowerCase();
			} else if (isTitleCase) {
				word = word.substring(0, 1).toUpperCase().concat(word.substring(1));
			} else {
				word.toUpperCase();
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
