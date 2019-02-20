# Basic-Disassembler
A basic disassembler allow user to pass in an array of 32-bits instruction set (in hexadecimal) and output the instruction and numerical registers


# THE BASICS

A partial disassembler for MIPS instructions. 

That is, your input will be the 32-bit machine instructions that a compiler or assembler produces. 
This program then figures out what the original source instructions were that created those 32-bit machine instructions and outputs them. The possible source instructions that you must be able to disassemble are: add, sub, and, or, slt, lw, sw, beq, bne. Ignore all other MIPS instructions.

The test machine instructions are: 0x032BA020, 0x8CE90014, 0x12A90003, 0x022DA822, 0xADB30020, 0x02697824, 0xAE8FFFF4, 0x018C6020, 0x02A4A825, 0x158FFFF7, 0x8ECDFFF0
