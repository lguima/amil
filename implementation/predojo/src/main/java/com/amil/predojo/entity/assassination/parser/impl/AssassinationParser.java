/**
 * 
 */
package com.amil.predojo.entity.assassination.parser.impl;

import java.text.ParseException;

import com.amil.predojo.entity.Assassination;
import com.amil.predojo.entity.Player;
import com.amil.predojo.entity.Weapon;
import com.amil.predojo.entity.weapon.parser.impl.WeaponParser;
import com.amil.predojo.parser.AbstractParser;
import com.amil.predojo.parser.impl.DatetimeParser;

/**
 * @author Juliano Sena
 *
 */
public class AssassinationParser extends AbstractParser<Assassination, String> {

	/**
	 * @param regex
	 */
	public AssassinationParser() {
		super("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)\\s([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]\\s-\\s\\<*[\\w\\s]+\\>*\\skilled\\s\\<*[\\w\\s]+\\>*\\susing\\s\\<*[\\w\\s]+\\>*");
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.parser.Parser#parse(java.lang.Object)
	 */
	public Assassination parse(String value) throws ParseException {
		Assassination assassination = null;
		if(isParsed(value)){
			assassination = new Assassination();
			
			DatetimeParser datetimeParser = new DatetimeParser();
			assassination.setDatetime(datetimeParser.parse(value));

			MurderParser murderParser = new MurderParser();
			Player murder = murderParser.parse(value);
			assassination.setMurder(murder);

			VictimParser victimParser = new VictimParser();
			Player victim = victimParser.parse(value);
			assassination.setVictim(victim);

			WeaponParser weaponParser = new WeaponParser();
			Weapon weapon = weaponParser.parse(value);
			assassination.setWeapon(weapon);
		}
		return assassination;
	}

}
