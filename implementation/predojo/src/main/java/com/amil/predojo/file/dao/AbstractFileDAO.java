package com.amil.predojo.file.dao;

import com.amil.predojo.dao.DAO;
import com.amil.predojo.file.reader.FileReader;

/**
 * @author Juliano Sena
 *
 */
public abstract class AbstractFileDAO<T extends FileReader<?>> implements DAO {

	protected T fileReader;

	public AbstractFileDAO(T fileReader){
		this.fileReader = fileReader;
	}
}
