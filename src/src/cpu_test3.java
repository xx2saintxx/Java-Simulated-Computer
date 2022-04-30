package src;
/**
 *  Test class for CPU 3.
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class cpu_test3 {
    static computer comp = new computer();
    static assembler a = new assembler();

    public static void run_tests() throws Exception {
        /**
         * CPU_TEST 3
         */
        System.out.println("___________________________");
        System.out.println("CPU_3 TESTING");
        System.out.println("PUSH TEST");

        String[] test1 = {
                "Move R1 17",
                "Push R1",
                "Move R1 10",
                "Push R1",
                "Interrupt 1",
                "Halt" };

        comp.preload(a.assemble(test1));
        comp.run();
        System.out.println("___________________________");
        // Pop
        System.out.println("\nPOP TEST");

        String[] test2 = {
                "Move R1 12",
                "Push R1",
                "Move R1 5",
                "Pop R3",
                "Interrupt 0",
                "Halt" };

        comp = new computer();
        comp.preload(a.assemble(test2));
        comp.run();

        // Call
        System.out.println("\nCALL TEST");

        String[] test3 = {
                "Move R1 4",
                "call 6",
                "Halt",
                "Push R1",
                "Pop R5",
                "Interrupt 0",
                "Halt" };

        comp = new computer();
        comp.preload(a.assemble(test3));
        comp.run();
        System.out.println("___________________________");
        // Return
        System.out.println("\nTest Return");
        String[] test4 = {
                "Move R1 3",
                "call 12",
                "Interrupt 0",
                "Halt",
                "Push R1",
                "Pop R5",
                "Return",
                "Interrupt 1",
                "Halt" };
        comp = new computer();
        comp.preload(a.assemble(test4));
        comp.run();
        System.out.println("___________________________");
        System.out.println("END OF CPU3 TESTING");
    }

}