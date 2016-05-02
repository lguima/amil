package com.amil.predojo.entity;

import java.util.Date;

public class Murder {

	private Date datetime;
	private Player killer;
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
	 * @return the killer
	 */
	public Player getkiller() {
		return killer;
	}

	/**
	 * @param killer the killer to set
	 */
	public void setKiller(Player killer) {
		this.killer = killer;
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
