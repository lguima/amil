/**
 * 
 */
package com.amil.predojo.entity.match.file.log.reader.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.emptyCollectionOf;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Iterator;

import org.junit.Test;

import com.amil.predojo.entity.Match;

/**
 * @author Juliano Sena
 *
 */
public class MatchLogFileReaderTest {

	@Test
	public void deveRetornarTresMatchsComSucesso(){
		String pathFile = "src/test/resources/match/log/tres-matchs.log";
		try {
			MatchLogFileReader matchLogFileReader = new MatchLogFileReader(pathFile);
			Collection<Match> matchCollection = matchLogFileReader.read();

			assertThat("A coleção de matchs não pode ser vazia", matchCollection, not(emptyCollectionOf(Match.class)));
			assertThat("A coleção deve ter três matchs", matchCollection, hasSize(3));
		} catch (FileNotFoundException e){
			fail(
				String.format("Arquivo %s não encontrado", pathFile)
			);
		}
	}

	@Test
	public void deveRetornarTresDiferentesMatchsFinalizadosComSucesso(){
		String pathFile = "src/test/resources/match/log/tres-matchs.log";
		try {
			MatchLogFileReader matchLogFileReader = new MatchLogFileReader(pathFile);
			Collection<Match> matchCollection = matchLogFileReader.read();

			assertThat("A coleção de matchs não pode ser vazia", matchCollection, not(emptyCollectionOf(Match.class)));
			assertThat("A coleção deve ter três matchs", matchCollection, hasSize(3));

			Iterator<Match> it = matchCollection.iterator();
			while(it.hasNext()){
				Match match = it.next();
				assertThat("A o match deve ter data de encerramento configurada", match.getFinishDatetime(), is(notNullValue()));				
			}
		} catch (FileNotFoundException e){
			fail(
				String.format("Arquivo %s não encontrado", pathFile)
			);
		}
	}

	@Test
	public void deveRetornarListaVaziaDeArquivoSemLinhaDeCriacaoDeMatch(){
		String pathFile = "src/test/resources/match/log/arquivo-sem-linha-de-criacao-de-match.log";
		try {
			MatchLogFileReader matchLogFileReader = new MatchLogFileReader(pathFile);
			Collection<Match> matchCollection = matchLogFileReader.read();

			assertThat("A coleção de matchs deve estar vazia", matchCollection, emptyCollectionOf(Match.class));

		} catch (FileNotFoundException e){
			fail(
				String.format("Arquivo %s não encontrado", pathFile)
			);
		}
	}

	@Test
	public void deveRetornarListaComDoisMatchsEncerradosUmMatchEmAndamento(){
		String pathFile = "src/test/resources/match/log/dois-match-encerrados-um-match-em-andamento.log";
		try {
			MatchLogFileReader matchLogFileReader = new MatchLogFileReader(pathFile);
			Collection<Match> matchCollection = matchLogFileReader.read();

			assertThat("A coleção de matchs não deve estar vazia", matchCollection, not(emptyCollectionOf(Match.class)));
			assertThat("A coleção deve ter três matchs", matchCollection, hasSize(3));

			Iterator<Match> it = matchCollection.iterator();
			while(it.hasNext()){
				Match match = it.next();
				if(match.getId() == 1 || match.getId() == 2){
					assertThat("A o match deve ter data de encerramento configurada", match.getFinishDatetime(), is(notNullValue()));
				} else if (match.getId() == 3){
					assertThat("A o match deve não deve data de encerramento configurada", match.getFinishDatetime(), is(nullValue()));
				}
			}

		} catch (FileNotFoundException e){
			fail(
				String.format("Arquivo %s não encontrado", pathFile)
			);
		}
	}
}