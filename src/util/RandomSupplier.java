package util;

import java.util.Random;
import java.util.function.Supplier;

/**
 * @author Jonas Brandstoetter
 * <br>
 * The <code>RandomSupplier</code> class represents a <code>Supplier</code>, which generates an infinite number 
 * of pseudo-random numbers.
 */
public class RandomSupplier implements Supplier<Integer> {

	private static int defaultUpperBound = 100;
	
	private Random random;
	private final int bound;

	/**
	 * Construct a <code>RandomSupplier</code> object with an upper bound (exclusive) for
	 * the pseudo-random numbers and a <code>Random</code> object, which is used to create the pseudo-random numbers.
	 * 
	 * @param bound  the exclusive upper bound for the pseudo-random numbers
	 * @param random the <code>Random</code> object
	 */
	public RandomSupplier(int bound, Random random) {
		this.bound = bound;
		this.random = random;
	}

	/**
	 * Construct a <code>RandomSupplier</code> object with an upper bound (exclusive) for
	 * the pseudo-random numbers and a seed, using which a <code>Random</code>
	 * object is created.
	 * 
	 * @param bound the exclusive upper bound for the pseudo-random numbers
	 * @param seed the seed, using which the <code>Random</code> object is created
	 */
	public RandomSupplier(int bound, long seed) {
		this(bound, new Random(seed));
	}

	/**
	 * Construct a <code>RandomSupplier</code> object with an upper bound (exclusive) for
	 * the pseudo-random numbers.
	 * 
	 * @param bound the exclusive upper bound for the pseudo-random numbers
	 */
	public RandomSupplier(int bound) {
		this(bound, new Random());
	}

	/**
	 * Construct a <code>RandomSupplier</code> object with a <code>Random</code> object,
	 * which is used to create the pseudo-random numbers. The upper bound will be the current 
	 * value of the <code>static defaultUpperBound</code>-Field.
	 * 
	 * @param random the <code>Random</code> object
	 */
	public RandomSupplier(Random random) {
		this(defaultUpperBound, random);
	}

	/**
	 * Construct a <code>RandomSupplier</code> object with a seed, using which a <code>Random</code>
	 * object is created. The upper bound will be the current 
	 * value of the <code>static defaultUpperBound</code>-Field.
	 * 
	 * @param seed the seed, using which the <code>Random</code> object is created
	 */
	public RandomSupplier(long seed) {
		this(defaultUpperBound, seed);
	}

	/**
	 * Construct a <code>RandomSupplier</code> object. The upper bound will be the current 
	 * value of the <code>static defaultUpperBound</code>-Field. The <code>Random</code> object
	 * will be created using the default constructor.
	 * 
	 */
	public RandomSupplier() {
		this(defaultUpperBound, new Random());
	}

	/**
	 * Return the next pseudo-random number.
	 * 
	 * @return the next pseudo-random number
	 */
	@Override
	public Integer get() {
		return this.random.nextInt(this.bound);
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
		RandomSupplier.defaultUpperBound = defaultUpperBound;
	}

	/**
	 * Returns the <code>Random</code> object for this <code>RandomSupplier</code>.
	 * 
	 * @return the <code>Random</code> object
	 */
	public Random getRandom() {
		return random;
	}

	/**
	 * Sets the <code>Random</code> object for this <code>RandomSupplier</code>.
	 * 
	 * @param random the new <code>Random</code> object.
	 */
	public void setRandom(Random random) {
		this.random = random;
	}

	/**
	 * Returns the <code>final</code> bound for this <code>RandomSupplier</code>
	 * 
	 * @return the upper bound for the pseudo-random numbers
	 */
	public int getBound() {
		return bound;
	}

	/**
	 * Returns a <code>String</code> representation for this <code>RandomSupplier</code>. The <code>String</code> representation is
	 * for informational use only and will change. Do not use this string representation for any programmatic purpose.
	 * 
	 * @return a <code>String</code> representation for this <code>RandomSupplier</code>
	 */
	@Override
	public String toString() {
		return "RandomSupplier [random=" + random + ", bound=" + bound + "]";
	}

	/**
	 * Return a hash code for this <code>RandomSupplier</code> object.
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
		RandomSupplier other = (RandomSupplier) obj;
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
