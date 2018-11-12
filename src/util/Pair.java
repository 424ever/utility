package util;

/**
 * 
 * @author Jonas Brandstoetter
 * <br>
 * The <code>Pair</code> class represents a pair of 2 values. Those values can be accessed using the public fields 
 * _1 and _2.
 * 
 * @param <VT1> the Type of the first value
 * @param <VT2> the Type of the second value
 */
public class Pair<VT1, VT2> {

	/**
	 * The Field to access the first value.
	 */
	public VT1 _1;
	/**
	 * The Field to access the second value.
	 */
	public VT2 _2;

	/**
	 * 
	 * Construct a <code>Pair</code> with the initialized values _1 and _2
	 * 
	 * @param _1 the first value
	 * @param _2 the second value
	 */
	public Pair(VT1 _1, VT2 _2) {
		this._1 = _1;
		this._2 = _2;
	}
	
	/**
	 * 
	 * Construct a <code>Pair</code> without Parameters. Both values will be <code>null</code>
	 */
	public Pair() {
		this(null,null);
	}

	/**
	 * Returns a <code>String</code> representation for this <code>Pair</code>. The <code>String</code> representation is
	 * for informational use only and will change. Do not use this string representation for any programmatic purpose.
	 * 
	 * @return a <code>String</code> representation for this <code>Pair</code>
	 */
	@Override
	public String toString() {
		return "Pair [key=" + _1 + ", value=" + _2 + "]";
	}

	/**
	 * Return a hash code for this <code>Pair</code> object.
	 * 
	 * @return a hash code for this object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_1 == null) ? 0 : _1.hashCode());
		result = prime * result + ((_2 == null) ? 0 : _2.hashCode());
		return result;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.
	 * 
	 * @param obj the reference object with which to compare
	 * 
	 * @return <code>true</code> if this object is equal to the <code>obj</code> argument, <code>false</code> otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair<?, ?> other = (Pair<?, ?>) obj;
		if (_1 == null) {
			if (other._1 != null)
				return false;
		} else if (!_1.equals(other._1))
			return false;
		if (_2 == null) {
			if (other._2 != null)
				return false;
		} else if (!_2.equals(other._2))
			return false;
		return true;
	}

}
