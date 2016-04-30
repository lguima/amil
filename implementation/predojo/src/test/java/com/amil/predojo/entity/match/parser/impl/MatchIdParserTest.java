/**
 * 
 */
package com.amil.predojo.entity.match.parser.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

import java.text.ParseException;

import org.junit.Test;

/**
 * @author Juliano Sena
 *
 */
public class MatchIdParserTest {

	@Test
	public void deveRetonarMatchIdDoTextoParseadoComSucesso(){
		try {
			MatchIdParser matchIdParser = new MatchIdParser();
			Long matchId = matchIdParser.parse("23/04/2013 15:34:22 - New match 11348965 has started");

			assertThat("Id do Match não deve ser nulo", matchId, is(notNullValue()));
		} catch (ParseException e) {
			fail("Problemas ao realizar o parser de %s, corrija e tente novamente");
		}
	}

	@Test
	public void deveRetonarMatchIdIgualDoTextoParseadoComSucesso(){
		try {
			MatchIdParser matchIdParser = new MatchIdParser();
			Long matchId = matchIdParser.parse("23/04/2013 15:34:22 - New match 11348965 has started");

			assertThat("Id do Match não deve ser nulo", matchId, is(notNullValue()));
			assertThat("Id do Match não deve ser nulo", 11348965l, equalTo(matchId));
		} catch (ParseException e) {
			fail("Problemas ao realizar o parser de %s, corrija e tente novamente");
		}
	}
}
