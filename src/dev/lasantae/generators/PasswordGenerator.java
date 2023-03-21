/**
 * 
 */
package dev.lasantae.generators;

import java.security.SecureRandom;

/**
 * @author Ernesto Rosa La Santa
 *
 */
public class PasswordGenerator {
	
	private final static String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final static String LOWERCASE_LETTERS = UPPERCASE_LETTERS.toLowerCase();
    private final static String SYMBOLS = "!@#$%^&*^&*";
    private final static String NUMBERS = "0123456789";


    public static String getPassword(int length, boolean includeUppercaseLetters, boolean includeLowercaseLetters,
                               	  	 boolean includeSymbols, boolean includeNumbers) {
        StringBuilder password = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();


        for (int i = 0; i < length; i++) {
            int characterSelection = secureRandom.nextInt(4);


            switch (characterSelection) {
                case 0:
                    if (!includeUppercaseLetters) {
                        i--;
                        continue;
                    }

                    char uppercaseLetter = UPPERCASE_LETTERS.charAt(secureRandom.nextInt(UPPERCASE_LETTERS.length()));
                    password.append(uppercaseLetter);
                    break;

                case 1:
                    if (!includeLowercaseLetters) {
                        i--;
                        continue;
                    }

                    char lowercaseLetter = LOWERCASE_LETTERS.charAt(secureRandom.nextInt(LOWERCASE_LETTERS.length()));
                    password.append(lowercaseLetter);
                    break;

                case 2:
                    if (!includeSymbols) {
                        i--;
                        continue;
                    }

                    char symbol = SYMBOLS.charAt(secureRandom.nextInt(SYMBOLS.length()));
                    password.append(symbol);
                    break;

                case 3:
                    if (!includeNumbers) {
                        i--;
                        continue;
                    }

                    char number = NUMBERS.charAt(secureRandom.nextInt(NUMBERS.length()));
                    password.append(number);
                    break;
            }
        }

        return password.toString();
    }
}
