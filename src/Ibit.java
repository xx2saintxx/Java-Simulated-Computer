package src;

/**
 *  This is the interface for called bit,
 *  to represent one bit. You must internally (private) use an integer to represent the one bit;
 *  the valid values are 0 (off) and 1 (on).
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public interface Ibit {

    /**
     * sets the value of the bit
     */
    void set(int value);

    /**
     * changes the value from 0 to 1 or 1 to 0
     */
    void toggle();

    /**
     * sets the bit to 1
     */
    void set();

    /**
     * sets the bit to 0
     */
    void clear();

    /**
     * returns the current value
     */
    int getValue();

    /**
     * performs and on two bits and returns a new bit set to the result
     */
    bit and(bit other);

    /**
     * performs or on two bits and returns a new bit set to the result
     */
    bit or(bit other);

    /**
     * performs xor on two bits and returns a new bit set to the result
     */
    bit xor(bit other);

    /**
     * performs not on the existing bit, returning the result as a new bit
     */
    bit not();

    /**
     *returns “0” or “1” in string format
     */
    @Override
    String toString();
}
