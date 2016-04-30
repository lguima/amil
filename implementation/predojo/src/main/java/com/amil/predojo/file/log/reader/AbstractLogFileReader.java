package com.amil.predojo.file.log.reader;

import java.io.File;
import java.io.FileNotFoundException;

import com.amil.predojo.file.reader.AbstractFileReader;

/**
 * @author Juliano Sena
 *
 */
public abstract class AbstractLogFileReader<T> extends AbstractFileReader<T> {

	public AbstractLogFileReader(String pathFile) throws FileNotFoundException {
		super(pathFile);
	}

	public AbstractLogFileReader(File file) throws FileNotFoundException {
		super(file);
	}
}
