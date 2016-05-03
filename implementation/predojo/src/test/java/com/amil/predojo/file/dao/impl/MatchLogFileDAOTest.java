package com.amil.predojo.file.dao.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Collection;

import org.junit.Test;

import com.amil.predojo.entity.Match;

/**
 * @author Juliano Sena
 *
 */
public class MatchLogFileDAOTest {

	@Test
	public void deveRetornarQuantidadeEsperadasDeMatchs(){
		try {
			String filePath = "src/test/resources/match/log/tres-matchs.log";
			MatchLogFileDAO matchLogFileDAO = new MatchLogFileDAO(filePath);
			Collection<Match> matchCollection = matchLogFileDAO.findAll();

			assertThat("A coleção de matchs não deve ser nula", matchCollection, is(notNullValue()));
			assertThat("A coleção de matchs não pode ser vazia", matchCollection, not(emptyCollectionOf(Match.class)));
			assertThat("A coleção deve ter três matchs", matchCollection, hasSize(3));

		} catch (FileNotFoundException e){
			fail("Falha no teste, arquivo não encontrado");
		}
	}

}