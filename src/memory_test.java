package src;
/**
 *  Test class for memory methods.
 * @Author Toussaint Turnier
 * @Version 1.0
 */

public class memory_test extends mainClass {
    /**
     * MEMORY TESTING
     */
    void runTests() throws Exception {
        memory memory = new memory();
        longword lw1 = new longword();
        longword lw2 = new longword();

        System.out.println("MEMORY TESTING");
        System.out.println("WRITING 10 TO ADDRESS 0");
        lw1.set(10);
        lw2.set(0);
        memory.write(lw2,lw1);
        System.out.println(memory.read(lw2));
        System.out.println("___________________________");
        System.out.println("WRITING 29 TO ADDRESS 50");
        lw1.set(29);
        lw2.set(50);
        memory.write(lw2,lw1);
        System.out.println(memory.read(lw2));
//        System.out.println("WRITING 10 TO ADDRESS -1(EXCEPTION THROW)");
//        lw1.set(10);
//        lw2.set(-1);
//        memory.write(lw2,lw1);
//        System.out.println(memory.read(lw2));
//        System.out.println("___________________________");
//        System.out.println("WRITING 5 TO ADDRESS 1021(EXCEPTION THROW)");
//        lw1.set(5);
//        lw2.set(1021);
//        memory.write(lw2,lw1);
//        System.out.println(memory.read(lw2));
        System.out.println("___________________________");
        System.out.println("END OF MEMORY TEST)");










    }
}
