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
}