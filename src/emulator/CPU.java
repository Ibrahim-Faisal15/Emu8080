package src.emulator;

public class CPU {
    //registers
    byte A,B,C,D,E,H,L;

    //pair-registers
    short PC, SP;

    //flags
    boolean sign;
    boolean zero;
    boolean parity;
    boolean carry;
    boolean aux_carry;

}
