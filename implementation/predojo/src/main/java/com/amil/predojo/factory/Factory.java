package com.amil.predojo.factory;

/**
 * @author Juliano Sena
 *
 */
public interface Factory<T> {

	public T create() throws Exception;

}
