/**
 * 
 */
package com.amil.predojo.entity.murder.comparator;

import java.util.Comparator;

import com.amil.predojo.entity.Murder;

/**
 * @author Juliano Sena
 *
 */
public class MurderComparatorByDatetime implements Comparator<Murder> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Murder murder1, Murder murder2) {
		int comparisonResult = murder1.getDatetime().compareTo(murder2.getDatetime());
		return comparisonResult;
	}

}
