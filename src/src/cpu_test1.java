package src;
/**
 *  Test class for CPU 1.
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class cpu_test1 extends mainClass {
    String instructions[];
    computer comp;

    public cpu_test1() {
        instructions = new String[6];
        comp = new computer();
    }

    public void run_tests() throws Exception {
        /**
         * CPU TESTING
         */
        System.out.println("___________________________");
        System.out.println("CPU_1 TESTING");
        String inter0 = "0010 0000 0000 0000";
        String inter1 = "0010 0000 0000 0001";
        String bitHalt = "0000 0000 0000 0000";
        String r210move = "0001 0010 0000 1010";
        String r1move = "0001 0001 1111 1111";

        String addR1R2R3 = "1110 0001 0010 0011";

        instructions[0] = r210move;
        instructions[1] = r1move;
        instructions[2] = addR1R2R3;
        instructions[3] = inter0;
        instructions[4] = inter1;
        instructions[5] = bitHalt;

        comp.preload(instructions);
        comp.run();
        System.out.println("___________________________");
        System.out.println("END OF CPU_1 TEST");

    }

}
