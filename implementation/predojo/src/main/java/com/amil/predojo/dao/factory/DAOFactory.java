package com.amil.predojo.dao.factory;

import com.amil.predojo.dao.DAO;
import com.amil.predojo.dao.ImplementationDAO;

/**
 * @author Juliano Sena
 *
 */
public interface DAOFactory {

	public DAO create(ImplementationDAO implementationDAO);

}
