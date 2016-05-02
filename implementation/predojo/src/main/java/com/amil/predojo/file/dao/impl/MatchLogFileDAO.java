package com.amil.predojo.file.dao.impl;

import java.io.FileNotFoundException;
import java.util.Collection;

import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.match.file.log.reader.impl.MatchLogFileReader;
import com.amil.predojo.file.dao.AbstractFileDAO;

/**
 * @author Juliano Sena
 *
 */
public class MatchLogFileDAO extends AbstractFileDAO<MatchLogFileReader> {

	private Collection<Match> matchCollection;

	/**
	 * @param fileReader
	 * @throws FileNotFoundException 
	 */
	public MatchLogFileDAO(String filePath) throws FileNotFoundException {
		super(new MatchLogFileReader(filePath));
		this.matchCollection = this.fileReader.read();
	}

	public Collection<Match> findAll(){
		return this.matchCollection;
	}
}