package src;
import java.util.ArrayList;
import java.lang.Math.*;
/**
 *  Assembler. Commands:
 *  Move R1 Value Add R1 R2 R3 Subtract R1 R2 R3 Multiply R1 R2 R3
 *  And R1 R2 R3 Or R1 R2 R3 Xor R1 R2 R3 Not R1 R2 R3 LS R1 R2 R3 RS R1 R2 R3
 *  Interrupt 0 Interrupt 1
 *  Halt
 *  Jump Value
 *  Branch Conditional Address
 *  CALL
 *  PUSH
 *  POP
 * @Author Toussaint Turnier
 * @Version 1.0
 * #TODO FIX JUMP, FIX RANDOM MULTIPLY GLITCH, FIX STACKOVERFLOW ON READING 0111 AFTER A MOVE
 */
public class assembler extends computer {
    private static String[] commands;

    /**
     * Empty Consturctor for Testing
     */
    public assembler() {
    }

    /**
     * @throws Exception
     */
    @Override
    public void run() throws Exception {
        super.run();
    }

    @Override
    public longword fetch() throws Exception {
        return super.fetch();
    }

    @Override
    public longword decode(longword instruction) {
        return super.decode(instruction);
    }

    @Override
    public longword execute(longword opCode) throws Exception {
        return super.execute(opCode);
    }

    @Override
    public void store(longword result, longword register) {
        super.store(result, register);
    }

    @Override
    public void preload(String[] instructions) throws Exception {
        super.preload(instructions);
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "assembler{}";
    }

    /**
     * @return
     * @throws Exception
     */
    public static String[] assemble() throws Exception {
        return assemble();
    }

