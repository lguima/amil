/**
 * 
 */
package com.amil.predojo.factory.exception;

/**
 * @author Juliano Sena
 *
 */
public class FactoryCreationException extends Exception {

	private static final long serialVersionUID = 6901915459396648403L;

	public FactoryCreationException(String message, Throwable e){
		super(message, e);
	}
}
