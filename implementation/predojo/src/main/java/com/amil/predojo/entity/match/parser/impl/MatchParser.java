package com.amil.predojo.entity.match.parser.impl;

import com.amil.predojo.entity.Match;
import com.amil.predojo.parser.AbstracParser;

/**
 * @author Juliano Sena
 *
 */
public class MatchParser extends AbstracParser<Match> {

	/**
	 * @param pattern
	 */
	public MatchParser() {
		super("New match\\s\\d+\\shas\\sstarted");
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.parser.impl.Parse#parse(java.lang.String)
	 */
	public Match parse(String value) {
		Match match = null;
		if(isParsed(value)){
		}

		return match;
	}
}
