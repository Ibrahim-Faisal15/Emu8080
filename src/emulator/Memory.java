package src.emulator;
import src.custom_exceptions.ExceededTotalStorage;
import src.custom_exceptions.ROMWriteException;

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


}
