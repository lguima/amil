/**
 * 
 */
package com.amil.predojo.entity.match.parser;

import java.io.File;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;

import com.amil.predojo.entity.match.file.log.exception.InvalidFormatLogFileException;

/**
 * @author Juliano Sena
 *
 */
public class ParserMatchLogFileTest {

	@Rule
	public InvalidFormatLogFileException invalidFormatMatchLogFileException;

	private File invalidLogFile = new File("invalid.log");

	@After
	public void setup(){
		
	}

	@Test
	public void deveRetonarErroDevidoFormatoArquivoLogSerInvalido(){
		Parser parser = new MatchLogFileParser(invalidLogFile);
	}

}
