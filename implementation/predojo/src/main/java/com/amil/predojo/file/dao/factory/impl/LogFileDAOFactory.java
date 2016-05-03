package com.amil.predojo.file.dao.factory.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.amil.predojo.dao.DAO;
import com.amil.predojo.dao.ImplementationDAO;
import com.amil.predojo.factory.exception.FactoryCreationException;
import com.amil.predojo.file.dao.factory.FileDAOFactory;

/**
 * @author Juliano Sena
 *
 */
public class LogFileDAOFactory implements FileDAOFactory {

	private Properties daoConfigurationProperties;

	private Properties properties() throws IOException{
		Properties properties = this.daoConfigurationProperties;
		if(daoConfigurationProperties == null){
			properties = new Properties();
			InputStream is = getClass().getResourceAsStream("/dao/config.properties");
			properties.load(is);
			is.close();
		}
		return properties;
	}

	@Override
	public DAO create(ImplementationDAO implementationDAO) throws FactoryCreationException {
		DAO dao = null;

		try {
			Properties properties = this.properties();
			String filePath = properties.getProperty(implementationDAO.getProperty() + ".filePath");

			dao = this.create(implementationDAO, filePath);

		} catch (Exception e) {
			throw new FactoryCreationException("Problemas ao realizar a criação do DAO de " + implementationDAO.name(), e);
		}

		return dao;
	}

	@Override
	public DAO create(ImplementationDAO implementationDAO, String filePath) throws FactoryCreationException {
		DAO dao = null;

		try {
			Properties properties = this.properties();

			String className = properties.getProperty(implementationDAO.getProperty());
			Class<?> classFactory = Class.forName(className);
			dao = (DAO) classFactory.getConstructor(String.class).newInstance(filePath);

		} catch (Exception e) {
			throw new FactoryCreationException("Problemas ao realizar a criação do DAO de " + implementationDAO.name(), e);
		}

		return dao;
	}
}