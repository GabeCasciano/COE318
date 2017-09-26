/**
 *
 * @author Your Name
 */
package coe318.lab3;
public class Counter {
    private int modulus;
    private Counter left;
    private int digit;

    public Counter(int modulus, Counter left) {
        this.modulus = modulus;
        this.left = left;
    }
    /**
     * @return the modulus
     */
    public int getModulus() {
        return modulus;
    }
    /**
     * Returns the Counter to the left attached to this
     * Counter.  Returns null if there is no Counter
     * to the left.
     * @return the left
     */
    public Counter getLeft() {
        return left;
    }
    /**
     * @return the digit
     */
    public int getDigit() {
        return digit;
    }

    /**
     * @param digit the digit to set
     */
    public void setDigit(int digit) {
        this.digit = digit;
    }

    /**
     * Increment this counter.  If it rolls over,
     * its left Counter is also incremented if it
     * exists.
     */
    public void increment() {
        digit++;
        if(digit == modulus){
            if(left != null)
                left.increment();
            digit = 0;
        }

    }

    /** Return the count of this Counter combined
     * with any Counter to its left.
     *
     * @return the count
     */
    public int getCount() {
        return ((left != null)?(digit + modulus*left.getCount()):digit);
    }

    /** Returns a String representation of the Counter's
     * total count (including its left neighbour).
     * @return the String representation
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE
        return "" + getCount();
    }

}
