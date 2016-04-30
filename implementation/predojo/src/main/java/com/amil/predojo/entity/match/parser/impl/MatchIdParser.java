/**
 * 
 */
package com.amil.predojo.entity.match.parser.impl;

import java.text.ParseException;

import com.amil.predojo.parser.AbstractParser;

/**
 * @author Juliano Sena
 *
 */
public class MatchIdParser extends AbstractParser<Long, String> {

	/**
	 * @param regex
	 */
	public MatchIdParser() {
		super("\\d+\\shas\\s(start|end)ed");
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.parser.Parser#parse(java.lang.Object)
	 */
	public Long parse(String value) throws ParseException {
		Long id = null;
		if(isParsed(value)){
			this.matcher = this.pattern.matcher(value);
			boolean wasFound = this.matcher.find();
			if(wasFound){
				String found = this.matcher.group();
				id = Long.parseLong(found.replaceAll("\\D", ""));
			}
		}
		return id;
	}

}
