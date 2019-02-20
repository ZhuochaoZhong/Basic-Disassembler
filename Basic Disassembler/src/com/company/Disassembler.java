package com.company;

import java.util.HashMap;
import java.util.Map;

public class Disassembler {

    private int[] instructionSet;
    private int currAddress;
    private Splitter splitter;

    private String opCode;
    private String reg1;
    private String reg2;
    private String reg3;
    private String func;
    private short offset;

    // Mapping the instruction with its function code/opcode
    private Map<Integer, String> opCodeMap = new HashMap<>() {{
        put(0x20, "add");
        put(0x22, "sub");
        put(0x24, "and");
        put(0x25, "or");
        put(0x2a, "slt");
        put(0x23, "lw");
        put(0x2b, "sw");
        put(4, "beq");
        put(5, "bne");
    }};


    public Disassembler(int[] instructions, int startingAddress) {

        this.instructionSet = instructions;
        this.currAddress = startingAddress;
    }

    public void disassemble() {


        for (int instruction : instructionSet) {

            this.splitter = new Splitter(instruction);

            // Converting the first, second and third registers to base 10 for output
            this.reg1 = Integer.toString(this.splitter.getReg1(), 10);
            this.reg2 = Integer.toString(this.splitter.getReg2(), 10);
            this.reg3 = Integer.toString(this.splitter.getReg3(), 10);

            // Converting the function code/opcode using the opCodeMap for output
            this.opCode = opCodeMap.get(this.splitter.getOpCode());
            this.func = opCodeMap.get(this.splitter.getFunc());

            // Converting the offset value for displaying the address for output
            this.offset = Short.valueOf(Short.toString(this.splitter.getOffset()), 10);

            System.out.println(disassembleOutput());
        }
        System.out.println("Disassemble Finished");
    }

    public String disassembleOutput() {

        String rtn = "";

        if (splitter.getOpCode() == 0) {
            // this is a R Format splitter for OPCODE = 0
            rtn += Integer.toHexString(currAddress)
                    + " " + func + " $" + reg3 + ", $"
                    + reg1 + ", $" + reg2;



        } else if (opCode.equals("lw") || opCode.equals("sw")) {
            // this is a I Format splitter for lw
            rtn += Integer.toHexString(currAddress)
                    + " " + opCode + " $" + reg2 + ", "
                    + offset + "($" + reg1 + ")";

        } else if (opCode.equals("beq") || opCode.equals("bne")) {
            // this is a I format splitter for beq or bne
            int decompressedOffset = this.offset << 2;
            rtn += Integer.toHexString(currAddress)
                    + " " + opCode + " $" + reg1 + ", $" + reg2
                    + ", address " + Integer.toHexString(currAddress + decompressedOffset + 4);

        } else {
            return "Instructions have not been specified";
        }
        // program counter that automatically increase address by 4 after each instruction except branches
        currAddress += 4;
        return rtn;
    }
}
