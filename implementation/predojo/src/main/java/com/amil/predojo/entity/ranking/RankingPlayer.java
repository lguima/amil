/**
 * 
 */
package com.amil.predojo.entity.ranking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import com.amil.predojo.entity.Murder;
import com.amil.predojo.entity.Player;
import com.amil.predojo.entity.Weapon;

/**
 * @author Juliano Sena
 *
 */
public class RankingPlayer {

	private Player player;
	private Map<Weapon,Long> murderWeapon;
	private Long totalMurders = 0l;
	private Long totalDeaths = 0l;
	private Collection<Award> awardsCollection;

	public RankingPlayer(Player player){
		this.player = player;
		this.awardsCollection = new ArrayList<>();
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

	public void addMurder(){
		this.totalMurders++;
	}

	public void addDeath(){
		this.totalDeaths++;
	}

	/**
	 * @return the awardsCollection
	 */
	public Collection<Award> getAwardsCollection() {
		return awardsCollection;
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