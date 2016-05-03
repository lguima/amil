/**
 * 
 */
package com.amil.predojo.entity.match.file.log.parser.impl;

import java.text.ParseException;
import java.util.Date;

import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.match.parser.exception.FinishMatchException;
import com.amil.predojo.entity.match.parser.impl.MatchIdParser;
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
			MatchIdParser matchIdParser = new MatchIdParser();
			Long matchId = matchIdParser.parse(value);

			if(!matchId.equals(match.getId())){
				throw new ParseException("Id de encerramento divergente do id do match recebido como parâmetro", 0);
			}

			try {
				DatetimeParser datetimeParser = new DatetimeParser();
				Date finishDatetime = datetimeParser.parse(value);
				match.finish(finishDatetime);
			} catch (FinishMatchException e){
				throw new ParseException(e.getMessage(), 0);
			}

			return match;
		} else {
			return null;
		}
	}
}
