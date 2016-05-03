/**
 * 
 */
package com.amil.predojo.entity.rewarding.impl;

import com.amil.predojo.entity.award.impl.WinnerWithoutDieAward;
import com.amil.predojo.entity.ranking.RankingPlayer;
import com.amil.predojo.entity.ranking.impl.MatchRanking;
import com.amil.predojo.entity.rewarding.Rewarding;

/**
 * @author Juliano Sena
 *
 */
public class WinnerWithoutDieRewarding implements Rewarding<MatchRanking> {

	/* (non-Javadoc)
	 * @see com.amil.predojo.entity.award.Rewarding#reward(java.lang.Object)
	 */
	@Override
	public void reward(MatchRanking matchRanking) {
		RankingPlayer winner = matchRanking.winner();
		if(winner.getTotalDeaths() == 0){
			winner.addAward(new WinnerWithoutDieAward());
		}
	}

}
