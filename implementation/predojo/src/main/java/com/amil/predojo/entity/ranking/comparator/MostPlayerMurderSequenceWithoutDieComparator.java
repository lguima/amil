/**
 * 
 */
package com.amil.predojo.entity.ranking.comparator;

import java.util.Comparator;

import com.amil.predojo.entity.ranking.PlayerMurderSequenceWithoutDie;

/**
 * @author Juliano Sena
 *
 */
public class MostPlayerMurderSequenceWithoutDieComparator implements Comparator<PlayerMurderSequenceWithoutDie> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(PlayerMurderSequenceWithoutDie playerMurderSequenceWithoutDie1, PlayerMurderSequenceWithoutDie playerMurderSequenceWithoutDie2) {
		int comparisonResult = playerMurderSequenceWithoutDie1.sequence().compareTo(playerMurderSequenceWithoutDie2.sequence());
		if(comparisonResult == 0){
			comparisonResult = playerMurderSequenceWithoutDie1.player().getName().compareTo(playerMurderSequenceWithoutDie2.player().getName());
		}
		return comparisonResult;
	}

}
