/**
 * 
 */
package com.amil.predojo.entity.weapon.comparator;

import java.util.Comparator;

import com.amil.predojo.entity.ranking.RankingWeapon;

/**
 * @author Juliano Sena
 *
 */
public class ComparatorWeaponByMoreAmountUseDesc implements Comparator<RankingWeapon> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(RankingWeapon rankingWeapon1, RankingWeapon rankingWeapon2) {
		int comparisonResult = rankingWeapon1.getTotalAmountOfUse().compareTo(rankingWeapon2.getTotalAmountOfUse());
		if(comparisonResult == 0){
			comparisonResult = rankingWeapon1.getweapon().getName().compareTo(rankingWeapon2.getweapon().getName());
		}

		//Descending order
		return comparisonResult * -1;
	}
}