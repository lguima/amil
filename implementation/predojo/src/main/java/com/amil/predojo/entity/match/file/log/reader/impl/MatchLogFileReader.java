package com.amil.predojo.entity.match.file.log.reader.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Collections;

import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.match.parser.impl.MatchParser;
import com.amil.predojo.file.log.reader.AbstractLogFileReader;

/**
 * @author Juliano Sena
 *
 */
public class MatchLogFileReader extends AbstractLogFileReader<Collection<Match>> {

	public MatchLogFileReader(String pathFile) throws FileNotFoundException {
		super(pathFile);
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.parser.Parser#parse()
	 */
	public Collection<Match> read(){
		Collection<Match> collection = Collections.emptyList();
		try {
			FileReader fr = new FileReader(this.file);
			BufferedReader bfr = new BufferedReader(fr);

			String line = null;
			int count = 0;
			Match match = null;
			while((line = bfr.readLine()) != null){
				if(count == 0){
					match = new MatchParser().parse(line);
				}
				System.out.println(match);
			}

			bfr.close();
		} catch (Exception e) {
			//TODO: Fazer log, dizendo que houve problema na comunicação com o arquivo de log
			return collection;
		}

		return collection;
	}
}
