/**
 * 
 */
package com.amil.predojo.entity.ranking.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.amil.predojo.entity.Murder;
import com.amil.predojo.entity.Weapon;
import com.amil.predojo.entity.ranking.RankingPlayer;
import com.amil.predojo.entity.ranking.RankingWeapon;
import com.amil.predojo.entity.weapon.comparator.ComparatorWeaponByMoreAmountUseDesc;

/**
 * @author Juliano Sena
 *
 */
public class WeaponRanking extends AbstractRanking<RankingWeapon> {

	private final RankingPlayer rankingPlayer;
	private RankingWeapon winner;

	public WeaponRanking(RankingPlayer rankingPlayer) {
		this.rankingPlayer = rankingPlayer;
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.entity.ranking.impl.Ranking#rankear()
	 */
	public Collection<RankingWeapon> rankear() {
		List<RankingWeapon> rankingWeaponCollection = new ArrayList<>();

		for(Weapon weapon : this.rankingPlayer.weaponsUsed()){
			RankingWeapon rankingWeapon = new RankingWeapon(weapon);

			for(Murder murder : this.rankingPlayer.getMurderCollection()){
				if(murder.getWeapon().equals(weapon)){
					rankingWeapon.addAmoutOfUse();
				}
			}

			rankingWeaponCollection.add(rankingWeapon);
		}

		rankingWeaponCollection.sort(new ComparatorWeaponByMoreAmountUseDesc());

		return rankingWeaponCollection;
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.entity.ranking.impl.Ranking#winner()
	 */
	public RankingWeapon winner() {
		RankingWeapon winner = this.winner;
		if(winner == null){
			Collection<RankingWeapon> rankinWeaponCollection = this.rankear();
			winner = rankinWeaponCollection.iterator().next();
		}
		return winner;
	}

}
