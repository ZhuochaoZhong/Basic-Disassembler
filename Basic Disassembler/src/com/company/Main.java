package com.company;

public class Main {

    public static void main(String[] args) {

        Main me = new Main();

        me.runDisassembler();
    }

    private void runDisassembler() {

        int[] projectInstructionSet = {
                0x032ba020, 0x8ce90014, 0x12a90003, 0x022da822, 0xadb30020,
                0x02697824, 0xae8ffff4, 0x018c6020, 0x02a4a825, 0x158ffff7,
                0x8ecdfff0
        };
        System.out.println("\nDisassembling Project 1 Array of Instruction Sets...");

        Disassembler disassembler = new Disassembler(projectInstructionSet, 0x9a040);

        disassembler.disassemble();

    }
}
