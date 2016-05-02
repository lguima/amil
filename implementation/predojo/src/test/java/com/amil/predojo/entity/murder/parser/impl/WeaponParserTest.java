package com.amil.predojo.entity.murder.parser.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.text.ParseException;

import org.junit.Test;

import com.amil.predojo.entity.Weapon;
import com.amil.predojo.entity.weapon.parser.impl.WeaponParser;

/**
 * @author Juliano Sena
 *
 */
public class WeaponParserTest {

	@Test
	public void deveRetornarUmaArmaComSucesso(){
		WeaponParser weaponParser = new WeaponParser();
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M16";

		try {
			Weapon weapon = weaponParser.parse(toParse);
			assertThat("A arma não pode ser nula", weapon, is(notNullValue()));

		} catch (ParseException e) {
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarUmaArmaComNomeCompostoComSucesso(){
		WeaponParser weaponParser = new WeaponParser();
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M14 Colta Contra-Terroristas";
		String expectedWeaponName = "M14 Colta Contra-Terroristas";

		try {
			Weapon weapon = weaponParser.parse(toParse);
			assertThat("A arma não pode ser nula", weapon, is(notNullValue()));
			assertThat("O nome da arma deve ser 'M14 Colta Contra-Terroristas'", expectedWeaponName, equalTo(weapon.getName()));

		} catch (ParseException e) {
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}
}