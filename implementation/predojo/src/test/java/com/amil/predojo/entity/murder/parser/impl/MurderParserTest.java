package com.amil.predojo.entity.murder.parser.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.amil.predojo.entity.Murder;
import com.amil.predojo.entity.assassination.parser.impl.MurderParser;

/**
 * @author Juliano Sena
 *
 */
public class MurderParserTest {

	@Test
	public void deveRetornarUmAssassinatoComSucesso() {
		MurderParser murderParser = new MurderParser();
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		try {
			Murder murder = murderParser.parse(toParse);

			assertThat("Assassinato retornado não deve ser nulo", murder, is(notNullValue()));
		} catch (ParseException e) {
			fail(
				String.format("Não foi possivel realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarUmAssassinatoComDatetimeIgualAoDoTextoParseado(){
		MurderParser murderParser = new MurderParser();
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, Calendar.APRIL, 23, 15, 36, 04);
		calendar.set(Calendar.MILLISECOND, 0);
		Date expectedDate = calendar.getTime();

		try {
			Murder murder = murderParser.parse(toParse);

			assertThat("Assassinato retornado não deve ser nulo", murder, is(notNullValue()));
			assertThat("Datetime do assassinato não deve ser nulo", murder.getDatetime(), is(notNullValue()));
			assertThat("Datetime do assassinato deve ser 23/04/2013 15:36:04", expectedDate, equalTo(murder.getDatetime()));
		} catch (ParseException e){
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarUmAssassinatoComDatetimeAssassinoIguaisAoDoTextoParseado(){
		MurderParser murderParser = new MurderParser();
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, Calendar.APRIL, 23, 15, 36, 04);
		calendar.set(Calendar.MILLISECOND, 0);
		Date expectedDate = calendar.getTime();

		try {
			Murder murder = murderParser.parse(toParse);

			assertThat("Assassinato retornado não deve ser nulo", murder, is(notNullValue()));
			assertThat("Datetime do assassinato não deve ser nulo", murder.getDatetime(), is(notNullValue()));
			assertThat("Datetime do assassinato deve ser 23/04/2013 15:36:04", expectedDate, equalTo(murder.getDatetime()));
			assertThat("O assassino não pode ser nulo", murder.getkiller(), is(notNullValue()));
			assertThat("O nome do assassino deve ser nulo", murder.getkiller().getName(), is(notNullValue()));
			assertThat("O nome do assassino deve ser Roman", murder.getkiller().getName(), equalTo("Roman"));
		} catch (ParseException e){
			fail(
				String.format("Nao foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarUmAssassinatoComDatetimeAssassinoVictimIguaisAoDoTextoParseado(){
		MurderParser murderParser = new MurderParser();
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, Calendar.APRIL, 23, 15, 36, 04);
		calendar.set(Calendar.MILLISECOND, 0);
		Date expectedDate = calendar.getTime();

		try {
			Murder murder = murderParser.parse(toParse);

			assertThat("Assassinato retornado não deve ser nulo", murder, is(notNullValue()));
			assertThat("Datetime do assassinato não deve ser nulo", murder.getDatetime(), is(notNullValue()));
			assertThat("Datetime do assassinato deve ser 23/04/2013 15:36:04", expectedDate, equalTo(murder.getDatetime()));
			assertThat("O assassino não pode ser nulo", murder.getkiller(), is(notNullValue()));
			assertThat("O nome do assassino deve ser nulo", murder.getkiller().getName(), is(notNullValue()));
			assertThat("O nome do assassino deve ser Roman", murder.getkiller().getName(), equalTo("Roman"));
			assertThat("O nome da vítima deve ser Nick", murder.getVictim().getName(), equalTo("Nick"));
		} catch (ParseException e){
			fail(
				String.format("Não foi possivel realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarUmAssassinatoComDatetimeAssassinoVictimWeaponIguaisAoDoTextoParseado(){
		MurderParser murderParser = new MurderParser();
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, Calendar.APRIL, 23, 15, 36, 04);
		calendar.set(Calendar.MILLISECOND, 0);
		Date expectedDate = calendar.getTime();

		try {
			Murder murder = murderParser.parse(toParse);

			assertThat("Assassinato retornado não deve ser nulo", murder, is(notNullValue()));
			assertThat("Datetime do assassinato não deve ser nulo", murder.getDatetime(), is(notNullValue()));
			assertThat("Datetime do assassinato deve ser 23/04/2013 15:36:04", expectedDate, equalTo(murder.getDatetime()));
			assertThat("O assassino não pode ser nulo", murder.getkiller(), is(notNullValue()));
			assertThat("O nome do assassino deve ser Roman", "Roman", equalTo(murder.getkiller().getName()));

			assertThat("A vítima não deve ser nula", murder.getVictim(), is(notNullValue()));
			assertThat("O nome da vítima deve ser Nick", "Nick", equalTo(murder.getVictim().getName()));

			assertThat("O arma não deve ser nula", murder.getWeapon(), is(notNullValue()));
			assertThat("O nome da arma deve ser M16", "M16", equalTo(murder.getWeapon().getName()));
		} catch (ParseException e){
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}
}