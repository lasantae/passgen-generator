package dev.lasantae.pojos;

import java.io.File;

import javax.naming.directory.InvalidAttributeValueException;

import dev.lasantae.utils.WordlistUtils;

/**
 * A wordlist should be a comma delimited file with more than 1 word. 
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
		
		this.size = WordlistUtils.getWordlistSize(this);
		this.filePath = f.getAbsolutePath();
		
	}

	public String getFilePath() {
		return filePath;
	}

	public int getSize() {
		return size;
	}
	
}
