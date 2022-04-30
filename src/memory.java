package src;

/**
 *This is the memory class. It holds 1024 bytes, or 8192 bits.
 * Toussaint Turnier
 * Version 1.0
 */
public class memory {

    private bit[] mem;

    /**
     *
     */
    public memory() {
        mem = new bit[8192]; //Creation of Memory
        //Make every bit in memory equal to 0
        for (int i = 0; i < 8192; i++) {
            bit newBit = new bit();
            newBit.set(0);
            mem[i] = newBit;
        }
    }

    /**
     *The address method. Takes in a longword and reads it back
     * @param address
     * @return
     */
    public longword read(longword address) throws Exception{
        int byteStart = address.getSigned() * 8;
        int j = 0;

        longword lw1 = new longword();
        bit bit1 = new bit();


        for (int i = byteStart; i < byteStart+32; i++) {
            int value = mem[i].getValue();
            bit1 = lw1.getBit(j);
            bit1.set(value);
            j++;
        }
        return lw1;
    }

    /**
     *The write method. Takes in a address to write the value given.
     * @param address
     * @param value
     */
    public void write(longword address, longword value) throws Exception {
        int address1 = address.getSigned();
        int byteStart = address1 * 8;
        int j = 0;
        bit bit1 = new bit();

        if (address1 >= 1021 || address1 < 0) {
            System.out.println("Memory exception: Cannot reach(write)" + address1);
            throw new Exception();
        }
        else {
            for (int i = byteStart; i < (byteStart + 32); i++) {
                bit1 = value.getBit(j);
                int v = bit1.getValue();
                mem[i].set(v);
                j++;
            }
        }
    }
}
