package src.instructionSet;

public class i8080_OP_Code {
    public void checkInstruction(int opcode, int current_memAddress){

        switch (opcode) {
            case 0x00:
                System.out.println("Instruction NOP is executed at address: " + current_memAddress);
                break;
            case 1:
                break;

        }
//        System.out.println("HELLO");

    }
}
