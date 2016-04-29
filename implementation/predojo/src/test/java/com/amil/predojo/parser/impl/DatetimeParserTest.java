package com.amil.predojo.parser.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/**
 * @author Juliano Sena
 *
 */
public class DatetimeParserTest {

	@Test
	public void deveRetornarDataComValorCertoComSucesso(){
		DatetimeParser datetimeParser = new DatetimeParser();
		Date date = datetimeParser.parse("23/04/2013 15:34:22 - New match 11348965 has started");
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 23);
		calendar.set(Calendar.MONTH, Calendar.APRIL);
		calendar.set(Calendar.YEAR, 2013);
		calendar.set(Calendar.HOUR_OF_DAY, 15);
		calendar.set(Calendar.MINUTE, 34);
		calendar.set(Calendar.SECOND, 22);
		calendar.set(Calendar.MILLISECOND, 0);
		Date dateExpected = calendar.getTime();

		assertThat("O valor da data não deve ser nulo", date, is(notNullValue()));
		assertThat("O valor da data deve ser 23/04/2013 15:34:22", date.getTime(), is(equalTo(dateExpected.getTime())));
	}

	@Test
	public void deveRetornarDataComValorNulloPorSerUmaDataInvalida(){
		DatetimeParser datetimeParser = new DatetimeParser();
		Date date = datetimeParser.parse("31/04/2013 15:34:22 - New match 11348965 has started");

		assertThat("O valor de date não deve ser nulo", date, is(nullValue()));
	}
}
