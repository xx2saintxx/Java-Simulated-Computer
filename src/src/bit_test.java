package src;

/**
 *  Test class for bit methods.
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class bit_test extends mainClass {

        void runTests(){
            bit bit1 = new bit();
            var bit2 = new bit();
            bit bit3 = new bit();
            /**
             * CLEAR test (set to 0)
             */
            System.out.println("CLEAR test");
            bit1.clear();
            bit2.clear();
            bit3.clear();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit3.toString());
            System.out.println("___________________________");

            /**
             * SET test (set to 1)
             */
            System.out.println("SET test");
            bit1.set();
            bit2.set();
            bit3.set();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit3.toString());
            System.out.println("___________________________");

            /**
             * TOGGLE test (1 to 0 or 0 to 1)
             */
            System.out.println("TOGGLE test");
            bit1.toggle();
            bit2.toggle();
            bit3.toggle();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit3.toString());
            System.out.println("___________________________");

            /**
             * AND test
             */
            System.out.println("And test");
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.and(bit2).toString());
            System.out.println("Setting BOTH bit1 and bit2 to 1...");
            bit1.set();
            bit2.set();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.and(bit2).toString());
            System.out.println("Setting bit1 to 0...");
            bit1.toggle();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.and(bit2).toString());
            System.out.println("Setting bit1 to 1 and bit2 to 0...");
            bit1.toggle();
            bit2.toggle();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.and(bit2).toString());
            System.out.println("___________________________");

            /**
             * OR test
             */
            System.out.println("OR Test");
            System.out.println("Setting BOTH bit1 and bit2 to 0...");
            bit1.clear();
            bit2.clear();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.or(bit2).toString());
            System.out.println("Setting BOTH bit1 and bit2 to 1...");
            bit1.set();
            bit2.set();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.or(bit2).toString());
            System.out.println("Setting bit1 to 0...");
            bit1.toggle();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.or(bit2).toString());
            System.out.println("Setting bit1 to 1 and bit2 to 0...");
            bit1.toggle();
            bit2.toggle();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.or(bit2).toString());
            System.out.println("___________________________");


            /**
             * XOR test
             */
            System.out.println("XOR Test");
            System.out.println("Setting BOTH bit1 and bit2 to 0...");
            bit1.clear();
            bit2.clear();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.xor(bit2).toString());
            System.out.println("Setting BOTH bit1 and bit2 to 1...");
            bit1.set();
            bit2.set();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.xor(bit2).toString());
            System.out.println("Setting bit1 to 0...");
            bit1.toggle();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.xor(bit2).toString());
            System.out.println("Setting bit1 to 1 and bit2 to 0...");
            bit1.toggle();
            bit2.toggle();
            System.out.println(bit1.toString());
            System.out.println(bit2.toString());
            System.out.println(bit1.xor(bit2).toString());
            System.out.println("___________________________");

            /**
             * NOT test
             */
            System.out.println("NOT Test");
            System.out.println("Setting bit1 to 0...");
            bit1.clear();
            System.out.println(bit1.toString());
            System.out.println(bit1.not().toString());
            System.out.println("Setting bit1 to 1...");
            bit1.set();
            System.out.println(bit1.toString());
            System.out.println(bit1.not().toString());
            System.out.println("___________________________");
            System.out.println("END OF BIT CLASS TESTING");

        }
    }//End of Code
