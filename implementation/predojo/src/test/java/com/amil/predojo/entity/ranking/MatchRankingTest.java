/**
 * 
 */
package com.amil.predojo.entity.ranking;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.Player;
import com.amil.predojo.entity.Weapon;
import com.amil.predojo.entity.award.impl.KilledFivePlayerInOneMinuteAward;
import com.amil.predojo.entity.award.impl.WinnerWithoutDieAward;
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

	@Test
	public void deveRetornarJogadorMaiorSequenciaAssassinatosSemMorrerEsperada() throws RankingException{
		String filePath = "src/test/resources/match/log/match-player-juliano-vencedor.log";
		try {
			MatchLogFileReader matchLogFileReader = new MatchLogFileReader(filePath);
			Collection<Match> matchCollection = matchLogFileReader.read();
			Match match = matchCollection.iterator().next();
			Player expectedWinner = new Player();
			expectedWinner.setName("Juliano");

			MatchRanking ranking = new MatchRanking(match);
			Collection<RankingPlayer> rankingPlayerCollection = ranking.rankear();
			PlayerMurderSequenceWithoutDie playerMurderSequenceWithoutDie = ranking.mostMurderSequenceWithoutDie();
			int totalPlayers = 9;

			assertThat("A collection de players do ranking não deve ser vazia", rankingPlayerCollection, is(not(empty())));
			assertThat("A collection de players do ranking deve ter 9(nove) jogadores", rankingPlayerCollection, hasSize(totalPlayers));
			assertThat("O nome do vencedor deve ser o Juliano", ranking.winner().getPlayer(), equalTo(expectedWinner));
			assertThat("O jogador que fez a maior sequência de assassinatos deve ser Jack", playerMurderSequenceWithoutDie.player().getName(), equalTo("Jack"));
			assertThat("A maior sequência de assassinatos deve ser 7", playerMurderSequenceWithoutDie.sequence(), equalTo(7l));

		} catch (FileNotFoundException e){
			fail(
				String.format("Arquivo %s não encontrado", filePath)
			);
		}
	}

	@Test
	public void deveRetornarGanhadorEsperadoComSeuPremioDeNaoTerMorrido() throws RankingException{
		String filePath = "src/test/resources/match/log/match-player-juliano-vencedor-sem-morrer.log";
		try {
			MatchLogFileReader matchLogFileReader = new MatchLogFileReader(filePath);
			Collection<Match> matchCollection = matchLogFileReader.read();
			Match match = matchCollection.iterator().next();

			Player expectedWinner = new Player();
			expectedWinner.setName("Juliano");

			MatchRanking ranking = new MatchRanking(match);
			Collection<RankingPlayer> rankingPlayerCollection = ranking.rankear();
			int totalPlayers = 9;

			assertThat("A collection de players do ranking não deve ser vazia", rankingPlayerCollection, is(not(empty())));
			assertThat("A collection de players do ranking deve ter 9(nove) jogadores", rankingPlayerCollection, hasSize(totalPlayers));
			assertThat("O nome do vencedor deve ser o Juliano", ranking.winner().getPlayer(), equalTo(expectedWinner));
			assertThat("A collection prêmios do vencedor não deve ser nula", ranking.winner().getAwardsCollection(), is(notNullValue()));
			assertThat("A collection prêmios do vencedor não deve estar vazia", ranking.winner().getAwardsCollection(), is(not(empty())));
			assertThat("A collection prêmios do vencedor não deve ter 1 prêmio", ranking.winner().getAwardsCollection(), hasSize(1));
			assertThat("A instância do prêmio contido na collection de prêmios do vencedor deve ser do tipo WinnerWithoutDieAward", ranking.winner().getAwardsCollection().iterator().next(), instanceOf(WinnerWithoutDieAward.class));

		} catch (FileNotFoundException e){
			fail(
				String.format("Arquivo %s não encontrado", filePath)
			);
		}
	}

	@Test
	public void deveRetornarRankingJogadoresComJogadorComPremioMatouCincoEmUmMinutoEsperado() throws RankingException{
		String filePath = "src/test/resources/match/log/match-player-jack-matou-5-em-1-minuto.log";
		try {
			MatchLogFileReader matchLogFileReader = new MatchLogFileReader(filePath);
			Collection<Match> matchCollection = matchLogFileReader.read();
			Match match = matchCollection.iterator().next();

			Player expectedPlayer = new Player();
			expectedPlayer.setName("Jack");

			MatchRanking ranking = new MatchRanking(match);
			Collection<RankingPlayer> rankingPlayerCollection = ranking.rankear();
			int totalPlayers = 9;

			Collection<Player> players = match.players();

			assertThat("A collection de players do ranking não deve ser vazia", rankingPlayerCollection, is(not(empty())));
			assertThat("A collection de players do ranking deve ter 9(nove) jogadores", rankingPlayerCollection, hasSize(totalPlayers));
			assertThat("A collection de players deve ter o jogador Jack", players, hasItem(expectedPlayer));

			for(RankingPlayer rankingPlayer : rankingPlayerCollection){
				if(rankingPlayer.getPlayer().equals(expectedPlayer)){
					assertThat("A collection prêmios de Jack deve ter 1 prêmio", rankingPlayer.getAwardsCollection(), hasSize(1));
					assertThat("O prêmio do player Jack é de instância do tipo KilledFivePlayerInOneMinuteAward", rankingPlayer.getAwardsCollection().iterator().next(), instanceOf(KilledFivePlayerInOneMinuteAward.class));
				}
			}

		} catch (FileNotFoundException e){
			fail(
				String.format("Arquivo %s não encontrado", filePath)
			);
		}
	}
}