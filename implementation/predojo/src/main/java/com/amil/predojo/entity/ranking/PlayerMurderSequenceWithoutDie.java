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
		return String.format("A melhor sequência de assassinatos feita sem morrer foi feita pelo jogador %s, matou %d sem morrer", player.getName(), murderSequenceWithoutDie.value());
	}
}
