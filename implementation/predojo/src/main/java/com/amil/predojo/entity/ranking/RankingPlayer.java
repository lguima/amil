/**
 * 
 */
package com.amil.predojo.entity.ranking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.amil.predojo.entity.Murder;
import com.amil.predojo.entity.Player;
import com.amil.predojo.entity.Weapon;
import com.amil.predojo.entity.award.Award;
import com.amil.predojo.entity.ranking.comparator.MostMurderSequenceWithoutDieComparator;
import com.amil.predojo.entity.ranking.impl.WeaponRanking;

/**
 * @author Juliano Sena
 *
 */
public class RankingPlayer {

	private Player player;
	private Collection<Award> awardsCollection;
	private Collection<Murder> murderCollection;
	private Collection<MurderSequenceWithoutDie> murderSequenceWithourDieCollection;
	private MurderSequenceWithoutDie currentMurderSequenceWithoutDie;

	private Long totalMurders = 0l;
	private Long totalDeaths = 0l;

	public RankingPlayer(Player player){
		this.player = player;
		this.murderCollection = new ArrayList<>();
		this.awardsCollection = new ArrayList<>();
		this.murderSequenceWithourDieCollection = new ArrayList<>();
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @return the totalMurders
	 */
	public Long getTotalMurders() {
		return totalMurders;
	}

	/**
	 * @return the totalDeaths
	 */
	public Long getTotalDeaths() {
		return totalDeaths;
	}

	public void addMurder(Murder murder){
		this.incrementMurderSequenceWithourDie();
		this.murderCollection.add(murder);
		this.totalMurders++;
	}

	public void addDeath(){
		this.renewMurderSequenceWithouDie();
		this.totalDeaths++;
	}

	private void renewMurderSequenceWithouDie() {
		this.murderSequenceWithourDieCollection.add(this.currentMurderSequenceWithoutDie);
		this.currentMurderSequenceWithoutDie = null;
	}

	private void incrementMurderSequenceWithourDie(){
		if(this.currentMurderSequenceWithoutDie == null){
			this.currentMurderSequenceWithoutDie = new MurderSequenceWithoutDie();
		}
		this.currentMurderSequenceWithoutDie.increment();
	}

	public Collection<Murder> getMurderCollection(){
		return this.murderCollection;
	}

	/**
	 * @return the awardsCollection
	 */
	public Collection<Award> getAwardsCollection() {
		return awardsCollection;
	}

	public Set<Weapon> weaponsUsed(){
		Set<Weapon> weaponSet = new HashSet<>();
		for(Murder murder : this.getMurderCollection()){
			weaponSet.add(murder.getWeapon());
		}

		return weaponSet;
	}

	public Weapon prefferedWeapon(){
		WeaponRanking weaponRanking = new WeaponRanking(this);
		return weaponRanking.winner().getweapon();
	}

	public MurderSequenceWithoutDie mostMurderSequenceWithoutDie(){
		MurderSequenceWithoutDie mostMurderSequenceWithoutDie = new MurderSequenceWithoutDie();
		if(this.totalMurders > 0){
			if(this.totalDeaths > 0){
				mostMurderSequenceWithoutDie = Collections.max(murderSequenceWithourDieCollection, new MostMurderSequenceWithoutDieComparator());
			} else {
				mostMurderSequenceWithoutDie = this.currentMurderSequenceWithoutDie;
			}
		}
		return mostMurderSequenceWithoutDie;
	}

	/**
	 * @param award
	 */
	public void addAward(Award award) {
		this.awardsCollection.add(award);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((player == null) ? 0 : player.hashCode());
		result = prime * result + ((totalDeaths == null) ? 0 : totalDeaths.hashCode());
		result = prime * result + ((totalMurders == null) ? 0 : totalMurders.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RankingPlayer other = (RankingPlayer) obj;
		if (player == null) {
			if (other.player != null)
				return false;
		} else if (!player.equals(other.player))
			return false;
		if (totalDeaths == null) {
			if (other.totalDeaths != null)
				return false;
		} else if (!totalDeaths.equals(other.totalDeaths))
			return false;
		if (totalMurders == null) {
			if (other.totalMurders != null)
				return false;
		} else if (!totalMurders.equals(other.totalMurders))
			return false;
		return true;
	}

	public String toString(){
		return String.format("%s : matou -> %d , morreu -> %d", this.getPlayer().getName(), this.getTotalMurders(), this.getTotalDeaths());
	}
}