    /**
     * @param commands
     * @return
     * @throws Exception
     */
    public static String[] assemble(String... commands) throws Exception {
        assembler.commands = commands;
        ArrayList<String> code = new ArrayList<String>();
        String[] assembledCode = new String[commands.length];
        String[] ky;
        String[] s;
        int v = 0;

        for (int j = 0; j < commands.length; j++) {
            s = commands[j].split(" ");

            if (s[0].equalsIgnoreCase("Test Function")) {
                longword lw1 = new longword();


                code.add(" ");
                assembledCode[0] = "0000 ";
                int value = Integer.parseInt(s[1].substring(1));

                lw1.set(value);
                for (int i = 0; i < 4; i++) {
                    code.clear();
                    assembledCode[0] += "" + lw1.getBit(3 - i).getValue();
                    v++;
                }
            }


                for (int k = 0; k < commands.length; k++) {
                    ky = commands[k].split(" ");

                    if (ky[0].equalsIgnoreCase("Move")) {
                        code.add(" ");
                        assembledCode[k] = "0001 ";
                        int value = Integer.parseInt(ky[1].substring(1));
                        longword lw1 = new longword();
                        lw1.set(value);
                        for (int i = 0; i < 4; i++) {
                            code.clear();
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                            v++;
                        }
                        code.clone();
                        assembledCode[k] += " ";
                        value = Integer.parseInt(ky[2]);
                        lw1 = new longword();
                        lw1.set(value);
                        for (int i = 0; i < 8; i++) {
                            assembledCode[k] += "" + lw1.getBit(7 - i).getValue();
                            if (i == 3) {
                                assembledCode[k] += " ";
                                v++;
                                code.clear();
                            }
                        }
                    } else if (ky[0].equalsIgnoreCase("Interrupt")) {
                        if (ky[1].equalsIgnoreCase("0")) {
                            code.add(" ");
                            assembledCode[k] = "0010 0000 0000 0000";
                        } else {
                            code.add(" ");
                            assembledCode[k] = "0010 0000 0000 0001";
                        }
                    } else if (ky[0].equalsIgnoreCase("Halt")) {
                        code.add(" ");
                        assembledCode[k] = "0000 0000 0000 0000";
                    } else if (ky[0].equalsIgnoreCase("Jump")) {
                        longword lw1 = new longword();


                        code.add(" ");
                        assembledCode[k] = "0011 ";
                        int value = Integer.parseInt(ky[1]);

                        lw1.set(value);
                        for (int i = 0; i < 12; i++) {
                            assembledCode[k] += lw1.getBit(11 - i).getValue();
                            if (i == 3) {
                                assembledCode[k] += " ";
                                v++;
                                code.clear();
                            }
                            if (i == 7) {
                                assembledCode[k] += " ";
                                v++;
                                code.clear();
                            }
                        }

                    }


                    else if (ky[0].equalsIgnoreCase("compare")) {
                        longword lw1 = new longword();


                        code.add(" ");
                        assembledCode[k] = "0100 0000 ";
                        int register = Integer.parseInt(ky[1].substring(1));

                        lw1.set(register);
                        for (int i = 0; i < 4; i++) {
                            v++;
                            code.clear();
                            assembledCode[k] += lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[2].substring(1));
                        lw1.set(register);
                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += lw1.getBit(3 - i).getValue();
                        }
                    }


                    else if (ky[0].equalsIgnoreCase("subtract")) {
                        longword lw1 = new longword();


                        v--;
                        code.clear();
                        assembledCode[k] = "1111 ";
                        int register = Integer.parseInt(ky[1].substring(1));

                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            v++;
                            code.clear();
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[2].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            v++;
                            code.clear();
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[3].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            v++;
                            code.clear();
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }


                    }


                    else if (ky[0].equalsIgnoreCase("add")) {
                        longword lw1 = new longword();


                        v++;
                        code.clear();
                        assembledCode[k] = "1110 ";
                        int register = Integer.parseInt(ky[1].substring(1));

                        lw1.set(register);
                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[2].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";

                        register = Integer.parseInt(ky[3].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                    }


                    else if (ky[0].equalsIgnoreCase("not")) {
                        longword lw1 = new longword();


                        v++;
                        code.clear();
                        assembledCode[k] = "1011 ";
                        int register = Integer.parseInt(ky[1].substring(1));

                        lw1.set(register);
                        for (int i = 0; i < 4; i++) {
                            v++;
                            code.clear();
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[2].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            v++;
                            code.clear();
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[3].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            v++;
                            code.clear();
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                    }


                    else if (ky[0].equalsIgnoreCase("multiply")) {
                        longword lw1 = new longword();


                        v++;
                        code.clear();
                        assembledCode[k] = "0111 ";
                        int register = Integer.parseInt(ky[1].substring(1));


                        lw1.set(register);
                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[2].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[3].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            v++;
                            code.clear();
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                    }


                    else if (ky[0].equalsIgnoreCase("and")) {
                        longword lw1 = new longword();


                        assembledCode[k] = "1000 ";
                        v++;
                        code.clear();
                        int register = Integer.parseInt(ky[1].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[2].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[3].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                    }


                    else if (ky[0].equalsIgnoreCase("or")) {
                        longword lw1 = new longword();
                        assembledCode[k] = "1001 ";
                        int register = Integer.parseInt(ky[1].substring(1));

                        lw1.set(register);
                        for (int i = 0; i < 4; i++) {
                            v++;
                            code.clear();
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[2].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[3].substring(1));
                        lw1.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + lw1.getBit(3 - i).getValue();
                        }
                    }


                    else if (ky[0].equalsIgnoreCase("Xor")) {
                        assembledCode[k] = "1010 ";
                        int register = Integer.parseInt(ky[1].substring(1));
                        longword temp = new longword();
                        temp.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + temp.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[2].substring(1));
                        temp.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + temp.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[3].substring(1));
                        temp.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + temp.getBit(3 - i).getValue();
                        }
                    } else if (ky[0].equalsIgnoreCase("RS")) {
                        assembledCode[k] = "1101 ";
                        int register = Integer.parseInt(ky[1].substring(1));
                        longword temp = new longword();
                        temp.set(register);

                        for (int i = 0; i <= 4; i++) {
                            assembledCode[k] += "" + temp.getBit(3 - i).getValue();
                        }


                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[2].substring(1));
                        temp.set(register);

                        for (int i = 0; i <= 4; i++) {
                            assembledCode[k] += "" + temp.getBit(3 - i).getValue();
                        }


                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[3].substring(1));
                        temp.set(register);

                        for (int i = 0; i <= 4; i++) {
                            assembledCode[k] += "" + temp.getBit(3 - i).getValue();
                        }
