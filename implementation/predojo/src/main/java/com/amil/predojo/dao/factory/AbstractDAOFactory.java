package com.amil.predojo.dao.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.amil.predojo.factory.Factory;
import com.amil.predojo.file.dao.factory.impl.LogFileDAOFactory;

/**
 * @author Juliano Sena
 *
 */
public class AbstractDAOFactory implements Factory<DAOFactory> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amil.predojo.dao.factory.Factory#create()
	 */
	public DAOFactory create() throws IOException {
		DAOFactory factory = null;

		try {
			Properties propriedades = new Properties();
			InputStream is = getClass().getResourceAsStream("/application/config.properties");
			propriedades.load(is);
			is.close();

			String nome = propriedades.getProperty("dao.factory");
			Class<?> classFactory = Class.forName(nome);
			factory = (DAOFactory) classFactory.newInstance();

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			factory = new LogFileDAOFactory();
		}

		return factory;
	}
}
