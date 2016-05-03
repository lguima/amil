/**
 * 
 */
package com.amil.predojo.entity.rewarding.impl;

import java.util.ArrayList;

import com.amil.predojo.entity.ranking.impl.MatchRanking;
import com.amil.predojo.entity.rewarding.Rewarding;

/**
 * @author Juliano Sena
 *
 */
public class MainRewarding implements Rewarding<MatchRanking> {

	private ArrayList<Rewarding<MatchRanking>> rewardingCollection;

	public MainRewarding(){
		this.rewardingCollection = new ArrayList<>();
		this.rewardingCollection.add(new WinnerWithoutDieRewarding());
		this.rewardingCollection.add(new KilledFivePlayerInOneMinuteRewarding());
	}

	public void reward(MatchRanking matchRanking){
		for(Rewarding<MatchRanking> rewarding : rewardingCollection){
			rewarding.reward(matchRanking);
		}		
	}
}
