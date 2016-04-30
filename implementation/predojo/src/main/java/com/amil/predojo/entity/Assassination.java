package com.amil.predojo.entity;

import java.util.Date;

public class Assassination {

	private Date datetime;
	private Player murder;
	private Player Victim;
	private Weapon weapon;

	/**
	 * @return the datetime
	 */
	public Date getDatetime() {
		return datetime;
	}

	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	/**
	 * @return the murder
	 */
	public Player getMurder() {
		return murder;
	}

	/**
	 * @param murder the murder to set
	 */
	public void setMurder(Player murder) {
		this.murder = murder;
	}

	/**
	 * @return the victim
	 */
	public Player getVictim() {
		return Victim;
	}

	/**
	 * @param victim the victim to set
	 */
	public void setVictim(Player victim) {
		Victim = victim;
	}

	/**
	 * @return the weapon
	 */
	public Weapon getWeapon() {
		return weapon;
	}

	/**
	 * @param weapon the weapon to set
	 */
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
}
