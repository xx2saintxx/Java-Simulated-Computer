package src;
/**
 *  Test class for Multiplier methods.
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class multiplier_test extends mainClass {

    void runTests(){
        longword lw1 = new longword();
        longword lw2 = new longword();
        longword lw3 = new longword();

        System.out.println("___________________________");
        System.out.println("MULTIPLIER TESTING");
        System.out.println("1*5 = 5");
       lw1.set(1); lw2.set(5);
       System.out.println("BINARY FORM");
       System.out.println(multiplier.multiply(lw1,lw2));
       System.out.println("DECIMAL FORM");
       System.out.println(multiplier.multiply(lw1,lw2).getSigned());
        System.out.println("___________________________");

        System.out.println("10*25 = 250");
        lw1.set(10); lw2.set(25);
        System.out.println("BINARY FORM");
        System.out.println(multiplier.multiply(lw1,lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(multiplier.multiply(lw1,lw2).getSigned());

        System.out.println("___________________________");
        System.out.println("9*8 = 72");
        lw1.set(9); lw2.set(8);
        System.out.println("BINARY FORM");
        System.out.println(multiplier.multiply(lw1,lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(multiplier.multiply(lw1,lw2).getSigned());

        System.out.println("___________________________");
        System.out.println("0*8 = 72");
        lw1.set(0); lw2.set(8);
        System.out.println("BINARY FORM");
        System.out.println(multiplier.multiply(lw1,lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(multiplier.multiply(lw1,lw2).getSigned());

        System.out.println("___________________________");
        System.out.println("-6*8 = -48");
        lw1.set(-6); lw2.set(8);
        System.out.println("BINARY FORM");
        System.out.println(multiplier.multiply(lw1,lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(multiplier.multiply(lw1,lw2).getSigned());

        System.out.println("___________________________");
        System.out.println("-6*-6 = 36");
        lw1.set(-6); lw2.set(-6);
        System.out.println("BINARY FORM");
        System.out.println(multiplier.multiply(lw1,lw2));
        System.out.println("DECIMAL FORM");
        System.out.println(multiplier.multiply(lw1,lw2).getSigned());
        System.out.println("___________________________");

        System.out.println("END OF MULTIPLIER TESTING");
    }
}
