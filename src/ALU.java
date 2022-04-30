package src;
/**
 * This is the ALU class. Taking in an operation Code and then preforming instruction on input A and input B
 * @author Toussaint Turnier
 * Version 1.0
 */
public class ALU {

    /**
     * This is the doOP method. Taking in an operation Code and then preforming instruction on input A and input B
     * @param opCode The code of the operation to be done.
     * @param a first longword
     * @param b second longword
     * @return A longword represented by what operation was preformed
     */
    public static longword doOp(bit[] opCode, longword a, longword b) {
        longword lw1 = new longword();
        StringBuilder sb = new StringBuilder();

       for(int i = 0; i < opCode.length;i++){
           sb.append(opCode[i].getValue());
       }
       String code = sb.toString();

        switch (code) {

            // and
            case "1000":
                lw1 = a.and(b);
                break;

            // or
            case "1001":
                lw1 = a.or(b);
                break;

            // xor
            case "1010":
                lw1 = a.xor(b);
                break;

            // not
            case "1011":
                lw1 = a.not();
                break;

            // LeftShift
            case "1100":
                lw1 = a.leftShift(b.getSigned());
                break;

          // RightShift
            case "1101":
                lw1 = a.rightShift(b.getSigned());
                break;
            // add
            case "1110":
                lw1 = rippleAdder.add(a, b);
                break;

            // subtract
            case "1111":
                lw1 = rippleAdder.subtract(a, b);
                break;

            // multiply
            case "0111":
                lw1 = multiplier.multiply(a, b);
                break;
        }
        return lw1;
    }
}

