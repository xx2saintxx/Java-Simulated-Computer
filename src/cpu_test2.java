package src;
/**
 *  Test class for CPU 2.
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class cpu_test2 extends mainClass{
    static computer computer = new computer();
    static assembler Assembler = new assembler();

    /**
     * @throws Exception
     */
    public static void run_tests() throws Exception {
        /**
         * CPU_TEST 2
         */
        System.out.println("___________________________");
        System.out.println("CPU_2 TESTING");
        String[] test1 = {
                "Move R1 0", // TRACK 0
                "Move R2 1", // TRACK 2
                "Move R3 9", // TRACK 4
                "Jump 12", // TRACK 6
                "Interrupt 0", // TRACK 8
                "Halt", //TRACK 10
                "Compare R1 R3", // TRACK 12
                "BranchIfNotEqual 4", // TRACK 14
                "Jump 8", // TRACK 16
                "Add R1 R2 R1", // TRACK 18
                "Jump 12", //TRACK 20
        };
        String[] assembleCode = Assembler.assemble(test1);
        computer.preload(assembleCode);
        computer.run();
        System.out.println("R1 == R3");
        System.out.println("R3 = 9");



        System.out.println("___________________________");
        System.out.println("Branch if Equal");
        String[] test2 = {
                "Move R1 0",
                "Move R2 1",
                "Move R3 70",
                "Jump 12",
                "Interrupt 0",
                "Halt",
                "Compare R1 R3",
                "BranchIfEqual -6",
                "Add R1 R2 R1",
                "Jump 12",
        };
        assembleCode = Assembler.assemble(test2);
        computer = new computer();
        computer.preload(assembleCode);
        computer.run();

        System.out.println("R1 = R3 = 70");
        System.out.println("___________________________");


        System.out.println(" Branch if Greater Than");
        String[] test3 = {
                "Move R1 8",
                "Move R2 1",
                "Move R3 5",
                "Jump 12",
                "Interrupt 0",
                "Halt",
                "Compare R1 R3",
                "BranchIfGreaterThan -6",
                "Add R1 R2 R1",
                "Jump 12",
        };
        assembleCode = Assembler.assemble(test3);
        computer = new computer();
        computer.preload(assembleCode);
        computer.run();
        System.out.println("R1 > R3 (8>5)");
        System.out.println("___________________________");


        System.out.println("Branch if Greater than or Equal");
        String[] test4 = { "Move R1 0",
                "Move R2 1",
                "Move R3 66",
                "Jump 12",
                "Interrupt 0",
                "Halt",
                "Compare R3 R1",
                "BranchIfGreaterThanOrEqual -6",
                "Add R1 R2 R1",
                "Jump 12",
        };
        assembleCode = Assembler.assemble(test4);
        computer = new computer();
        computer.preload(assembleCode);
        computer.run();


        System.out.println("R1 = R3 = 66");
        System.out.println("___________________________");
        System.out.println("END OF CPU_2 TESTING");
    }
} //END OF TESTING

