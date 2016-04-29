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
public abstract class AbstracParser<T> implements Parser<T> {

	protected final Pattern pattern;
	protected Matcher matcher;

	public AbstracParser(String regex){
		this.pattern = Pattern.compile(regex);
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
