/**
 * 
 */
package com.amil.predojo.entity.ranking.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.Murder;
import com.amil.predojo.entity.Player;
import com.amil.predojo.entity.match.comparator.ComparatorByMoreMurderDesc;
import com.amil.predojo.entity.ranking.MurderSequenceWithoutDie;
import com.amil.predojo.entity.ranking.PlayerMurderSequenceWithoutDie;
import com.amil.predojo.entity.ranking.RankingPlayer;
import com.amil.predojo.entity.ranking.comparator.MostPlayerMurderSequenceWithoutDieComparator;
import com.amil.predojo.entity.ranking.exception.RankingException;
import com.amil.predojo.entity.rewarding.impl.MainRewarding;

/**
 * @author Juliano Sena
 *
 */
public class MatchRanking extends AbstractRanking<RankingPlayer> {

	private Match match;
	private RankingPlayer winner;
	private List<RankingPlayer> ranking;
	private PlayerMurderSequenceWithoutDie playerMurderSequenceWithoutDie;
	private final MainRewarding mainRewarding = new MainRewarding();

	/**
	 * @param rakiable
	 * @throws RankingException exceção lançada se o objeto passado como parâmetro for nulo
	 */
	public MatchRanking(Match match) throws RankingException {
		if(match == null){
			throw new RankingException("Objeto match não pode ser nulo!");
		}
		this.match = match;
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.entity.ranking.impl.Ranking#rankear()
	 */
	public Collection<RankingPlayer> rankear() {
		if(this.ranking == null){
			Match match = this.match;
			Collection<Player> playerSet = match.players();
			this.ranking = new ArrayList<RankingPlayer>();
	
			for(Player player : playerSet){
				if(!player.getName().equals("<WORLD>")){
					RankingPlayer rankingPlayer = new RankingPlayer(player);
	
					for(Murder murder : match.getMurders()){
						//Adiciono um assassinato para o jogador
						if(murder.getkiller().equals(player)){
							rankingPlayer.addMurder(murder);
						}
	
						//Adiciono uma morte para o jogador
						if(murder.getVictim().equals(player)){
							rankingPlayer.addDeath();
						}
					}
	
					this.ranking.add(rankingPlayer);
				}
			}
	
			this.ranking.sort(new ComparatorByMoreMurderDesc());
	
			//Adiciono premios para os jogadores
			this.mainRewarding.reward(this);
		}

		return this.ranking;
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.entity.ranking.impl.Ranking#winner()
	 */
	public RankingPlayer winner() {
		RankingPlayer winner = this.winner;
		if(winner == null){
			Collection<RankingPlayer> rankingPlayerCollection = this.rankear();
			winner = rankingPlayerCollection.iterator().next();
		}
		return winner;
	}

	public PlayerMurderSequenceWithoutDie mostMurderSequenceWithoutDie(){
		Collection<PlayerMurderSequenceWithoutDie> playerMurderSequenceWithoutDieCollection = new ArrayList<>();
		if(this.playerMurderSequenceWithoutDie == null){
			Collection<RankingPlayer> rankingPlayerCollection = this.rankear();
			for(RankingPlayer rankingPlayer : rankingPlayerCollection){
				Player player = rankingPlayer.getPlayer();
				MurderSequenceWithoutDie murderSequenceWithoutDie = rankingPlayer.mostMurderSequenceWithoutDie();
				playerMurderSequenceWithoutDieCollection.add(new PlayerMurderSequenceWithoutDie(player, murderSequenceWithoutDie));
			}
		}
		this.playerMurderSequenceWithoutDie = Collections.max(playerMurderSequenceWithoutDieCollection, new MostPlayerMurderSequenceWithoutDieComparator());

		return this.playerMurderSequenceWithoutDie;
	}
}
