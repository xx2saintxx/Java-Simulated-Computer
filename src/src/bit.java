package src;

/**
 *  Bit class, contains methods for bit.
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class bit implements Ibit {
    private int x; //bit1

    public bit(){

    }

    public bit(int n){
        set(n);
    }

    /**
     * sets the value of the bit
     */
    public void set(int value) {
        // Set the value to 1 or 0

        if (value == 0 || value == 1) {
            this.x = value;
        } else {
            System.out.println("Error: Invalid value for bit: " + value);
        }

    }


    /**
     * changes the value from 0 to 1 or 1 to 0
     *
     * @return
     */
    public void toggle() {
        if (getValue() == 1) {
            clear();
        } else if(getValue() == 0)
            set();
    }


    /**
     * sets the bit to 1
     */

    public void set() {
        // sets the bit to 1

        this.x = 1;

    }


    /**
     * sets the bit to 0
     */
    public void clear() {
        set(0);
    }


    /**
     * returns the current value
     */
    public int getValue() {
        return this.x;   
    }


    /**
     * performs (and on) two bits and returns a new bit set to the result
     */
    public bit and(bit other) {
        bit bit3 = new bit(); // new bit

        int a = getValue();
        int b = other.getValue();

        switch (a) {
            case 1: //Fail immediately if not 1
                if (a != 1) {
                    bit3.clear();
                }

            case 2: //Pass first, but fails after
                if (b != 1) {
                    bit3.clear();
                }

            case 3: //Pass first, then passes again
                if (a == b){
                    bit3.set();
                }
        }
        return bit3;
    }


    /**
     * performs or on two bits and returns a new bit set to the result
     */
    public bit or(bit other) {
        bit bit3 = new bit();
        int a = getValue();
        int b = other.getValue();

        switch (a+b) {
            case 1:
                if ((a + b) == 0){
                    bit3.clear();
                }

            case 2:
                if ((a + b) > 0) {
                    bit3.set();
                }
        }
            return bit3;
        }


    /**
     * performs xor on two bits and returns a new bit set to the result
     */
    public bit xor(bit other) {
        bit bit3 = new bit();
        int a = getValue();
        int b = other.getValue();

        switch (a+b) {
            case 1:
                if ((a + b) == 0){
                    bit3.clear();
                }
            case 2:
                if ((a + b) >= 1) {
                    bit3.clear();
                }
            case 3:
                if ((a + b) == 1) {
                    bit3.set();
                }
        }
        return bit3;

    }

    /**
     * performs not on the existing bit, returning the result as a new bit
     */
    public bit not() {
        bit bit3 = new bit();
        int a = getValue();

        bit3.set(a);
        bit3.toggle();

        return bit3;
    }

    @Override
    public String toString() {
        return ""+this.x;
    }
} //End of Code
