package src;
/**
 *  Test class for longword methods.
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class longword_test extends mainClass {
    longword lw1 = new longword(); //Test Lines: 12,13,22,25,36,37,42,43,56,57,62,63,68,81,88,93,103,107,116,135,137,139,146,148
    longword lw2 = new longword();
    longword lw3 = new longword();


    void runTests(){
        /**
         * LONGWORD TESTING
         */
        System.out.println("LONGWORD TESTING");
        System.out.println("71 & 13");
        lw1.set(71);
        lw2.set(13);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println("___________________________");

        /**
         * COPY TESTING(NOT SURE IF IT MUST BE ABLE TO REMOVE AN ALREADY EXISTING LONGWORD)
         */
        System.out.println("COPY 1ST LONG WORD (71)");
        lw3.copy(lw1);
        System.out.println(lw3.toString());
        System.out.println("COPY 2ND LONG WORD (13)");
        lw3.copy(lw2);
        System.out.println(lw3.toString());

        /**
         * AND test
         */
        System.out.println("And test");
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw1.and(lw2).toString());
        System.out.println("SETTING EACH LONG WORD TO 65");
        lw1.set(65);
        lw2.set(65);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw1.and(lw2).toString());
        System.out.println("SETTING EACH LONG WORD TO 13 ");
        lw1.set(13);
        lw2.set(13);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw1.and(lw2).toString());
        System.out.println("___________________________");
        /**
         * OR TEST
         */
        System.out.println("OR test");
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw1.or(lw2).toString());
        System.out.println("SETTING EACH LONG WORD TO 72");
        lw1.set(72);
        lw2.set(72);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw1.or(lw2).toString());
        System.out.println("SETTING EACH LONG WORD TO 13");
        lw1.set(13);
        lw2.set(13);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw1.or(lw2).toString());
        System.out.println("SETTING 1ST LONG WORD TO 72");
        lw1.set(72);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw1.or(lw2).toString());
        System.out.println("___________________________");
        /**
         * XOR TEST
         */
        System.out.println("XOR test");
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw1.xor(lw2).toString());
        System.out.println("SETTING EACH LONG WORD TO 72");
        lw1.set(72);
        lw2.set(72);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw1.xor(lw2).toString());
        System.out.println("SETTING EACH LONG WORD TO 13");
        lw1.set(13);
        lw2.set(13);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw1.xor(lw2).toString());
        System.out.println("SETTING 1ST LONG WORD TO 72");
        lw1.set(72);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw1.xor(lw2).toString());
        System.out.println("___________________________");
        /**
         * NOT test
         */
        System.out.println("NOT Test");
        System.out.println("Setting longword1 to 72...");
        lw1.set(72);
        System.out.println(lw1.toString());
        System.out.println(lw1.not().toString());
        System.out.println("Setting longword1 to 12...");
        lw1.set(13);
        System.out.println(lw1.toString());
        System.out.println(lw1.not().toString());
        System.out.println("___________________________");
        /**
         * GET SIGNED TEST
         */
        System.out.println("SIGNED TEST");
        System.out.println("set to 11");
        lw1.set(11);
        System.out.println(lw1.getSigned());
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println(lw2.getSigned());
        System.out.println("___________________________");
        /**
         * GET UNSIGNED TEST
         */
        System.out.println("UNSIGNED TEST");
        System.out.println(lw1.toString());
        System.out.println(lw1.getUnsigned());
        System.out.println(lw2.toString());
        System.out.println(lw2.getUnsigned());
        System.out.println("___________________________");
        /**
         * RIGHT SHIFT TEST
         */
        System.out.println("RIGHT SHIFT TEST");
        lw1.set(6);
        System.out.println(lw1.toString());
        System.out.println(lw1.rightShift(4).toString());
        System.out.println(lw2.toString());
        System.out.println(lw2.rightShift(4).toString());
        System.out.println("___________________________");
        /**
         * LEFT SHIFT TEST
         */
        System.out.println("LEFT SHIFT TEST");
        System.out.println(lw1.toString());
        System.out.println(lw1.leftShift(12).toString());
        System.out.println(lw2.toString());
        System.out.println(lw2.leftShift(4).toString());
        System.out.println("___________________________");
        System.out.println("END OF LONGWORD CLASS TESTING");


    }

}//End of Code
