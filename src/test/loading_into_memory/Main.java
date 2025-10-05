package src.test.loading_into_memory;

import src.emulator.Memory;

public class Main {
    public static void main(String[] args) {
        Memory mem = new Memory();
        mem.load_program("src/test/loading_into_memory/ROM.bin");

    }
}
