/**
 * 
 */
package com.amil.predojo.entity.weapon.parser.impl;

import java.text.ParseException;

import com.amil.predojo.entity.Weapon;
import com.amil.predojo.parser.AbstractParser;

/**
 * @author Juliano Sena
 *
 */
public class WeaponParser extends AbstractParser<Weapon, String> {

	/**
	 * @param regex
	 */
	public WeaponParser() {
		super("using\\s[\\w\\s-]+");
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.parser.Parser#parse(java.lang.Object)
	 */
	public Weapon parse(String value) throws ParseException {
		Weapon weapon = null;
		if(isParsed(value)){
			this.matcher = this.pattern.matcher(value);
			this.matcher.find();
			String weaponName = this.matcher.group();
			weaponName = weaponName.replaceAll("using\\s", "");
			weapon = new Weapon();
			weapon.setName(weaponName);
		}
		return weapon;
	}
}
