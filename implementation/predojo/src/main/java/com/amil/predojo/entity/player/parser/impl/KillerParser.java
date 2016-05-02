/**
 * 
 */
package com.amil.predojo.entity.player.parser.impl;

import java.text.ParseException;

import com.amil.predojo.entity.Player;
import com.amil.predojo.parser.AbstractParser;
import com.amil.predojo.parser.impl.DatetimeParser;

/**
 * @author Juliano Sena
 *
 */
public class KillerParser extends AbstractParser<Player, String> {

	public KillerParser(){
		super("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)\\s([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]\\s-\\s\\<*[\\w\\s]+\\>*\\skilled");
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.parser.Parser#parse(java.lang.Object)
	 */
	public Player parse(String value) throws ParseException {
		Player killer = null;
		if(isParsed(value)){
			String regex = new DatetimeParser().REGEX + "\\s-\\s";
			String killerName = value.replaceAll(regex, "");
			killerName = killerName.replaceAll("\\skilled\\s.*", "");
			killer = new Player();
			killer.setName(killerName);
		}
		return killer;
	}
}
