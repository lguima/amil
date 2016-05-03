/**
 * 
 */
package com.amil.predojo.entity.ranking.comparator;

import java.util.Comparator;

import com.amil.predojo.entity.ranking.MurderSequenceWithoutDie;

/**
 * @author Juliano Sena
 *
 */
public class MostMurderSequenceWithoutDieComparator implements Comparator<MurderSequenceWithoutDie> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(MurderSequenceWithoutDie sequence1, MurderSequenceWithoutDie sequence2) {
		int comparisonResult = sequence1.value().compareTo(sequence2.value());
		return comparisonResult;
	}

}
