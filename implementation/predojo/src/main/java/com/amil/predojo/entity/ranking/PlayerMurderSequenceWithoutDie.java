/**
 * 
 */
package com.amil.predojo.entity.ranking;

import com.amil.predojo.entity.Player;

/**
 * @author Juliano Sena
 *
 */
public class PlayerMurderSequenceWithoutDie {

	private Player player;
	private MurderSequenceWithoutDie murderSequenceWithoutDie;

	public PlayerMurderSequenceWithoutDie(Player player, MurderSequenceWithoutDie murderSequenceWithoutDie){
		this.player = player;
		this.murderSequenceWithoutDie = murderSequenceWithoutDie;
	}

	public Player player(){
		return player;
	}

	public Long sequence(){
		return murderSequenceWithoutDie.value();
	}
	
	public String toString(){
		return String.format("Jogador %s, matou %d sem morrer", player.getName(), murderSequenceWithoutDie.value());
	}
}
