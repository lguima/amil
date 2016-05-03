/**
 * 
 */
package com.amil.predojo.file.dao.factory;

import com.amil.predojo.dao.DAO;
import com.amil.predojo.dao.ImplementationDAO;
import com.amil.predojo.dao.factory.DAOFactory;
import com.amil.predojo.factory.exception.FactoryCreationException;

/**
 * @author Juliano Sena
 *
 */
public interface FileDAOFactory extends DAOFactory {

	public DAO create(ImplementationDAO implementationDAO, String filePath) throws FactoryCreationException; 

}
