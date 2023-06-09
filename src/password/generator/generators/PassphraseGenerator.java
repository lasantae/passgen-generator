/**
 * 
 */
package password.generator.generators;

import password.generator.data.Wordlist;
import password.generator.generators.utils.WordlistUtils;

import java.security.SecureRandom;

/**
 * @author Ernesto Rosa La Santa
 *	Used for passphrase generation.
 */
public class PassphraseGenerator {
	
	public enum Cases {TITLE_CASE, LOWERCASE, UPPERCASE}
	
	/**
	 * Generates a passphrase.
	 * @param w - Wordlist
	 * @param numWords - the number of words in the passphrase.
	 * @param wordSeparator - delimiter.
	 * @param c - TitleCase, lowercase, UPPERCASE.
	 * @return String with the value of the generated passphrase.
	 */
	public static String getPassphrase(Wordlist w, int numWords, String wordSeparator, Cases c){
		// TODO: Generate Passphrase.
		
		StringBuilder passphrase = new StringBuilder();
		
		
		for (int i = 0; i < numWords; i++) {
			// get random word
			SecureRandom secureRandom = new SecureRandom();
			
			int randomInt = secureRandom.nextInt(1, w.getSize() + 1);
			String word = WordlistUtils.getWord(w, randomInt);
			
			switch (c) {
				case TITLE_CASE -> word = word.substring(0, 1).toUpperCase().concat(word.substring(1));
				case LOWERCASE -> word = word.toLowerCase();
				case UPPERCASE -> word = word.toUpperCase();
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
