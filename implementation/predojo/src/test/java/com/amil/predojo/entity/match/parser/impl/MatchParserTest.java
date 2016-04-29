/**
 * 
 */
package com.amil.predojo.entity.match.parser.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Calendar;

import org.junit.Test;

import com.amil.predojo.entity.Match;

/**
 * @author Juliano Sena
 *
 */
public class MatchParserTest {

	@Test
	public void deveRetornarUmMatchComSucesso(){
		MatchParser matchParser = new MatchParser();
		Match match = matchParser.parse("23/04/2013 15:34:22 - New match 11348965 has started");

		assertThat("O match retornado do método parse não deve ser nullo", match, is(notNullValue()));
	}

	@Test
	public void deveRetornarUmMatchNulo(){
		MatchParser matchParser = new MatchParser();
		Match match = matchParser.parse("23/04/2013 15:34:22 11348965 has started");

		assertThat("O match retornado do método parse deve ser nullo", match, is(nullValue()));
	}


	@Test
	public void deveRetornarUmMatchComDatetimeConfiguradoComSucesso(){
		MatchParser matchParser = new MatchParser();
		Match match = matchParser.parse("23/04/2013 15:34:22 - New match 11348965 has started");

		assertThat("O match retornado do método parse não deve ser nullo", match, is(nullValue()));
		assertThat("O datetime de criação do match deve ser igual a 23/04/2013 15:34:22", match, is(nullValue()));
	}
}