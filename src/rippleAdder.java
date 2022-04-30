package src;
/**
 *  Rippleadder class, adds and subtracts binary numbers, using two compliment
 *  Tried using a switch case originally but it just broke on some numbers
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class rippleAdder extends rippleAdder_test {

    /**
     * Adds binary numbers using an xor/and gate
     * @param a
     * @param b
     * @return a new longword from a and b
     */
    public static longword add(longword a, longword b) {
        longword lw1 = new longword();
        bit bitA = new bit();
        bit bitB = new bit();
        bit bitCarry = new bit();

        bitCarry.clear(); //set to 0;

        for (int i = 0; i < 32; i++) {
            bitA = a.getBit(i);
            bitB = b.getBit(i);

            // 111
            if ((bitCarry.getValue() == 1) && bitA.and(bitB).getValue() == 1) {
                lw1.getBit(i).set();
                bitCarry.set();
                // System.out.println(result+"  -1");
            }
            //100
            else if ((bitCarry.getValue() == 1) && bitA.or(bitB).getValue() == 0) {
                lw1.getBit(i).set();
                bitCarry.clear();
                //System.out.println(result+"  -5");
            }
            // 110
            else if ((bitCarry.getValue() == 1) && bitA.or(bitB).getValue() == 1) {
                lw1.getBit(i).clear();
                bitCarry.set();
                //System.out.println(result+"  -3");
            }
            //010
            else if ((bitCarry.getValue() == 0) && bitA.and(bitB).getValue() == 1) {
                lw1.getBit(i).clear();
                bitCarry.set();
                //System.out.println(result+"  -2");
            }
            //011
            else if ((bitCarry.getValue()== 0) && bitA.or(bitB).getValue() == 1) {
                lw1.getBit(i).set();
                bitCarry.clear();
                //System.out.println(result+"  -4");
            }
            //000 This marks the end of the addition and will mark the rest for 0.
            else if ((bitCarry.getValue() == 1) && a.getBit(31 - i).or(b.getBit(31 - i)).getValue() == 0) {
                lw1.getBit(31 - i).clear();
                bitCarry.clear();
                //System.out.println(result+"  -6");
            }
            ////000 This marks the end of the addition and will mark the rest for 0.
            //            else if ((bitCarry.getValue() == 1) && a.getBit(32 - i).or(b.getBit(32 - i)).getValue() == 0) {
            //                lw1.getBit(32 - i).set();
            //                bitCarry.clear();
            //                //System.out.println(result+"  -7");
            //            }
        }
        return lw1;
    } //End of Add


    /**
     * subtracts binary numbers using two's compliment
     * @param a
     * @param b
     * @return a new longword from a and b
     */
    public static longword subtract(longword a, longword b) {
        longword lw1 = new longword();
        longword lw2 = new longword(); //result
        bit bitA = new bit();
        bit bitB = new bit();


        lw1.set(b.getSigned());

        for (int i = 0; i < 32; i++) {
            bitB = lw1.getBit(i).not();
            lw1.getBit(i).set(bitB.getValue());
            //System.out.println(lw1);
        }


        if (lw1.getBit(0).getValue() != 1) { //twos compliment
            lw1.getBit(0).set();
        }
        else {
            int index = 0;
            while (lw1.getBit(index).getValue() != 0) {
                lw1.getBit(index).clear();
                index++;
                //System.out.println(index);
                //System.out.println(lw1);
            }
            lw1.getBit(index).set();
        }
        lw2 = add(a, lw1);
        return lw2;
    } //End of Subtract

} // End of Code
