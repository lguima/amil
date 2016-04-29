package com.amil.predojo.entity.match.parser.impl;

import java.util.Date;

import com.amil.predojo.entity.Match;
import com.amil.predojo.parser.AbstracParser;
import com.amil.predojo.parser.impl.DatetimeParser;

/**
 * @author Juliano Sena
 *
 */
public class MatchParser {

	private static DatetimeParser datetimeParser = new DatetimeParser();

	private MatchParser(){}

	public static class StartedMatchParser extends AbstracParser<Match> {

		public StartedMatchParser() {
			super("New match\\s\\d+\\shas\\sstarted");
		}

		public Match parse(String value) {
			Match match = null;
			if(isParsed(value)){
				match = new Match();
				match.setStartDatetime(datetimeParser.parse(value));
			}
			return match;
		}
	}

	public static class FinishedMatchParser extends AbstracParser<Date> {

		public FinishedMatchParser() {
			super("");
		}

		public Date parse(String value) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
