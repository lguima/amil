/**
 * 
 */
package com.amil.predojo.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Juliano Sena
 *
 */
public abstract class AbstractParser<T,E> implements Parser<T,E> {

	public final String REGEX;
	protected final Pattern pattern;
	protected Matcher matcher;

	public AbstractParser(String regex){
		REGEX = regex;
		this.pattern = Pattern.compile(REGEX);
	}

	/**
	 * Return if is parsed from received parameter is correct
	 * @param value
	 * @return boolean if matcher find occurrence
	 */
	protected boolean isParsed(String value){
		Matcher matcher = this.pattern.matcher(value);
		return matcher.find();
	}
}
