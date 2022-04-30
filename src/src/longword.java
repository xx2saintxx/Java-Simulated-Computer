package src;
/**
 *  Longword class, contains methods for Longword.
 *  Used to be an arraylist but was impossible to work with
 * @Author Toussaint Turnier
 * @Version 2.0
 *
 */
public class longword implements ILongword {
    private bit[] lw;

    public longword() {
        lw = new bit[32];
        for (int i = 0; i < 32; i++){
            lw[i] = new bit(0);
        }
    }

    /**
     * Get bit i
     */
    public bit getBit(int i){
        if (i > -1 && i < 32) {
            return this.lw[31 - i];
        } else {
            System.out.println("Error GetBit/Bad range: " + i);
            return this.lw[31];
        }
    }

    /**
     * set bit i's value
     */
    public void setBit(int i, bit value) {
        if (i < 32 && i > -1) {
            lw[31 - i].set(value.getValue());
        } else {
            System.out.println("Error SetBit/Bad range: " + i);
        }
    }

    /**
     * and two longwords, returning a third
     */
    public longword and(longword other) {
        longword lw1 = new longword();
        bit bitA = new bit();
        bit bitB = new bit();
        bit bitC = new bit();

        for (int i = 0; i < 32; i++) {
            bitA = (bit)lw[31 - i];
            bitB = other.getBit(i);
            bitC = bitA.and(bitB);
            lw1.setBit(i, bitC);
        }
        return lw1;
    }
    /**
     * or two longwords, returning a third
     */
    public longword or(longword other) {
        longword lw1 = new longword();
        bit bitA = new bit();
        bit bitB = new bit();
        bit bitC = new bit();

        for (int i = 0; i < 32; i++) {
            bitA = (bit)lw[31 - i];
            bitB = other.getBit(i);
            bitC = bitA.or(bitB);
            lw1.setBit(i, bitC);
        }
        return lw1;
    }
    /**
     * xor two longwords, returning a third
     */
    public longword xor(longword other) {
        longword lw1 = new longword();
        bit bitA = new bit();
        bit bitB = new bit();
        bit bitC = new bit();

        for (int i = 0; i < 32; i++) {
            bitA = (bit)lw[31 - i];
            bitB = other.getBit(i);
            bitC = bitA.xor(bitB);
            lw1.setBit(i, bitC);
        }
        return lw1;
    }
    /**
     * negate this longword, creating another
     */
    public longword not() {
        longword lw1 = new longword();
        for (int i = 0; i < 32; i++) {
            if (lw[31 - i].getValue() == 0) {
                lw1.lw[31 - i].set();
            } else
                lw1.lw[31 - i].clear();
        }
        return lw1;
    }

    /**
     * rightshift this longword by amount bits, creating a new longword
     */
    public longword rightShift(int amount) {
        longword lw1 = new longword();
        lw1.set(this.getSigned());

        if (amount > 0) {
            for (int j = 0; j < amount; j++) {
                for (int i = 0; i < 32; i++) {
                    if (i == 31) {
                        lw1.lw[31 - i].set(0);
                    } else {
                        lw1.lw[31 - i].set(lw1.lw[30 - i].getValue());
                    }
                }
            }
        } else {
            amount *= -1;

            for (int j = 0; j < amount; j++) {
                for (int i = 0; i < 32; i++) {
                    if (i == 31) {
                        lw1.lw[i].set(0);
                    } else {
                        lw1.lw[i].set(lw1.lw[i + 1].getValue());
                    }
                }
            }
        }
        return lw1;
    }

    /**
     * leftshift this longword by amount bits, creating a new longword
     */
    public longword leftShift(int amount) {

        longword lw1 = new longword();
        lw1.set(this.getSigned());
        if (amount > 0) {
            for (int j = 0; j < amount; j++) {
                for (int i = 0; i < 32; i++) {
                    if (i == 31) {
                        lw1.lw[i].set(0);
                    } else {
                        lw1.lw[i].set(lw1.lw[i + 1].getValue());
                    }
                }
            }
        } else {
            amount *= -1;
            for (int j = 0; j < amount; j++) {
                for (int i = 0; i < 32; i++) {
                    if (i == 31) {
                        lw1.lw[31 - i].set(0);
                    } else {
                        lw1.lw[31 - i].set(lw1.lw[30 - i].getValue());
                    }
                }
            }
        }
        return lw1;
    }

    /**
     * returns a comma separated string of 0's and 1's: "0,0,0,0,0 (etcetera)" for example
     */
    public String toString() {
        String lw1 = "";
        for (int i = 0; i < 32; i++) {
            if (i == 31) {
                lw1 += "" + lw[i].getValue();
            } else {
                lw1 += "" + lw[i].getValue();
            }
        }
        return lw1;
    }
    /**
     * returns the value of this longword as a long
     */
    public long getUnsigned() {
        long result = 0;
        for (int i = 0; i < 32; i++) {
            result += lw[31 - i].getValue() * Math.pow(2, i);
        }
        return result;
    }
    /**
     * returns the value of this longword as an int
     */
    public int getSigned() {
        longword temp = new longword();
        int result = 0;

        if (lw[0].getValue() == 1) {
            for (int i = 0; i < 32; i++) {
                temp.getBit(i).set(this.getBit(i).not().getValue());
            }
            if (temp.getBit(0).getValue() == 0) {
                temp.getBit(0).set();
            } else {
                int index = 0;
                while (temp.getBit(index).getValue() == 1) {
                    temp.getBit(index).clear();
                    index++;
                }
                temp.getBit(index).set();
            }

            for (int i = 0; i < 32; i++) {
                result += temp.getBit(i).getValue() * Math.pow(2, i);
            }
            result *= -1;
        } else {
            for (int i = 0; i < 32; i++) {
                result += this.getBit(i).getValue() * Math.pow(2, i);
            }
        }
        return result;
    }
    /**
     * copies the values of the bits from another longword into this one,
     * however it does NOT remove the 2nd copy when used twice.
     */
    public void copy(longword other) {
        for (int i = 0; i < 32; i++) {
            this.lw[i].set(other.lw[i].getValue());
        }
    }

    /**
     * set the value of the bits of this longword (used for tests)
     */
    public void set(int value) {
        if (value > 0) {
            int binary[] = new int[32];
            int index = 0;
            while (value > 0) {
                binary[index++] = value % 2;
                value = value / 2;
            }

            for (int i = 0; i < 32; i++) {
                this.getBit(i).set(binary[i]);
            }
        } else if (value == 0) {
            for (int i = 0; i < 32; i++) {
                this.getBit(i).clear();
            }
        } else {
            value = value * -1;

            int binary[] = new int[32];
            int index = 0;
            while (value > 0) {
                binary[index++] = value % 2;
                value = value / 2;
            }

            for (int i = 0; i < 32; i++) {
                this.getBit(i).set(binary[i]);
            }
            for (int i = 0; i < 32; i++) {
                this.getBit(i).set(this.getBit(i).not().getValue());
            }

            if (this.getBit(0).getValue() == 0) {
                this.getBit(0).set();
            } else {
                index = 0;
                while (this.getBit(index).getValue() == 1) {
                    if (index == 31) {
                        break;
                    }
                    this.getBit(index).clear();
                    index++;
                }
                this.getBit(index).set();
            }
        }
    }
} //End of Code