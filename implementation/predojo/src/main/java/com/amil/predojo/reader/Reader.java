package com.amil.predojo.reader;

/**
 * @author softvaro
 *
 */
public interface Reader<T> {

	T read() throws Exception;

}
