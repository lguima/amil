package com.amil.predojo.file.reader;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author Juliano Sena
 *
 */
public abstract class AbstractFileReader<T> implements FileReader<T> {

	protected File file;

	public AbstractFileReader(File file) throws FileNotFoundException {
		if(this.file != null && !this.file.exists()){
			throw new FileNotFoundException(
					String.format("Arquivo %s inexistente!", file.getName())
			);
		}
	}

	public AbstractFileReader(String filePath) throws FileNotFoundException {
		this.file = new File(filePath);
		if(this.file != null && !this.file.exists()){
			throw new FileNotFoundException(
					String.format("Arquivo %s inexistente!", filePath)
			);
		}
	}
}
