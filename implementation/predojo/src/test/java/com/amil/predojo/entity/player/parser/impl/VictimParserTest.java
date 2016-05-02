/**
 * 
 */
package com.amil.predojo.entity.player.parser.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

import java.text.ParseException;

import org.junit.Test;

import com.amil.predojo.entity.Player;

/**
 * @author Juliano Sena
 *
 */
public class VictimParserTest {

	@Test
	public void deveRetornarUmaVitimaComNomeIgualDoTextoDeAssassinatoParseadoComSucesso(){
		String toParse = "23/04/2013 15:36:04 - Roman killed Nick Brain using M16";
		try {
			VictimParser killerParser = new VictimParser();
			Player victim = killerParser.parse(toParse);

			assertThat("A vitima não pode ser nula", victim, is(notNullValue()));
			assertThat("O nome da vítima tem que ser igual a 'Nick Brain'", "Nick Brain", equalTo(victim.getName()));
		} catch (ParseException e) {
			fail(
				String.format("Não foi possível realizar o parser de '%s'", toParse)
			);
		}
	}

}
