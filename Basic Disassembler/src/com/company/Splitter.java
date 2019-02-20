package com.company;

public class Splitter {

    private int instruction;

    private int opCode;

    private int reg1;

    private int reg2;

    private int reg3;

    //private int shamt;

    private int func;

    private short offset;

    /* Using the bitMask to separate each chunk of instruction
    *   (opcode, three register operands, function and offset)
    *   and convert each them into an int
    *   Those converted int will be passed to the Disassembler for displaying the output.
    */
    public Splitter(int instruction) {

        bitMask mask = new bitMask();

        this.instruction = instruction;

        this.opCode = (instruction & mask.getOpMask()) >>> 26;

        this.reg1 = (instruction & mask.getRsMask()) >>> 21;

        this.reg2 = (instruction & mask.getRtMask()) >>> 16;

        this.reg3 = (instruction & mask.getRdMask()) >>> 11;

        this.func = (instruction & mask.getFuncMask());

        this.offset = (short) (instruction & mask.getOffsetMask());
    }

    public int getOpCode() {
        return opCode;
    }

    public int getReg3() {
        return reg3;
    }

    public int getReg1() {
        return reg1;
    }

    public int getReg2() {
        return reg2;
    }

    public int getFunc() {
        return func;
    }

    public short getOffset() {
        return offset;
    }
}
