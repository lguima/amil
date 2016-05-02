/**
 * 
 */
package com.amil.predojo.entity.player.decorator;

import com.amil.predojo.entity.Player;
import com.amil.predojo.entity.Weapon;

/**
 * @author Juliano Sena
 *
 */
public class Winner {

	private Player player;
	private Weapon preferredWeapon;

	/**
	 * @param next
	 */
	public Winner(Player player) {
		this.player = player;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the preferredWeapon
	 */
	public Weapon getPreferredWeapon() {
		return preferredWeapon;
	}

	/**
	 * @param preferredWeapon the preferredWeapon to set
	 */
	public void setPreferredWeapon(Weapon preferredWeapon) {
		this.preferredWeapon = preferredWeapon;
	}
}
