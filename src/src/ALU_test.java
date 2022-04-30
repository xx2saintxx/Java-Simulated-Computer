package src;
/**
 *  Test class for ALU methods.
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class ALU_test {
    bit[] opCode = new bit[4];
    longword lw1 = new longword();
    longword lw2 = new longword();
    
    public void runTests() {
        for (int i = 0; i < 4; i++) {
            opCode[i] = new bit(0);
        }
        /**
         * ALU TESTING
         */
        System.out.println("ALU TESTING");
        System.out.println("AND: 1000");
        lw1.set(5);
        lw2.set(12);
        opCode[0].set();
        opCode[1].clear();
        opCode[2].clear();
        opCode[3].clear();
        System.out.println("Code:"+ opCode[0]+opCode[1]+opCode[2]+opCode[3]);
        System.out.println("Number:"+lw1.getSigned()+" & Number:"+lw2.getSigned());
        System.out.println(lw1);
        System.out.println(lw2);
        System.out.println("RESULT");
        System.out.println(ALU.doOp(opCode, lw1, lw2));
        System.out.println("___________________________");

        System.out.println("OR: 1001");
        lw1.set(10);
        lw2.set(9);
        opCode[0].set();
        opCode[1].clear();
        opCode[2].clear();
        opCode[3].set();
        System.out.println("Code:"+ opCode[0]+opCode[1]+opCode[2]+opCode[3]);
        System.out.println("Number:"+lw1.getSigned()+" & Number:"+lw2.getSigned());
        System.out.println(lw1);
        System.out.println(lw2);
        System.out.println("RESULT");
        System.out.println(ALU.doOp(opCode, lw1, lw2));
        System.out.println("___________________________");

        System.out.println("XOR: 1010");
        lw1.set(6);
        lw2.set(18);
        opCode[0].set();
        opCode[1].clear();
        opCode[2].set();
        opCode[3].clear();
        System.out.println("Code:"+ opCode[0]+opCode[1]+opCode[2]+opCode[3]);
        System.out.println("Number:"+lw1.getSigned()+" & Number:"+lw2.getSigned());
        System.out.println(lw1);
        System.out.println(lw2);
        System.out.println("RESULT");
        System.out.println(ALU.doOp(opCode, lw1, lw2));
        System.out.println("___________________________");

        System.out.println("NOT: 1011");
        lw1.set(3);
        opCode[0].set();
        opCode[1].clear();
        opCode[2].set();
        opCode[3].set();
        System.out.println("Code:"+ opCode[0]+opCode[1]+opCode[2]+opCode[3]);
        System.out.println("Number:"+lw1.getSigned());
        System.out.println(lw1);
        System.out.println("RESULT");
        System.out.println(ALU.doOp(opCode, lw1, lw2));
        System.out.println("___________________________");

        System.out.println("LEFTSHIFT: 1100");
        lw1.set(4);
        lw2.set(3);
        opCode[0].set();
        opCode[1].set();
        opCode[2].clear();
        opCode[3].clear();
        System.out.println("Code:"+ opCode[0]+opCode[1]+opCode[2]+opCode[3]);
        System.out.println("Number:"+lw1.getSigned()+" & Number:"+lw2.getSigned());
        System.out.println(lw1);
        System.out.println("RESULT");
        System.out.println(ALU.doOp(opCode, lw1, lw2));
        System.out.println("___________________________");

        System.out.println("RIGHTSHIFT: 1100");
        lw1.set(7);
        lw2.set(1);
        opCode[0].set();
        opCode[1].set();
        opCode[2].clear();
        opCode[3].set();
        System.out.println("Code:"+ opCode[0]+opCode[1]+opCode[2]+opCode[3]);
        System.out.println("Number:"+lw1.getSigned()+" & Number:"+lw2.getSigned());
        System.out.println(lw1);
        System.out.println("RESULT");
        System.out.println(ALU.doOp(opCode, lw1, lw2));
        System.out.println("___________________________");

        System.out.println("ADD: 1110");
        lw1.set(20);
        lw2.set(10);
        opCode[0].set();
        opCode[1].set();
        opCode[2].set();
        opCode[3].clear();
        System.out.println("Code:"+ opCode[0]+opCode[1]+opCode[2]+opCode[3]);
        System.out.println("Number:"+lw1.getSigned()+" & Number:"+lw2.getSigned());
        System.out.println(lw1);
        System.out.println(lw2);
        System.out.println("RESULT");
        System.out.println(ALU.doOp(opCode, lw1, lw2));
        System.out.println(ALU.doOp(opCode, lw1, lw2).getSigned());
        System.out.println("___________________________");

        System.out.println("SUBTRACT: 1111");
        lw1.set(21);
        lw2.set(20);
        opCode[0].set();
        opCode[1].set();
        opCode[2].set();
        opCode[3].set();
        System.out.println("Code:"+ opCode[0]+opCode[1]+opCode[2]+opCode[3]);
        System.out.println("Number:"+lw1.getSigned()+" & Number:"+lw2.getSigned());
        System.out.println(lw1);
        System.out.println(lw2);
        System.out.println("RESULT");
        System.out.println(ALU.doOp(opCode, lw1, lw2));
        System.out.println(ALU.doOp(opCode, lw1, lw2).getSigned());
        System.out.println("___________________________");

        System.out.println("MULTIPLY: 0111");
        lw1.set(3);
        lw2.set(9);
        opCode[0].clear();
        opCode[1].set();
        opCode[2].set();
        opCode[3].set();
        System.out.println("Code:"+ opCode[0]+opCode[1]+opCode[2]+opCode[3]);
        System.out.println("Number:"+lw1.getSigned()+" & Number:"+lw2.getSigned());
        System.out.println(lw1);
        System.out.println(lw2);
        System.out.println("RESULT");
        System.out.println(ALU.doOp(opCode, lw1, lw2));
        System.out.println(ALU.doOp(opCode, lw1, lw2).getSigned());
        System.out.println("___________________________");

    }
}

