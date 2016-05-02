/**
 * 
 */
package com.amil.predojo.entity.match.comparator;

import java.util.Comparator;

import com.amil.predojo.entity.ranking.RankingPlayer;

/**
 * @author Juliano Sena
 *
 */
public class ComparatorByMoreMurderDesc implements Comparator<RankingPlayer> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(RankingPlayer rankingPlayer1, RankingPlayer rankingPlayer2) {
		int comparisonResult = rankingPlayer1.getTotalMurders().compareTo(rankingPlayer2.getTotalMurders());
		if(comparisonResult == 0){
			comparisonResult = rankingPlayer1.getTotalDeaths().compareTo(rankingPlayer2.getTotalDeaths());
			if(comparisonResult == 0){
				if(rankingPlayer1.getAwardsCollection().size() > rankingPlayer2.getAwardsCollection().size()){
					comparisonResult = 1;
				} else if (rankingPlayer1.getAwardsCollection().size() < rankingPlayer2.getAwardsCollection().size()) {
					comparisonResult = -1;
				} else {
					comparisonResult = rankingPlayer1.getPlayer().getName().compareTo(rankingPlayer2.getPlayer().getName());
				}
			}
		}

		//Descending order
		return comparisonResult * -1;
	}
}