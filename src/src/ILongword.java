package src;

/**
 *  This is the interface for called Longword
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public interface ILongword {

    /**
     * Get bit i
     */
    bit getBit(int i);

        /**
     * set bit i's value
     */
    void setBit(int i, bit value);

        /**
     * and two longwords, returning a third
     */
    longword and(longword other);

        /**
     * or two longwords, returning a third
     */
    longword or(longword other);

        /**
     * xor two longwords, returning a third
     */
    longword xor(longword other);

        /**
     *negate this longword, creating another
     */
    longword not();

    /**
     * rightshift this longword by amount bits, creating a new longword
     */
    longword rightShift(int amount);

        /**
     * leftshift this longword by amount bits, creating a new longword
     */
    longword leftShift(int amount);


        /**
     *returns a comma separated string of 0's and 1's: "0,0,0,0,0 (etcetera)" for example
     */
    @Override
    String toString();

    /**
     * // returns the value of this longword as a long
     */
    long getUnsigned();

    /**
     * returns the value of this longword as an int
     */
    int getSigned();

    /**
     * copies the values of the bits from another longword into this one
     */
    void copy(longword other);

        /**
     * set the value of the bits of this longword (used for tests)
     */
    void set(int value);
    }
