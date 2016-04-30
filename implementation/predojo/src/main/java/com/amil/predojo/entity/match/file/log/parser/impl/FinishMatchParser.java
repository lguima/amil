/**
 * 
 */
package com.amil.predojo.entity.match.file.log.parser.impl;

import java.text.ParseException;
import java.util.Date;

import com.amil.predojo.entity.Match;
import com.amil.predojo.parser.AbstractParser;
import com.amil.predojo.parser.impl.DatetimeParser;

/**
 * @author softvaro
 *
 */
public class FinishMatchParser extends AbstractParser<Match, String> {

	private Match match;

	public FinishMatchParser(Match match){
		super("Match\\s\\d+\\shas\\sended");
		if(match == null){
			throw new IllegalArgumentException("Para o encerramento o match não pode ser nulo ou não startado!");
		}
		this.match = match;
	}

	public Match parse(String value) throws ParseException {
		Match match = this.match;
		if(isParsed(value)){
			DatetimeParser datetimeParser = new DatetimeParser();
			Date finishDatetime = datetimeParser.parse(value);
			match.setFinishDatetime(finishDatetime);
			return match;
		} else {
			return null;
		}
	}
}
