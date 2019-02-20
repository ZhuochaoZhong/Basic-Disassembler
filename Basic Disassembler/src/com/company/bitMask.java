package com.company;

public class bitMask {

    private int opMask;
    private int rsMask;
    private int rtMask;
    private int rdMask;
    //private int shamtMask = 0x000007c0;
    private int funcMask;
    private int offsetMask;

    public bitMask() {
        opMask = 0xfc000000;
        rsMask = 0x03e00000;
        rtMask = 0x001f0000;
        rdMask = 0x0000f800;
        funcMask = 0x0000003f;
        offsetMask = 0x0000ffff;
    }

    public int getOpMask() {
        return opMask;
    }

    public int getRsMask() {
        return rsMask;
    }

    public int getRtMask() {
        return rtMask;
    }

    public int getRdMask() {
        return rdMask;
    }

    public int getFuncMask() {
        return funcMask;
    }

    public int getOffsetMask() {
        return offsetMask;
    }
}
