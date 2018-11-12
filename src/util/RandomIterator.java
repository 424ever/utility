package util;

import java.util.Iterator;
import java.util.Random;

/**
 * @author Jonas Brandstoetter
 * <br>
 * The <code>RandomIterator</code> class represents a <code>Iterator</code>, which generates an infinite number 
 * of pseudo-random numbers.
 */
public class RandomIterator implements Iterator<Integer> {
	
	private static int defaultUpperBound = 100;
	
	private final int bound;
	private Random random;
	
	/**
	 * Construct a <code>RandomIterator</code> object with an upper bound (exclusive) for
	 * the pseudo-random numbers and a <code>Random</code> object, which is used to create the pseudo-random numbers.
	 * 
	 * @param bound  the exclusive upper bound for the pseudo-random numbers
	 * @param random the <code>Random</code> object
	 */
	public RandomIterator (int bound, Random random){
		this.bound = bound;
		this.random = random;
	}
	
	/**
	 * Construct a <code>RandomIterator</code> object with an upper bound (exclusive) for
	 * the pseudo-random numbers and a seed, using which a <code>Random</code>
	 * object is created.
	 * 
	 * @param bound  the exclusive upper bound for the pseudo-random numbers
	 * @param seed the seed, using which the <code>Random</code> object is created
	 */
	public RandomIterator (int bound, long seed) {
		this(bound, new Random(seed));
	}
	
	/**
	 * Construct a <code>RandomIterator</code> object with an upper bound (exclusive) for
	 * the pseudo-random numbers.
	 * 
	 * @param bound  the exclusive upper bound for the pseudo-random numbers
	 */
	public RandomIterator (int bound) {
		this(bound, new Random());
	}
	
	/**
	 * Construct a <code>RandomIterator</code> object with an upper bound (exclusive) for
	 * the pseudo-random numbers. The upper bound will be the current 
	 * value of the <code>static defaultUpperBound</code>-Field.
	 * 
	 * @param random the <code>Random</code> object
	 */
	public RandomIterator (Random random) {
		this(defaultUpperBound, random);
	}
	
	/**
	 * Construct a <code>RandomIterator</code> object with a seed, using which a <code>Random</code> object is created.
	 * The upper bound will be the current value of the <code>static defaultUpperBound</code>-Field.
	 * 
	 * @param seed the seed, using which the <code>Random</code> object is created
	 */
	public RandomIterator (long seed) {
		this(defaultUpperBound, seed);
	}
	
	/**
	 * Construct a <code>RandomIterator</code> object. The upper bound will be the current 
	 * value of the <code>static defaultUpperBound</code>-Field. The <code>Random</code> object will be crated using
	 * the default constructor.
	 */
	public RandomIterator() {
		this(defaultUpperBound, new Random());
	}

	/**
	 * Returns weather a new pseudo-random number can be created with this <code>RandomIterator</code>.
	 * This will always be <code>true</code>.
	 * 
	 * @return <code>true</code>
	 */
	@Override
	public boolean hasNext() {
		return true;
	}

	/**
	 * Returns the next pseudo-random number using the given <code>Random</code> onject.
	 * 
	 * @return the next pseudo-random number.
	 */
	@Override
	public Integer next() {
		return random.nextInt(bound);
	}

	/**
	 * Returns the default upper bound for all <code>RandomSupplier</code> objects.
	 * 
	 * @return the current default upper bound
	 */
	public static int getDefaultUpperBound() {
		return defaultUpperBound;
	}

	/**
	 * Sets the default upper bound for all <code>RandomSupplier</code> objects.
	 * 
	 * @param defaultUpperBound the new value for the default upper bound
	 */
	public static void setDefaultUpperBound(int defaultUpperBound) {
		RandomIterator.defaultUpperBound = defaultUpperBound;
	}

	/**
	 * Returns the <code>final</code> upper bound for pseudo-random numbers for this <code>RandomIterator</code> object.
	 * 
	 * @return the upper bound for pseudo-random numbers
	 */
	public int getBound() {
		return bound;
	}

	/**
	 * Returns the <code>Random</code> object for this <code>RandomIterator</code> object.
	 * 
	 * @return the <code>Random</code> object
	 */
	public Random getRandom() {
		return random;
	}
	
	/**
	 * Sets the <code>Random</code> object for this <code>RandomIterator</code>.
	 * 
	 * @param random the new <code>Random</code> object.
	 */
	public void setRandom(Random random) {
		this.random = random;
	}

	/**
	 * Returns a <code>String</code> representation for this <code>RandomIterator</code>. The <code>String</code> representation is
	 * for informational use only and will change. Do not use this string representation for any programmatic purpose.
	 * 
	 * @return a <code>String</code> representation for this <code>RandomIterator</code>
	 */
	@Override
	public String toString() {
		return "RandomIterator [bound=" + bound + ", random=" + random + "]";
	}

	/**
	 * Return a hash code for this <code>RandomIterator</code> object.
	 * 
	 * @return a hash code for this object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bound;
		result = prime * result + ((random == null) ? 0 : random.hashCode());
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
		RandomIterator other = (RandomIterator) obj;
		if (bound != other.bound)
			return false;
		if (random == null) {
			if (other.random != null)
				return false;
		} else if (!random.equals(other.random))
			return false;
		return true;
	}

}
