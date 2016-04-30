/**
 * 
 */
package com.amil.predojo.entity.match.file.log.parser.impl;

import java.text.ParseException;
import java.util.Date;

import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.match.parser.impl.MatchIdParser;
import com.amil.predojo.parser.AbstractParser;
import com.amil.predojo.parser.impl.DatetimeParser;

/**
 * @author softvaro
 *
 */
public class CreateMatchParser extends AbstractParser<Match, String> {

	public CreateMatchParser() {
		super("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)\\s([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]\\s-\\sNew\\smatch\\s\\d+\\shas\\sstarted");
	}

	public Match parse(String value) throws ParseException {
		Match match = null;
		if(isParsed(value)){
			match = new Match();
			//Datime parse process
			DatetimeParser datetimeParser = new DatetimeParser();
			Date finishDatetime = datetimeParser.parse(value);
			match.setStartDatetime(finishDatetime);

			//Match id parse process
			MatchIdParser matchIdParser = new MatchIdParser();
			Long id = matchIdParser.parse(value);
			match.setId(id);
		}

		return match;
	}

}
