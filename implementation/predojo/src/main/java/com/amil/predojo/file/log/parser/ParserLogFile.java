/**
 * 
 */
package com.amil.predojo.file.log.parser;

import java.io.File;

import com.amil.predojo.file.parser.ParserFile;

/**
 * @author softvaro
 *
 */
public abstract class ParserLogFile<T> implements ParserFile<T> {

	public static final String PATH_FILE = "/file/log/";

	protected File file;

	public ParserLogFile(String filepath){
		this.file = new File(filepath);
	}
}
