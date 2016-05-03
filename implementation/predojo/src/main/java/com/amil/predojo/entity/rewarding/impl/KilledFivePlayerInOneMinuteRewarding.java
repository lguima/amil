/**
 * 
 */
package com.amil.predojo.entity.rewarding.impl;

import java.util.Iterator;
import java.util.List;

import com.amil.predojo.entity.Murder;
import com.amil.predojo.entity.award.impl.KilledFivePlayerInOneMinuteAward;
import com.amil.predojo.entity.murder.comparator.MurderComparatorByDatetime;
import com.amil.predojo.entity.ranking.RankingPlayer;
import com.amil.predojo.entity.ranking.impl.MatchRanking;
import com.amil.predojo.entity.rewarding.Rewarding;

/**
 * @author Juliano Sena
 *
 */
public class KilledFivePlayerInOneMinuteRewarding implements Rewarding<MatchRanking> {

	/* (non-Javadoc)
	 * @see com.amil.predojo.entity.award.Rewarding#reward(java.lang.Object)
	 */
	@Override
	public void reward(MatchRanking matchRanking) {
		outerloop:
			for(RankingPlayer rankingPlayer : matchRanking.rankear()){
				List<Murder> murderList = (List<Murder>) rankingPlayer.getMurderCollection();
				murderList.sort(new MurderComparatorByDatetime());
	
				Iterator<Murder> it = murderList.iterator();
				while(it.hasNext()){
					Murder firstMurder = it.next();
					int firstMurderIndex = murderList.indexOf(firstMurder);
		
					Murder lastMurder = null;
		
					try {
						lastMurder = murderList.get(firstMurderIndex+4);
						long firstMurderMiliseconds = firstMurder.getDatetime().getTime();
						long lastMurderMiliseconds = lastMurder.getDatetime().getTime();
		
						if((lastMurderMiliseconds - firstMurderMiliseconds) < 60000){
							rankingPlayer.addAward(new KilledFivePlayerInOneMinuteAward());
						}
		
					} catch (IndexOutOfBoundsException e){
						continue outerloop;
					}				
				}
			}
	}

}
