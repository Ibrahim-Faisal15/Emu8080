package src.test.instructionSet_test;

import src.emulator.CPU;
import src.emulator.Memory;

public class Main {
    public static void main(String[] args) {
        Memory memory = new Memory();
        memory.load_program("src/test/instructionSet_test/Test.bin");
        CPU cpu = new CPU();
        cpu.run("src/test/instructionSet_test/Test.bin");


    }
}
