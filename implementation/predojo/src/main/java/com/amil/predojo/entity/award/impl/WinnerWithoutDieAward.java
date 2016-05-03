/**
 * 
 */
package com.amil.predojo.entity.award.impl;

import com.amil.predojo.entity.award.Award;

/**
 * @author Juliano Sena
 *
 */
public class WinnerWithoutDieAward implements Award {

	@Override
	public String toString(){
		return "Venceu a partida sem morrer!";
	}
}
