package com.amil.predojo.entity.murder.parser.impl;

import java.text.ParseException;

import com.amil.predojo.entity.Murder;
import com.amil.predojo.entity.Player;
import com.amil.predojo.entity.Weapon;
import com.amil.predojo.entity.player.parser.impl.KillerParser;
import com.amil.predojo.entity.player.parser.impl.VictimParser;
import com.amil.predojo.entity.weapon.parser.impl.WeaponParser;
import com.amil.predojo.parser.AbstractParser;
import com.amil.predojo.parser.impl.DatetimeParser;

/**
 * @author Juliano Sena
 *
 */
public class MurderParser extends AbstractParser<Murder, String> {

	/**
	 * @param regex
	 */
	public MurderParser() {
		super("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)\\s([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]\\s-\\s\\<*[\\w\\s]+\\>*\\skilled\\s\\<*[\\w\\s]+\\>*\\susing\\s\\<*[\\w\\s]+\\>*");
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.parser.Parser#parse(java.lang.Object)
	 */
	public Murder parse(String value) throws ParseException {
		Murder murder = null;
		if(isParsed(value)){
			murder = new Murder();
			
			DatetimeParser datetimeParser = new DatetimeParser();
			murder.setDatetime(datetimeParser.parse(value));

			KillerParser killerParser = new KillerParser();
			Player killer = killerParser.parse(value);
			murder.setKiller(killer);

			VictimParser victimParser = new VictimParser();
			Player victim = victimParser.parse(value);
			murder.setVictim(victim);

			WeaponParser weaponParser = new WeaponParser();
			Weapon weapon = weaponParser.parse(value);
			murder.setWeapon(weapon);
		}
		return murder;
	}

}
