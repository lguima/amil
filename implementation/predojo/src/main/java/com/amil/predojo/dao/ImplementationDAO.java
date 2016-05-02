/**
 * 
 */
package com.amil.predojo.dao;

/**
 * @author Juliano Sena
 *
 */
public enum ImplementationDAO {

	MATCH("dao.match");

	private String property;

	ImplementationDAO(String property){
		this.setProperty(property);
	}

	/**
	 * @return the property
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * @param property the property to set
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	
}
