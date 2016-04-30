package com.amil.predojo.entity.match.file.log.reader.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import com.amil.predojo.entity.Match;
import com.amil.predojo.entity.match.file.log.parser.impl.CreateMatchParser;
import com.amil.predojo.entity.match.file.log.parser.impl.FinishMatchParser;
import com.amil.predojo.file.log.reader.AbstractLogFileReader;

/**
 * @author Juliano Sena
 *
 */
public class MatchLogFileReader extends AbstractLogFileReader<Collection<Match>> {

	public MatchLogFileReader(File file) throws FileNotFoundException {
		super(file);
	}

	public MatchLogFileReader(String pathFile) throws FileNotFoundException {
		super(pathFile);
	}

	/* (non-Javadoc)
	 * @see com.amil.predojo.parser.Parser#parse()
	 */
	public Collection<Match> read(){
		Collection<Match> collection = new HashSet<Match>();
		try {
			FileReader fr = new FileReader(this.file);
			BufferedReader bfr = new BufferedReader(fr);

			String line = null;
			int count = 0;
			Match match = null;
			while((line = bfr.readLine()) != null){
				if(count == 0){
					match = new CreateMatchParser().parse(line);

					if(match == null) {
						count = 0;
					} else {
						count++;
					}

					continue;
				}


				FinishMatchParser finishMatch = new FinishMatchParser(match);
				Match finishedMatch = finishMatch.parse(line);
				if(finishedMatch != null){
					collection.add(match);
					count = 0;
				}
			}
			//Se o match não foi encerrado, adicione ele a coleção, pois é o último match do log
			//e está em andamento
			if(match != null && match.getFinishDatetime() == null){
				collection.add(match);
			}

			bfr.close();
		} catch (Exception e) {
			//TODO: Fazer log, dizendo que houve problema na comunicação com o arquivo de log
			return Collections.emptyList();
		}

		return collection;
	}
}