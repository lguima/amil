/**
 * 
 */
package com.amil.predojo.entity.ranking;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.Player;
import com.amil.predojo.entity.Weapon;
import com.amil.predojo.entity.match.file.log.reader.impl.MatchLogFileReader;
import com.amil.predojo.entity.ranking.exception.RankingException;
import com.amil.predojo.entity.ranking.impl.MatchRanking;
import com.amil.predojo.entity.ranking.impl.Ranking;

/**
 * @author Juliano Sena
 *
 */
public class MatchRankingTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void deveRetornarExceptionDizendoQueMatchNaoPodeSerNulo() throws RankingException{
		//Expected expcetion
		thrown.expect(RankingException.class);
		thrown.expectMessage("Objeto match não pode ser nulo!");

		Match match = null;
		Ranking<RankingPlayer> ranking = new MatchRanking(match);
		ranking.rankear();
	}

	@Test
	public void deveRetornarQuantidadeTotalDeJogadoresEsperada() throws RankingException{
		String filePath = "src/test/resources/match/log/match-9-players.log";
		try {
			MatchLogFileReader matchLogFileReader = new MatchLogFileReader(filePath);
			Collection<Match> matchCollection = matchLogFileReader.read();
			Match match = matchCollection.iterator().next();

			Ranking<RankingPlayer> ranking = new MatchRanking(match);
			Collection<RankingPlayer> rankingPlayerCollection = ranking.rankear();
			int totalPlayers = 9;

			assertThat("A collection de players do ranking não deve ser vazia", rankingPlayerCollection, is(not(empty())));
			assertThat("A collection de players do ranking deve ter 9(nove) jogadores", rankingPlayerCollection, hasSize(totalPlayers));

		} catch (FileNotFoundException e){
			fail(
				String.format("Arquivo %s não encontrado", filePath)
			);
		}
	}

	@Test
	public void deveRetornarVencedorDoMatchEsperado() throws RankingException{
		String filePath = "src/test/resources/match/log/match-player-roman-vencedor.log";
		try {
			MatchLogFileReader matchLogFileReader = new MatchLogFileReader(filePath);
			Collection<Match> matchCollection = matchLogFileReader.read();
			Match match = matchCollection.iterator().next();
			Player winner = new Player();
			winner.setName("Roman");

			Ranking<RankingPlayer> ranking = new MatchRanking(match);
			Collection<RankingPlayer> rankingPlayerCollection = ranking.rankear();
			int totalPlayers = 9;

			assertThat("A collection de players do ranking não deve ser vazia", rankingPlayerCollection, is(not(empty())));
			assertThat("A collection de players do ranking deve ter 9(nove) jogadores", rankingPlayerCollection, hasSize(totalPlayers));
			assertThat("O nome do vencedor deve ser o Roman", rankingPlayerCollection.iterator().next().getPlayer(), equalTo(winner));

		} catch (FileNotFoundException e){
			fail(
				String.format("Arquivo %s não encontrado", filePath)
			);
		}
	}

	@Test
	public void deveRetornarVencedorDoMatchEsperadoESuaArmaPreferida() throws RankingException{
		String filePath = "src/test/resources/match/log/match-player-juliano-vencedor.log";
		try {
			MatchLogFileReader matchLogFileReader = new MatchLogFileReader(filePath);
			Collection<Match> matchCollection = matchLogFileReader.read();
			Match match = matchCollection.iterator().next();
			Player expectedWinner = new Player();
			expectedWinner.setName("Juliano");
			Weapon expectedWeapon = new Weapon();
			expectedWeapon.setName("M16");

			Ranking<RankingPlayer> ranking = new MatchRanking(match);
			Collection<RankingPlayer> rankingPlayerCollection = ranking.rankear();
			int totalPlayers = 9;

			assertThat("A collection de players do ranking não deve ser vazia", rankingPlayerCollection, is(not(empty())));
			assertThat("A collection de players do ranking deve ter 9(nove) jogadores", rankingPlayerCollection, hasSize(totalPlayers));
			assertThat("O nome do vencedor deve ser o Juliano", ranking.winner().getPlayer(), equalTo(expectedWinner));
			assertThat("A arma preferida do vencedor deve ser M16", ranking.winner().prefferedWeapon(), equalTo(expectedWeapon));

		} catch (FileNotFoundException e){
			fail(
				String.format("Arquivo %s não encontrado", filePath)
			);
		}
	}
}