//                for (int i = 0; i <= 4; i++) {
//                    assembledCode[k] += "" + temp.getBit(4 - i).getValue();
//                }
//                for (int i = 0; i > 4; i++) {
//                    assembledCode[k] += "" + temp.getBit(5 - i).getValue();
//                }
                    } else if (ky[0].equalsIgnoreCase("LS")) {
                        assembledCode[k] = "1100 ";
                        int register = Integer.parseInt(ky[1].substring(1));
                        longword temp = new longword();
                        temp.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + temp.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[2].substring(1));
                        temp.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + temp.getBit(3 - i).getValue();
                        }
                        assembledCode[k] += " ";
                        register = Integer.parseInt(ky[3].substring(1));
                        temp.set(register);

                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += "" + temp.getBit(3 - i).getValue();
                        }
                    } else if (ky[0].equalsIgnoreCase("BranchIfGreaterThan")) {
                        assembledCode[k] = "0101 10";
                        int offSet = Integer.parseInt(ky[1]);
                        if (offSet < 0) {
                            assembledCode[k] += "1";
                        } else
                            assembledCode[k] += "0";
                        longword temp = new longword();
                        temp.set(offSet);
                        for (int i = 8; i > -1; i--) {
                            if (i == 7) {
                                assembledCode[k] += " ";
                            } else if (i == 3) {
                                assembledCode[k] += " ";
                            }
                            assembledCode[k] += temp.getBit(i).getValue();
                        }
                    } else if (ky[0].equalsIgnoreCase("BranchIfGreaterThanOrEqual")) {
                        assembledCode[k] = "0101 11";
                        int offSet = Integer.parseInt(ky[1]);
                        if (offSet < 0) {
                            assembledCode[k] += "1";
                        } else
                            assembledCode[k] += "0";
                        longword temp = new longword();
                        temp.set(offSet);

                        for (int i = 8; i > -1; i--) {
                            if (i == 7) {
                                assembledCode[k] += " ";
                            } else if (i == 3) {
                                assembledCode[k] += " ";
                            }
                            assembledCode[k] += temp.getBit(i).getValue();
                        }
                    }

                    else if (ky[0].equalsIgnoreCase("BranchIfNotEqual")) {
                        assembledCode[k] = "0101 00";
                        int mkoff = Integer.parseInt(ky[1]);
                        if (mkoff < 0) {
                            assembledCode[k] += "1";
                        } else
                            assembledCode[k] += "0";
                        longword temp = new longword();
                        temp.set(mkoff);
                        for (int i = 8; i > -1; i--) {
                            if (i == 7) {
                                assembledCode[k] += " ";
                            } else if (i == 3) {
                                assembledCode[k] += " ";
                            }
                            assembledCode[k] += temp.getBit(i).getValue();
                        }
                    }



                    else if (ky[0].equalsIgnoreCase("BranchIfEqual")) {
                        assembledCode[k] = "0101 01";
                        int offby = Integer.parseInt(ky[1]);
                        if (offby < 0) {
                            assembledCode[k] += "1";
                        } else
                            assembledCode[k] += "0";
                        longword temp = new longword();
                        temp.set(offby);
                        for (int i = 8; i > -1; i--) {
                            if (i == 7) {
                                assembledCode[k] += " ";
                            } else if (i == 3) {
                                assembledCode[k] += " ";
                            }
                            assembledCode[k] += temp.getBit(i).getValue();
                        }
                    }





/**
 * Call Push Pop Return
 * #TODO Fully test
 */
                    //Call, Push and Pop. Not fully tested.
             else if (ky[0].equalsIgnoreCase("Call")) {
                        int address = Integer.parseInt(ky[1]);
                        longword bump = new longword();
                        bump.set(address);
                        assembledCode[k] = "0110 10";
                        for (int i = 0; i < 10; i++) {
                            if (i == 2) {
                                assembledCode[k] += " ";
                            } else if (i == 6) {
                                assembledCode[k] += " ";
                            }
                            assembledCode[k] += bump.getBit(9 - i);
                        }
                    }
            else if (ky[0].equalsIgnoreCase("Push")) {
                int reg = Integer.parseInt(ky[1].substring(1));
                assembledCode[k] = "0110 0000 0000 ";
                longword temp = new longword();
                temp.set(reg);
                for (int i = 0; i < 4; i++) {
                    assembledCode[k] += temp.getBit(3 - i).getValue();
                }

            }
                    else if (ky[0].equalsIgnoreCase("Pop")) {
                        int regxy = Integer.parseInt(ky[1].substring(1));
                        assembledCode[k] = "0110 0100 0000 ";
                        longword temp = new longword();
                        temp.set(regxy);
                        for (int i = 0; i < 4; i++) {
                            assembledCode[k] += temp.getBit(3 - i).getValue();
                        }
                    }



//
//
//

//
            else if (ky[0].equalsIgnoreCase("Return")) {
                assembledCode[k] = "0110 1100 0000 0000";
            }
        }
                }
        return assembledCode;
    }
    }


