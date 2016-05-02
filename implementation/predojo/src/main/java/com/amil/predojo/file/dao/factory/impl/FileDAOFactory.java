package com.amil.predojo.file.dao.factory.impl;

import java.io.InputStream;
import java.util.Properties;

import com.amil.predojo.dao.DAO;
import com.amil.predojo.dao.ImplementationDAO;
import com.amil.predojo.dao.factory.DAOFactory;

/**
 * @author Juliano Sena
 *
 */
public class FileDAOFactory implements DAOFactory {

	@Override
	public DAO create(ImplementationDAO implementationDAO) {
		DAO dao = null;

		try {
			Properties propriedades = new Properties();
			InputStream is = getClass().getResourceAsStream("/dao/config.properties");
			propriedades.load(is);
			is.close();

			String className = propriedades.getProperty(implementationDAO.getProperty());
			String filePath = propriedades.getProperty(implementationDAO.getProperty() + ".filePath");
			Class<?> classFactory = Class.forName(className);
			dao = (DAO) classFactory.getConstructor(String.class).newInstance(filePath);

		} catch (Exception e) {
			System.exit(0);
		}

		return dao;
	}

}
