package dev.lasantae;

import java.io.File;

import javax.naming.directory.InvalidAttributeValueException;

import dev.lasantae.utils.WordlistUtils;

/**
 * A wordlist should be a file containing more than one word, each separated by a new line. 
 */
public class Wordlist {
	/*
	 * Static
	 */
	
	/**
	 * Instantiates a Wordlist object if the file passed is a valid wordlist.
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
