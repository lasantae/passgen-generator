package dev.lasantae.pojos;

import java.io.File;

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
	 */
	public static Wordlist instantiate(File f) {
		if (!(WordlistUtils.validate(f))) {
			// TODO: throw invalid wordlist error.
			return null;
		}
		
		return new Wordlist(f);
	}
	
	/*
	 * Instance
	 */
	
	
	private File file;
	private int size;
	
	private Wordlist(File f) {
		super();
		
		this.setSize(WordlistUtils.getWordlistSize(this));
		this.setFile(f);
		
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if (size < 2) {
			// Throw error if size is less than 2?
			return;
		}
		
		this.size = size;
	}
	
	
}
