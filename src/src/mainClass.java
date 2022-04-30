package src;

/**
 *  Main class.
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class mainClass {
    public static void main(String[] args) throws Exception {
       bit_test test = new bit_test();
        test.runTests();

        longword_test test2 = new longword_test();
        test2.runTests();

        rippleAdder_test test3 = new rippleAdder_test();
        test3.runTests();

       multiplier_test test4 = new multiplier_test();
        test4.runTests();

        ALU_test test5 = new ALU_test();
        test5.runTests();

        memory_test test6 = new memory_test();
        test6.runTests();

        cpu_test1 test7 = new cpu_test1();
        test7.run_tests();

        assembler_test test8 = new assembler_test();
        test8.run_tests();

        cpu_test3 test9 = new cpu_test3();
        test9.run_tests();

    }
}
