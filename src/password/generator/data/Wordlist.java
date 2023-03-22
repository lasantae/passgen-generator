package password.generator.data;

import java.io.File;

import javax.naming.directory.InvalidAttributeValueException;

import password.generator.generators.utils.WordlistUtils;

/**
 * A wordlist must be a text file with more than a word, each separated by a new line. 
 * @author Ernesto Rosa La Santa
 */
public class Wordlist {
	/*
	 * Static
	 */
	
	/**
	 * Instantiates a Wordlist object if the file passed is a valid wordlist.
	 * @param f - file object of the wordlist txt file.
	 * @return A wordlist object if f is a valid wordlist.
	 * @throws InvalidAttributeValueException 
	 */
	public static Wordlist instantiate(File f) throws InvalidAttributeValueException {
		if (!(WordlistUtils.validate(f))) {
			// could change to throw invalid wordlist error.
			throw new InvalidAttributeValueException("File is not a wordlist.");
		}
		
		return new Wordlist(f);
	}

	
	/*
	 * Instance
	 */
	
	private String filePath;
	private int size;
	
	private Wordlist(File f) {
		super();
		
		this.filePath = f.getAbsolutePath();
		this.size = WordlistUtils.getWordlistSize(this);
		
	}

	public String getFilePath() {
		return filePath;
	}

	public int getSize() {
		return size;
	}
	
}
