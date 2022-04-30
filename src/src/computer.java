package src;
import static java.lang.Math.*;
import java.util.ArrayList; // import the ArrayList class
/**
 *  (CPU) Computer class. Holds 16 registers. Can decode, execute, and store instructions.
 * #TODO unable to test class
 * @Author Toussaint Turnier
 * @Version 1.0
 */
public class computer {

    bit[] opCode = new bit[4];
    private final bit bitHalt;
    private final bit bitLessGreat; // 0 = LessThan 1= Greater Than
    private final bit bitEqual;// 0 = not Equal 1 = Equal
    private final longword op1;
    private final longword op2;
    private final longword[] registers; //16 LWs
    private longword currentInstruction;
    private longword PC; //Program Counter defaults to 0.
    private longword space;
    private final memory memory;
    private int rx = 0;
    private int ry = 0;
    private longword instruction;
    private longword result;
    private longword register;
    private String[] instructions;


    /**
     * Constructor (WIP)
     *
     * @return
     * @throws Exception
     */
    public computer() {
        this.registers = new longword[16];
        for (int i = 0; i < 16; i++) {
            registers[i] = new longword();
        }
        this.rx++;
        this.ry++;
        this.bitHalt = new bit(0);
        this.bitLessGreat = new bit(0);
        this.bitEqual = new bit(0);
        this.PC = new longword();
        this.op1 = new longword();
        this.op2 = new longword();
        this.space = new longword();
        this.currentInstruction = new longword();
        this.memory = new memory();

        space.set(1020);
        currentInstruction.set(0);
        PC.set(0);
    }

    /**
     * Fetch method reads the next longword from memory using PC as the address.
     *
     * @return
     * @throws Exception
     */
    public void run() throws Exception {
        while (bitHalt.getValue() != 1) {
            currentInstruction = fetch();
            longword reg = decode(currentInstruction);
            longword ans = execute(currentInstruction);
            store(ans, reg);
        }
    }

    /**
     * Fetch method reads the next longword from memory using PC as the address.
     *
     * @return
     * @throws Exception
     */
    public longword fetch() throws Exception {
        longword increment = new longword();
        increment.set(2);
        currentInstruction.copy(memory.read(PC));

        PC = rippleAdder.add(PC, increment);
        return currentInstruction;
    }

    /**
     * Decode method shifts and masks values given from the currentInstruction.
     * Those values are from the registers, when received we can and prepare the ALU.
     *
     * @return lw2 . Decoded instruction
     */

    public longword decode() {
        return decode();
    }

    /**
     * Decode method shifts and masks values given from the currentInstruction.
     * Those values are from the registers, when received we can and prepare the ALU.
     *
     * @return lw2 . Decoded instruction
     */

    public longword decode(longword instruction) {
        longword result;
        this.instruction = instruction;

        longword lw1 = new longword(); //temp
        lw1 = instruction.rightShift(12);

        longword lw2 = new longword(); //mask
        lw2.set(15);

        lw1 = lw1.and(lw2);
        int x = lw1.getSigned();


        if (x == 0) {
            lw1.set(-1);
            result = lw1;
        } else if (x == 1) {
            int index = 0;
            lw1 = instruction.rightShift(8);
            lw1 = lw1.and(lw2);
            int register = lw1.getSigned();
            longword mask = new longword();

            while (index < 8) {
                mask.getBit(index).toggle();
                index++;
            }


            if (instruction.getBit(7).getValue() == 1) {
                lw1 = instruction.and(mask);

                for (int k = 8; k < 32; k++) {
                    lw1.getBit(k).toggle();
                }

              
                int toStore = lw1.getSigned();
                registers[register].set(toStore);
                lw1.set(-2);
                result = lw1;
            } else {
                lw1 = instruction.and(mask);
                int toStore = lw1.getSigned();
                registers[register].set(toStore);
                lw1.set(-2);
                result = lw1;
            }
        } else if (x == 2) {
            lw1.set(-3);
            result = lw1;
        } else if (x == 3) {
            lw1.set(-4);
            result = lw1;
        } else if (x == 4) {
            lw1.set(-5);
            result = lw1;
        } else if (x == 5) {
            lw1.set(-6);
            result = lw1;
        } else if (x == 6) {
            lw1.set(-7);
            result = lw1;
        }


        /**
         * ALU
         */
      
        else {
            lw1 = instruction.rightShift(8);
            lw1 = lw1.and(lw2);
            op1.set(registers[lw1.getSigned()].getSigned());
            lw1.set(0);

            lw1 = instruction.rightShift(4);
            lw1 = lw1.and(lw2);
            op2.set(registers[lw1.getSigned()].getSigned());
            lw1.set(0);
            lw1 = instruction.and(lw2);


            result = lw1;
        }

        return result;
    }

