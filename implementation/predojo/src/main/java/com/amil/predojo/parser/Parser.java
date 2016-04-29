/**
 * 
 */
package com.amil.predojo.parser;

import java.text.ParseException;

/**
 * @author Juliano Sena
 *
 */
public interface Parser<T,E> {

	public T parse(E value) throws ParseException;

}
