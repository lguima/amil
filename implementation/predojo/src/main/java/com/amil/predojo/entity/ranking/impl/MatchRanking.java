/**
 * 
 */
package com.amil.predojo.entity.ranking.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.amil.predojo.entity.Murder;
import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.Player;
import com.amil.predojo.entity.match.comparator.ComparatorByMoreMurderDesc;
import com.amil.predojo.entity.player.decorator.Winner;
import com.amil.predojo.entity.ranking.RankingPlayer;
import com.amil.predojo.entity.ranking.exception.RankingException;

/**
 * @author Juliano Sena
 *
 */
public class MatchRanking extends AbstractRanking<RankingPlayer, Player> {

	private Match match;
	private Winner winner;

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
	@Override
	public Collection<RankingPlayer> rankear() {
		Match match = this.match;
		Collection<Player> playerSet = match.players();
		List<RankingPlayer> rankingPlayerCollection = new ArrayList<RankingPlayer>();

		for(Player player : playerSet){
			if(!player.getName().equals("<WORLD>")){
				RankingPlayer rankingPlayer = new RankingPlayer(player);

				for(Murder murder : match.getMurders()){
					//Adiciono um assassinato para o jogador
					if(murder.getkiller().equals(player)){
						rankingPlayer.addMurder();
					}

					//Adiciono uma morte para o jogador
					if(murder.getVictim().equals(player)){
						rankingPlayer.addDeath();
					}
				}

				rankingPlayerCollection.add(rankingPlayer);
			}
		}

		rankingPlayerCollection.sort(new ComparatorByMoreMurderDesc());
		return rankingPlayerCollection;
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.entity.ranking.impl.Ranking#winner()
	 */
	@Override
	public Player winner() {
		Winner winner = this.winner;
		if(winner == null){
			Collection<RankingPlayer> rankingPlayerCollection = this.rankear();
			winner = new Winner(rankingPlayerCollection.iterator().next().getPlayer());

			for(Murder murder : match.getMurders()){
				//Adiciono um assassinato para o jogador
				if(murder.getkiller().equals(winner)){
					
				}
			}

			winner.setPreferredWeapon(null);
		}
		return null;
	}

}
