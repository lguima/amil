/**
 * 
 */
package com.amil.predojo.entity.ranking.impl;

import java.util.Collection;

/**
 * @author Juliano Sena
 *
 */
public interface Ranking<T, E> {

	public Collection<T> rankear();

	public E winner();

}
