/**
 * 
 */
package com.amil.predojo.entity.ranking;

/**
 * @author Juliano Sena
 *
 */
public class MurderSequenceWithoutDie {

	private Long sequence = 0l;

	public Long value(){
		return this.sequence;
	}

	public void increment(){
		this.sequence++;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sequence == null) ? 0 : sequence.hashCode());
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
		MurderSequenceWithoutDie other = (MurderSequenceWithoutDie) obj;
		if (sequence == null) {
			if (other.sequence != null)
				return false;
		} else if (!sequence.equals(other.sequence))
			return false;
		return true;
	}
}
