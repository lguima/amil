/**
 * 
 */
package com.amil.predojo.entity.player.parser.impl;

import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.text.ParseException;

import org.junit.Test;

import com.amil.predojo.entity.Player;

/**
 * @author Juliano Sena
 *
 */
public class KillerParserTest {

	@Test
	public void deveRetornarUmAssassinoComNomeIgualDoTextoDeAssassinatoParseadoComSucesso(){
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		try {
			KillerParser killerParser = new KillerParser();
			Player killer = killerParser.parse(toParse);

			assertThat("O assassino não pode ser nulo", killer, is(notNullValue()));
			assertThat("O assassino nome do assassino tem que ser Roman", "Roman", equalTo(killer.getName()));
		} catch (ParseException e) {
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

}
