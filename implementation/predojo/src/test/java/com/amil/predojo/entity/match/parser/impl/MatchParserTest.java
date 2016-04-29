/**
 * 
 */
package com.amil.predojo.entity.match.parser.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.match.parser.impl.MatchParser.StartedMatchParser;

/**
 * @author Juliano Sena
 *
 */
public class MatchParserTest {

	@Test
	public void deveRetornarUmMatchComSucesso(){
		StartedMatchParser startedMatchParser = new MatchParser.StartedMatchParser();
		Match match = startedMatchParser.parse("23/04/2013 15:34:22 - New match 11348965 has started");

		assertThat("O match retornado do método parse não deve ser nullo", match, is(notNullValue()));
	}

	@Test
	public void deveRetornarUmMatchNulo(){
		StartedMatchParser startedMatchParser = new MatchParser.StartedMatchParser();
		Match match = startedMatchParser.parse("23/04/2013 15:34:22 11348965 has started");

		assertThat("O match retornado do método parse deve ser nullo", match, is(nullValue()));
	}


	@Test
	public void deveRetornarUmMatchComDatetimeConfiguradoComSucesso(){
		StartedMatchParser startedMatchParser = new MatchParser.StartedMatchParser();
		Match match = startedMatchParser.parse("23/04/2013 15:34:22 - New match 11348965 has started");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 23);
		calendar.set(Calendar.MONTH, Calendar.APRIL);
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.HOUR_OF_DAY, 15);
		calendar.set(Calendar.MINUTE, 34);
		calendar.set(Calendar.SECOND, 22);
		calendar.set(Calendar.MILLISECOND, 0);
		Date dateExpected = calendar.getTime();

		assertThat("O match retornado do método parse não deve ser nullo", match, is(notNullValue()));
		assertThat("O datetime de criação do match deve ser igual a 23/04/2013 15:34:22", match.getStartDatetime(), is(equalTo(dateExpected)));
	}
}