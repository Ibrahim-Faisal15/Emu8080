package src.emulator;

import src.instructionSet.i8080_OP_Code;

public class CPU {

    //other classes
    private final Memory memory = new Memory();
    private final i8080_OP_Code decoder = new i8080_OP_Code();

    //registers
    int A,B,C,D,E,H,L;

    //pair-registers
    private   int PC = 0x0000;
    private   int SP;

    //operational code
    int opcode;

    //flags
    private   boolean sign;
    private   boolean zero;
    private   boolean parity;
    private   boolean carry;
    private   boolean aux_carry;

    //loop state
    private boolean running = true;

    int i = 1;

    public void run(String program){
        //load program into memory
        memory.load_program(program);

        while(PC < memory.getProgram_length()){

            //fetch operation
            opcode = memory.read(PC);

            //decode operation
            decoder.checkInstruction(opcode,PC);
            PC++;

            i++;

            if(i == 20){
                running = false;
            }
        }
    }



}