    /**
     * Execute is passed the ALU operation. Then does what is called by the OpCode and returns the result.
     *
     * @return
     */
    public longword execute() throws Exception {
        return execute();
    }

    /**
     * Execute is passed the ALU operation. Then does what is called by the OpCode and returns the result.
     *
     * @param
     * @return
     */
    public longword execute(longword opCode) throws Exception {
        longword result;
        bit[] operation = new bit[4];
        int track = 0;

        for (int i = 0; i < 4; i++) {
            operation[i] = opCode.getBit(15 - i);
        }

        longword lw1 = new longword();
        longword lw2 = new longword();
        lw2.set(15);


        if (operation[0].getValue() == 0 && operation[1].getValue() == 0 && operation[2].getValue() == 0 && operation[3].getValue() == 0) {
            lw1.set(-1);
            result = lw1;
            track++;
        } else if (operation[0].getValue() == 0 && operation[1].getValue() == 0 && operation[2].getValue() == 0 && operation[3].getValue() == 1) {
            lw1.set(-2);
            result = lw1;
            track++;
        } else if (operation[0].getValue() == 0 && operation[1].getValue() == 0 && operation[2].getValue() == 1 && operation[3].getValue() == 0) {
            longword temp = new longword();
            temp = opCode.and(lw2);
            track++;
            if (temp.getSigned() == 0) {
                for (int i = 0; i < registers.length; i++) {
                    System.out.println("R" + i + ": " + registers[i].getSigned());
                }
            } else if (temp.getSigned() == 1) {
                longword mem = new longword();
                longword address = new longword();
                track++;
                for (int i = 0; i < 256; i++) {
                    address.set(i * 4);
                    mem = memory.read(address);
                    if ((i * 4) + 3 > 99) {
                        System.out.println(((i * 4) + 3) + "-" + (i * 4) + ": \t" + mem.toString());
                        track++;
                    } else
                        System.out.println(((i * 4) + 3) + "-" + (i * 4) + ": \t\t" + mem.toString());
                    track++;
                }
            }
            lw1.set(-3);
            result = lw1;
        } else if (operation[0].getValue() == 0 && operation[1].getValue() == 0 && operation[2].getValue() == 1 && operation[3].getValue() == 1) {
            longword newAddress = new longword();
            for (int i = 0; i < 12; i++) {
                newAddress.getBit(i).set(opCode.getBit(i).getValue());
                track++;
            }
            PC.set(newAddress.getSigned());
            lw1.set(-4);
            result = lw1;
        } else if (operation[0].getValue() == 0 && operation[1].getValue() == 1 && operation[2].getValue() == 0 && operation[3].getValue() == 0) {
            longword lwX = new longword();
            longword lwY = new longword();
            for (int i = 0; i < 8; i++) {
                if (i > 3) {
                    lwX.setBit(i - 4, opCode.getBit(i));track++;
                } else
                    lwY.setBit(i, opCode.getBit(i));
            }
            bit[] sub1 = {new bit(1), new bit(1), new bit(1), new bit(1)};
            int xN = lwX.getSigned();
            int xY = lwY.getSigned();
            lw1 = ALU.doOp(sub1, registers[xN], registers[xY]);

            if (lw1.getSigned() > 0) {
                this.bitLessGreat.set();
                this.bitEqual.clear();
            } else if (lw1.getSigned() < 0) {
                this.bitLessGreat.clear();
                this.bitEqual.clear();
            } else {
                this.bitLessGreat.clear();
                this.bitEqual.set();
            }

            lw1.set(-5);
            result = lw1;
        } else if (operation[0].getValue() == 0 && operation[1].getValue() == 1 && operation[2].getValue() == 0 && operation[3].getValue() == 1) {

            if (this.bitLessGreat.getValue() == opCode.getBit(11).getValue()
                    && this.bitEqual.getValue() == opCode.getBit(10).getValue()) {
                lw1.set(1);
                result = lw1;
            } else if (this.bitLessGreat.getValue() != opCode.getBit(11).getValue() && this.bitEqual.getValue() == 1
                    && opCode.getBit(10).getValue() == 1) {
                lw1.set(1);
                result = lw1;
            } else if (this.bitLessGreat.getValue() != opCode.getBit(11).getValue()) {
                lw1.set(1);
                result = lw1;
            } else {
                lw1.set(0);
                result = lw1;
            }
        } else if (operation[0].getValue() == 0 && operation[1].getValue() == 1 && operation[2].getValue() == 1 && operation[3].getValue() == 0) {

            longword lwMASK = new longword();
            lwMASK.set(1023);


            longword lw3 = new longword();
            lw3 = opCode.and(lw3);
            int register = lw3.getSigned();


            longword offSet = new longword();
            offSet.set(4);


            lw1.set(-7);

            if (opCode.getBit(11).getValue() == 0 && opCode.getBit(10).getValue() == 0) {
                memory.write(space, registers[register]);
                space = rippleAdder.subtract(space, offSet);
            } else if (opCode.getBit(11).getValue() == 0 && opCode.getBit(10).getValue() == 1) {

                longword clear = new longword();

//                if (space.getSigned() < 1020) {
//                    space = rippleAdder.add(space, offSet);
//                    registers[register].set(memory.read(space).getSigned());
//                    memory.write(space, clear);
//                } else
//                    System.out.println("End of Stack, Nothing to Pop!");

            } else if (opCode.getBit(11).getValue() == 1 && opCode.getBit(10).getValue() == 0) {
                memory.write(space, PC);
                space = rippleAdder.subtract(space, offSet);
                PC = opCode.and(lwMASK);
            } else if (opCode.getBit(11).getValue() == 1 && opCode.getBit(10).getValue() == 1) {
                space = rippleAdder.add(space, offSet);
                PC = memory.read(space);
            }
            result = lw1;
        } else {
            lw1 = ALU.doOp(operation, op1, op2);
            result = lw1;
        }
        System.out.println("track#" + track);
        return result;
    }




