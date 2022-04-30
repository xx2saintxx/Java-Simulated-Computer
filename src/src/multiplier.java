package src;
/**
 * This is the multiplier class. Two binary numbers get multiplied.
 * @author Toussaint Turnier
 * Version 1.0
 */
public class multiplier {

    /**
     * This is the multiplier method.
     * @param a first longword
     * @param b second longword
     * @return a * b multiplied
     */
    public static longword multiply(longword a, longword b){
        bit bit1 = new bit();
        longword lw1 = new longword();
        longword lw2 = new longword();
        rippleAdder rippleAdder = new rippleAdder();

        lw1.set(0);
        lw2.set(0);
        int temp = 0;
        for(int i = 0; i < 32; i++){ //32 bit loop
            bit1 = b.getBit(i); //Instantiate bit1

            if(bit1.getValue() == 0)//0 check, does nothing if passed
            {
               //System.out.println("READ");
            }
            else if(bit1.getValue() == 1){
                lw2 = a.leftShift(i);//Shifts by i index when bit is 1
                int multAns = rippleAdder.add(lw1, lw2).getSigned();//Get answer for set
                lw1.set(multAns);
            }
            temp++;
        }
        return lw1;
    }
    }

//while(bit1 != 0){
//  lw2 = a.leftShift(i);
//  rippleAdder.add(lw1, lw2).getSigned();
//  lw1.set(multAns);
//  }