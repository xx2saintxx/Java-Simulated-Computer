package src;
/**
 *  Test class for rippleAdder methods.
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class rippleAdder_test extends mainClass{
    void runTests(){
        longword lw1 = new longword();
        longword lw2 = new longword();
        longword lw3 = new longword();

        /**
         * RIPPLE ADDER TESTING
         */
        System.out.println("RIPPLE ADDER TESTING");
        System.out.println("Addition testing");
        System.out.println("29+4 = 33");
        lw1.set(29);
        lw2.set(4);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println("BINARY FORM");
        System.out.println(rippleAdder.add(lw1, lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(rippleAdder.add(lw1, lw2).getSigned());
        System.out.println("___________________________");
        System.out.println("50+5 = 55");
        lw1.set(50);
        lw2.set(5);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println("BINARY FORM");
        System.out.println(rippleAdder.add(lw1, lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(rippleAdder.add(lw1, lw2).getSigned());
        System.out.println("___________________________");
        System.out.println("5 + -4 = 3");
        lw1.set(5);
        lw2.set(-4);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println("BINARY FORM");
        System.out.println(rippleAdder.add(lw1, lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(rippleAdder.add(lw1, lw2).getSigned());
        System.out.println("___________________________");


        System.out.println("Subtraction testing");
        System.out.println("29-3 = 26");
        lw1.set(29);
        lw2.set(3);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println("BINARY FORM");
        System.out.println(rippleAdder.subtract(lw1, lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(rippleAdder.subtract(lw1, lw2).getSigned());
        System.out.println("___________________________");
        System.out.println("29+4 = 33");
        lw1.set(50);
        lw2.set(25);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println("BINARY FORM");
        System.out.println(rippleAdder.subtract(lw1, lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(rippleAdder.subtract(lw1, lw2).getSigned());
        System.out.println("___________________________");
        lw1.set(9);
        lw2.set(5);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println("BINARY FORM");
        System.out.println(rippleAdder.subtract(lw1, lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(rippleAdder.subtract(lw1, lw2).getSigned());
        System.out.println("___________________________");
        System.out.println("5 + -4 = 3");
        lw1.set(55);
        lw2.set(-4);
        System.out.println(lw1.toString());
        System.out.println(lw2.toString());
        System.out.println("BINARY FORM");
        System.out.println(rippleAdder.subtract(lw1, lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(rippleAdder.subtract(lw1, lw2).getSigned());
        System.out.println("___________________________");
        System.out.println("END OF RIPPLE ADDER TESTING");

    }
}