    /**
     * Copies value from the result longword into 1 of the 16 registers, indicated by the instruction.
     *
     * @param result
     * @param register
     */
    public void store(longword result, longword register) {
        this.result = result;
        this.register = register;
        if (result.getSigned() == -1 && register.getSigned() == -1) {
            bitHalt.set();
        }

        else if (result.getSigned() == -2 && register.getSigned() == -2) {
        } else if (result.getSigned() == -3 && register.getSigned() == -3) {
        } else if (result.getSigned() == -4 && register.getSigned() == -4) {
        } else if (result.getSigned() == -5 && register.getSigned() == -5) {
        }

        else if (register.getSigned() == -6) {
            if (result.getSigned() == 1) {
                longword incrementbytwo = new longword();
                incrementbytwo.set(2);
                PC = rippleAdder.subtract(PC, incrementbytwo);
                longword offSet = new longword();
                if (this.currentInstruction.getBit(9).getValue() == 1) {
                    for (int i = 0; i < 32; i++) {
                        if (i < 9) {
                            offSet.setBit(i, this.currentInstruction.getBit(i));
                        }
                        else
                            offSet.getBit(i).set();
                    }
                }


                else {
                    for (int i = 0; i < 9; i++) {
                        offSet.setBit(i, this.currentInstruction.getBit(i));
                    }
                }


                PC = rippleAdder.add(PC, offSet);
            }

        }

        else if (result.getSigned() == -7 && register.getSigned() == -7) {

        }

        else registers[register.getSigned()].set(result.getSigned());
    }



    /**
     * Copies value from the result longword into 1 of the 16 registers, indicated by the instruction.
     *
     */
    public void preload(String... instructions) throws Exception {
        this.instructions = instructions;
        longword lw1 = new longword();
        longword address = new longword();
        String instruction = "";
        for (int k = 0; k < instructions.length; k++) {
            instruction = instructions[k].substring(0, 4) + instructions[k].substring(5, 9) + instructions[k].substring(10, 14) + instructions[k].substring(15);
            address.set(k * 2);
            for (int i = 0; i < 16; i++) {
                if (instruction.charAt(i) == '0') {
                    lw1.getBit(15 - i).clear();
                } else {
                    lw1.getBit(15 - i).set();
                }
            }
            memory.write(address, lw1);
        }
    }


}
