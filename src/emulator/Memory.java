package src.emulator;
import src.custom_exceptions.ExceededTotalStorage;
import src.custom_exceptions.ROMWriteException;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Memory {
    /*

    IDEA WOULD BE THAT, THAT ARRAY WOULD BE PARTITIONED INTO TWO SEGMENTS, OUT
    OF WHICH ONE SEGMENT, WITH THE HIGHER DATA CAPACITY WOULD BE ROM
    WHEREAS THE SEGMENT WITH LOWER DATA CAPACITY WOULD BE RAM.

    ROM MEMORY CAPACITY  = 8KB
    RAM MEMORY CAPACITY = REST AFTER  8KB

    */

    private final byte[] memory =  new byte[65536];

    //methods
    public byte read(int address){
        //FETCH BYTE STORED IN THE ADDRESS; RAM AND ROM BOTH
        byte fetch_memory_location = memory[address];
        return fetch_memory_location;
    }

    public void write(int address, byte data) throws ROMWriteException, ExceededTotalStorage {

        //TAKE THE DATA AND STORE IT IN THE ADDRESS
        //ONLY FOR RAM
        //CHECK IF IT IS RAM OR ROM

        if (address > memory.length){
            throw new ExceededTotalStorage("Can not exceed total memory");
        }

        if(address >= 8191){
            throw new ROMWriteException("Can not write into ROM");
        }

        memory[address] = data;
    }

    public void load_program(String file_path){
        //reading data drom a .bin file and loading it into a temp array form whcih we'll load it up in the memory
        try{
            Path path = Paths.get(file_path);
            byte[] program_data = Files.readAllBytes(path);
            System.out.println("Loaded bytes: " + program_data.length);
            int length = program_data.length;
            for (int i = 0; i < length; i++) {
                memory[i] = program_data[i];
                System.out.println(memory[i]);
            }


        }
        catch (IOException e){
            System.out.println("Error" + e.getMessage());
        }
    }




}
