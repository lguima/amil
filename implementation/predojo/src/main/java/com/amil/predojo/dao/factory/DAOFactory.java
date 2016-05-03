package com.amil.predojo.dao.factory;

import com.amil.predojo.dao.DAO;
import com.amil.predojo.dao.ImplementationDAO;
import com.amil.predojo.factory.exception.FactoryCreationException;

/**
 * @author Juliano Sena
 *
 */
public interface DAOFactory {

	public DAO create(ImplementationDAO implementationDAO) throws FactoryCreationException;

}
