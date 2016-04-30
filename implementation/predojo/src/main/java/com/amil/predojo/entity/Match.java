package com.amil.predojo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

/**
 * @author Juliano Sena
 *
 */
public class Match {

	private Long id;
	private Date createDatetime;
	private Date finishDatetime;
	private Collection<Assassination> assassinations;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the startDatetime
	 */
	public Date getCreateDatetime() {
		return createDatetime;
	}

	/**
	 * @param startDatetime the startDatetime to set
	 */
	public void setStartDatetime(Date startDatetime) {
		this.createDatetime = startDatetime;
	}

	/**
	 * @return the finishDatetime
	 */
	public Date getFinishDatetime() {
		return finishDatetime;
	}

	/**
	 * @param finishDatetime the finishDatetime to set
	 */
	public void setFinishDatetime(Date finishDatetime) {
		this.finishDatetime = finishDatetime;
	}

	/**
	 * Add assassination for this Match.
	 * @param assassinatio current aasassination
	 */
	public void addAssassination(Assassination assassinatio){
		if(this.assassinations == null){
			this.assassinations = new ArrayList<Assassination>();
		}

		this.assassinations.add(assassinatio);
	}

	/**
	 * Returns for read all assassinations.
	 * @return Collection<Assassinations> assassinations
	 */
	public Collection<Assassination> getAssassinations(){
		return Collections.unmodifiableCollection(this.assassinations);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}