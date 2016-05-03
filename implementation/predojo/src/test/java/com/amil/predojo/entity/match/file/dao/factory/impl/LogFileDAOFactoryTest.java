/**
 * 
 */
package com.amil.predojo.entity.match.file.dao.factory.impl;

import static com.amil.predojo.dao.ImplementationDAO.MATCH;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.amil.predojo.dao.DAO;
import com.amil.predojo.dao.factory.AbstractDAOFactory;
import com.amil.predojo.dao.factory.DAOFactory;
import com.amil.predojo.factory.Factory;
import com.amil.predojo.file.dao.factory.FileDAOFactory;
import com.amil.predojo.file.dao.impl.MatchLogFileDAO;

/**
 * @author Juliano Sena
 *
 */
public class LogFileDAOFactoryTest {

	@Test
	public void deveRetornarUmInstanciaDeMatchLogFileDAO(){
		try {
			Factory<DAOFactory> factory = new AbstractDAOFactory();
			DAOFactory daoFactory = factory.create();

			//Assert for the factory creator
			assertThat("Instância de DAOFactory deve ser FileDAOFactory", daoFactory, instanceOf(FileDAOFactory.class));

			FileDAOFactory logFileDAOFactory = (FileDAOFactory) daoFactory;
			String filePath = "src/test/resources/match/log/tres-matchs.log";
			DAO dao = logFileDAOFactory.create(MATCH, filePath);

			assertThat("Instância do dao deve ser MatchLogFileDAO", dao, instanceOf(MatchLogFileDAO.class));

		} catch (Exception e){
			fail("Falha na criação da instância da factory LogFileDAOFactory");
		}
	}

}
