package com.amil.predojo.entity.match.parser.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.match.file.log.parser.impl.CreateMatchParser;

/**
 * @author Juliano Sena
 *
 */
public class CreateMatchParserTest {

	@Test
	public void deveRetornarMatchCriadoComSucesso(){
		CreateMatchParser createMatchParser = new CreateMatchParser();
		String toParse = "23/04/2013 15:34:22 - New match 11348965 has started";
		try {
			Match match = createMatchParser.parse(toParse);

			assertThat("Match retornado não deve ser nulo", match, is(notNullValue()));
		} catch (ParseException e) {
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarMatchComDatetimeDeCriacaoConfiguradoComSucesso(){
		CreateMatchParser createMatchParser = new CreateMatchParser();
		String toParse = "23/04/2013 15:34:22 - New match 11348965 has started";
		try {
			Match match = createMatchParser.parse(toParse);

			assertThat("Match retornado não deve ser nulo", match, is(notNullValue()));
			assertThat("Data de criação setada no match não deve ser nula", match.getCreateDatetime(), is(notNullValue()));
		} catch (ParseException e) {
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarMatchComDatetimeCriacaoCerto(){
		CreateMatchParser createMatchParser = new CreateMatchParser();
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, Calendar.APRIL, 23, 15, 34, 22);
		calendar.set(Calendar.MILLISECOND, 0);
		Date expectedDate = calendar.getTime();

		String toParse = "23/04/2013 15:34:22 - New match 11348965 has started";
		try {
			Match match = createMatchParser.parse(toParse);

			assertThat("Match retornado não deve ser nulo", match, is(notNullValue()));
			assertThat("Data de criação setada no match não deve ser nula", match.getCreateDatetime(), is(notNullValue()));
			assertThat("Data de criação setada no match não deve ser nula", expectedDate, equalTo(match.getCreateDatetime()));
		} catch (ParseException e) {
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarMatchComIdConfiguradoComSucesso(){
		CreateMatchParser createMatchParser = new CreateMatchParser();
		String toParse = "23/04/2013 15:34:22 - New match 11348965 has started";

		try {
			Match match = createMatchParser.parse(toParse);

			assertThat("Match retornado não deve ser nulo", match, is(notNullValue()));
			assertThat("Id do match deve ser 11348965", match.getId(), is(notNullValue()));
		} catch (ParseException e) {
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

	@Test
	public void deveRetornarMatchComIdIgualDoTextoParseadoComSucesso(){
		CreateMatchParser createMatchParser = new CreateMatchParser();
		String toParse = "23/04/2013 15:34:22 - New match 11348965 has started";

		try {
			Match match = createMatchParser.parse(toParse);

			assertThat("Match retornado não deve ser nulo", match, is(notNullValue()));
			assertThat("Id do match deve ser 11348965", match.getId(), is(notNullValue()));
			assertThat("Id do match deve ser 11348965", 11348965l, equalTo(match.getId()));
		} catch (ParseException e) {
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}
}