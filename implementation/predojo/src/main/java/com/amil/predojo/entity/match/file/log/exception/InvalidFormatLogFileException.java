/**
 * 
 */
package com.amil.predojo.entity.match.file.log.exception;

/**
 * @author softvaro
 *
 */
public class InvalidFormatLogFileException extends Exception {

	private static final long serialVersionUID = 6286124254263110499L;

	public InvalidFormatLogFileException(String message){
		super(message);
	}

	public InvalidFormatLogFileException(Throwable throwable){
		super(throwable);
	}

	public InvalidFormatLogFileException(String message, Throwable throwable){
		super(message, throwable);
	}
}
