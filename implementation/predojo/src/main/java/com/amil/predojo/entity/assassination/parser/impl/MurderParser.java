/**
 * 
 */
package com.amil.predojo.entity.assassination.parser.impl;

import java.text.ParseException;

import com.amil.predojo.entity.Player;
import com.amil.predojo.parser.AbstractParser;
import com.amil.predojo.parser.impl.DatetimeParser;

/**
 * @author Juliano Sena
 *
 */
public class MurderParser extends AbstractParser<Player, String> {

	public MurderParser(){
		super("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)\\s([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]\\s-\\s\\<*[\\w\\s]+\\>*\\skilled");
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.parser.Parser#parse(java.lang.Object)
	 */
	public Player parse(String value) throws ParseException {
		Player murder = null;
		if(isParsed(value)){
			String regex = new DatetimeParser().REGEX + "\\s-\\s";
			String murderName = value.replaceAll(regex, "");
			murderName = murderName.replaceAll("\\skilled\\s.*", "");
			murder = new Player();
			murder.setName(murderName);
		}
		return murder;
	}
}
