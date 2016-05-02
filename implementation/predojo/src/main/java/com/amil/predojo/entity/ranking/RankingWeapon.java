/**
 * 
 */
package com.amil.predojo.entity.ranking;

import com.amil.predojo.entity.Weapon;

/**
 * @author Juliano Sena
 *
 */
public class RankingWeapon {

	private final Weapon weapon;
	private Long totalAmountOfUse = 0l;

	public RankingWeapon(Weapon weapon){
		this.weapon = weapon;
	}

	public Weapon getweapon(){
		return this.weapon;
	}

	public void addAmoutOfUse(){
		this.totalAmountOfUse++;
	}

	public Long getTotalAmountOfUse(){
		return totalAmountOfUse;
	}
}