/**
 * 
 */
package com.amil.predojo.entity.assassination.parser.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.amil.predojo.entity.Assassination;

/**
 * @author Juliano Sena
 *
 */
public class AssassinationParserTest {

	@Test
	public void deveRetornarUmAssassinatoComSucesso() {
		AssassinationParser assassinationParser = new AssassinationParser();
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		try {
			Assassination assassination = assassinationParser.parse(toParse);

			assertThat("Assassinato retornado não deve ser nulo", assassination, is(notNullValue()));
		} catch (ParseException e) {
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarUmAssassinatoComDatetimeIgualAoDoTextoParseado(){
		AssassinationParser assassinationParser = new AssassinationParser();
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, Calendar.APRIL, 23, 15, 36, 04);
		calendar.set(Calendar.MILLISECOND, 0);
		Date expectedDate = calendar.getTime();

		try {
			Assassination assassination = assassinationParser.parse(toParse);

			assertThat("Assassinato retornado não deve ser nulo", assassination, is(notNullValue()));
			assertThat("Datetime do assassinato não deve ser nulo", assassination.getDatetime(), is(notNullValue()));
			assertThat("Datetime do assassinato deve ser 23/04/2013 15:36:04", expectedDate, equalTo(assassination.getDatetime()));
		} catch (ParseException e){
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarUmAssassinatoComDatetimeAssassinoIguaisAoDoTextoParseado(){
		AssassinationParser assassinationParser = new AssassinationParser();
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, Calendar.APRIL, 23, 15, 36, 04);
		calendar.set(Calendar.MILLISECOND, 0);
		Date expectedDate = calendar.getTime();

		try {
			Assassination assassination = assassinationParser.parse(toParse);

			assertThat("Assassinato retornado não deve ser nulo", assassination, is(notNullValue()));
			assertThat("Datetime do assassinato não deve ser nulo", assassination.getDatetime(), is(notNullValue()));
			assertThat("Datetime do assassinato deve ser 23/04/2013 15:36:04", expectedDate, equalTo(assassination.getDatetime()));
			assertThat("O assassino não pode ser nulo", assassination.getMurder(), is(notNullValue()));
			assertThat("O nome do assassino deve ser nulo", assassination.getMurder().getName(), is(notNullValue()));
			assertThat("O nome do assassino deve ser Roman", assassination.getMurder().getName(), equalTo("Roman"));
		} catch (ParseException e){
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarUmAssassinatoComDatetimeAssassinoVictimIguaisAoDoTextoParseado(){
		AssassinationParser assassinationParser = new AssassinationParser();
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, Calendar.APRIL, 23, 15, 36, 04);
		calendar.set(Calendar.MILLISECOND, 0);
		Date expectedDate = calendar.getTime();

		try {
			Assassination assassination = assassinationParser.parse(toParse);

			assertThat("Assassinato retornado não deve ser nulo", assassination, is(notNullValue()));
			assertThat("Datetime do assassinato não deve ser nulo", assassination.getDatetime(), is(notNullValue()));
			assertThat("Datetime do assassinato deve ser 23/04/2013 15:36:04", expectedDate, equalTo(assassination.getDatetime()));
			assertThat("O assassino não pode ser nulo", assassination.getMurder(), is(notNullValue()));
			assertThat("O nome do assassino deve ser nulo", assassination.getMurder().getName(), is(notNullValue()));
			assertThat("O nome do assassino deve ser Roman", assassination.getMurder().getName(), equalTo("Roman"));
			assertThat("O nome da vítima deve ser Nick", assassination.getVictim().getName(), equalTo("Nick"));
		} catch (ParseException e){
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}
}