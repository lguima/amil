package com.amil.predojo.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;

import com.amil.predojo.entity.match.parser.exception.FinishMatchException;

/**
 * @author Juliano Sena
 *
 */
public class Match {

	private enum STATUS {
		INICIAL, EM_ANDAMENTO, ENCERRADO;
	}

	private Long id;
	private Date createDatetime;
	private Date finishDatetime;
	private Collection<Murder> murders;
	private STATUS status = STATUS.INICIAL;

	public Match(Date datetime){
		this.createDatetime = datetime;
		this.status = STATUS.EM_ANDAMENTO;
	}

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
	 * @return the finishDatetime
	 */
	public Date getFinishDatetime() {
		return finishDatetime;
	}

	/**
	 * Add murder for this Match.
	 * @param assassinatio current aasassination
	 */
	public void addMurder(Murder murder){
		if(this.murders == null){
			this.murders = new ArrayList<Murder>();
		}

		this.murders.add(murder);
	}

	public void finish(Date datetime) throws FinishMatchException {
		if(datetime.before(createDatetime)){
			throw new FinishMatchException("Não é possível encerrar um Match com data de encerramento menor que data de criação!");
		}

		this.changeStatus(STATUS.ENCERRADO);

		this.finishDatetime = datetime;
	}

	public void changeStatus(STATUS status) throws FinishMatchException{
		if(this.status.equals(STATUS.ENCERRADO)){
			throw new FinishMatchException("Não é possível encerrar um match já encerrado!");
		}
		this.status = status;
	}

	/**
	 * Returns for read all murders.
	 * @return Collection<Murders> murders
	 */
	public Collection<Murder> getMurders(){
		return Collections.unmodifiableCollection(this.murders);
	}

	/**
	 * Return players of this match
	 * @return
	 */
	public Collection<Player> players(){
		Collection<Player> playersCollection = new HashSet<>();
		for(Murder murder : this.murders){
			playersCollection.add(murder.getkiller());
		}
		for(Murder murder : this.murders){
			playersCollection.add(murder.getVictim());
		}

		return playersCollection;
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