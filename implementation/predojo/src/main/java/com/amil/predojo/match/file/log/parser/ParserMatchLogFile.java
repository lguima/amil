package com.amil.predojo.match.file.log.parser;

import java.util.Collection;

import com.amil.predojo.entity.Match;
import com.amil.predojo.file.log.parser.ParserLogFile;

public class ParserMatchLogFile extends ParserLogFile<Collection<Match>> {

	public ParserMatchLogFile() {
		super(ParserLogFile.PATH_FILE + "matches");
	}

	public Collection<Match> parse() {
		
		return null;
	}

	

}
