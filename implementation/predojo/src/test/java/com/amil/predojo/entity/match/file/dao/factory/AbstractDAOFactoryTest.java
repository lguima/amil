/**
 * 
 */
package com.amil.predojo.entity.match.file.dao.factory;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.amil.predojo.dao.factory.AbstractDAOFactory;
import com.amil.predojo.dao.factory.DAOFactory;
import com.amil.predojo.factory.Factory;
import com.amil.predojo.file.dao.factory.impl.LogFileDAOFactory;

import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Juliano Sena
 *
 */
public class AbstractDAOFactoryTest {

	@Test
	public void deveRetornarInstanciaDeLogFileDAOFactory(){
		try {
			Factory<DAOFactory> factory = new AbstractDAOFactory();
			DAOFactory logFileDAOFactory = factory.create();

			assertThat("Instância de DAOFactory deve ser LogFileDAOFactory", logFileDAOFactory, instanceOf(LogFileDAOFactory.class));

		} catch (Exception e){
			fail("Falha na criação da instância da factory LogFileDAOFactory");
		}
	}
}