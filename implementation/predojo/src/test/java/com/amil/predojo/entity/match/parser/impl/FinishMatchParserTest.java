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
import java.util.Calendar;
import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.match.file.log.parser.impl.CreateMatchParser;
import com.amil.predojo.entity.match.file.log.parser.impl.FinishMatchParser;

/**
 * @author Juliano Sena
 *
 */
public class FinishMatchParserTest {

	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void deveRetornarMatchFinalizadoComSucesso(){
		try {
			Match match = new CreateMatchParser().parse("23/04/2013 15:34:22 - New match 11348965 has started");

			String toFinishMatchParse = "23/04/2013 15:39:22 - Match 11348965 has ended";
			FinishMatchParser finishMatchParser = new FinishMatchParser(match);
			match = finishMatchParser.parse(toFinishMatchParse);

			assertThat("Match retornado não deve ser nulo", match, is(notNullValue()));
			assertThat("O datetime de finalização do match não pode ser nulo", match.getFinishDatetime(), is(notNullValue()));
			
		} catch (ParseException e) {
			fail("Problemas ao realizar o parse de criação ou finalização do match");
		}
	}

	@Test
	public void deveRetornarRetornarExcecaoDizendoQueOMatchPassadoNaoDeveSerNulo(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Para o encerramento o match não pode ser nulo ou não startado!");

		Match matchNulo = null;
		new FinishMatchParser(matchNulo);
	}

	@Test
	public void deveRetornarMatchFinalizadoSemAlteracaoNaDataCriacaoComSucesso(){
		try {
			Match match = new CreateMatchParser().parse("23/04/2013 15:34:22 - New match 11348965 has started");
			Calendar calendar = Calendar.getInstance();
			calendar.set(2013, Calendar.APRIL, 23, 15, 34, 22);
			calendar.set(Calendar.MILLISECOND, 0);
			Date matchCreationDate = calendar.getTime();

			String toParse = "23/04/2013 15:39:22 - Match 11348965 has ended";
			FinishMatchParser finishMatchParser = new FinishMatchParser(match);
			match = finishMatchParser.parse(toParse);

			assertThat("Match retornado não deve ser nulo", match, is(notNullValue()));
			assertThat("A data de criação não pode ter sido alterada", matchCreationDate, equalTo(match.getCreateDatetime()));
			assertThat("O datetime de finalização do match não pode ser nulo", match.getFinishDatetime(), is(notNullValue()));
			
		} catch (ParseException e) {
			fail("Problemas ao realizar o parse de criação ou finalização do match");
		}
	}

	@Test
	public void deveRetornarMatchFinalizadoComDatetimeFinalizacaoCerto(){
		try {
			Match match = new CreateMatchParser().parse("23/04/2013 15:34:22 - New match 11348965 has started");

			String toParse = "23/04/2013 15:39:22 - Match 11348965 has ended";
			FinishMatchParser finishMatchParser = new FinishMatchParser(match);
			Calendar calendar = Calendar.getInstance();
			calendar.set(2013, Calendar.APRIL, 23, 15, 39, 22);
			calendar.set(Calendar.MILLISECOND, 0);
			Date finishedMatchDateExpected = calendar.getTime();

			match = finishMatchParser.parse(toParse);

			assertThat("Match retornado não deve ser nulo", match, is(notNullValue()));
			assertThat("O datetime de finalização do match não pode ser nulo", match.getFinishDatetime(), is(notNullValue()));
			assertThat("O datetime de finalização deve ser igual ao do texto parseado", finishedMatchDateExpected, equalTo(match.getFinishDatetime()));
			
		} catch (ParseException e) {
			fail("Problemas ao realizar o parse de criação ou finalização do match");
		}
	}
}