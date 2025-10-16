package src.emulator;


public class CPU {

	//other classes
	private final Memory memory = new Memory();

	//registers
	int A = 2;
	int B, C, D, E, H, L;
	//operational code
	int opcode;
	//pair-registers
	private int PC = 0x0000;
	private int SP;
	//flags
	private boolean sign;
	private boolean zero;
	private boolean parity;
	private boolean carry;
	private boolean aux_carry;


	//methods for combining H and L registers into a single identity - 16 bytes
	private int getHL() {
		return (H << 8) | L;
	}

	//prams value accepts any 16 byte number aka the value generated from the above functions
	private void setHL(int value) {
		H = (value >> 8) & 0xFF;
		L = value & 0xFF;
	}


	public void run(String program) {
		//load program into memory
		memory.load_program(program);

		while (PC < memory.getProgram_length()) {
//            System.out.println("program length " + memory.getProgram_length() );

			//fetch operation
			opcode = memory.read(PC);

			//decode operation
			this.checkInstruction(opcode, PC);

		}
	}

	public void checkInstruction(int opcode, int current_memAddress) {

		switch (opcode) {
			case 0x00:
				System.out.println("Instruction NOP is executed at address: " + current_memAddress);
				this.PC++;
				break;
			//MOV instructions
			case 0x7F:
				System.out.printf("Moving data of register A (%d) to register A (%d) A->A \n", this.A, this.A);
				this.A = this.A;
				System.out.printf("Moved data of register A (%d) to register A (%d) A->A successfully \n", this.A, this.A);
				this.PC++;
//                System.out.println("PC: " + PC);
				break;
			case 0x78:
				System.out.printf("Moving data of register B (%d) to register A (%d) B->A \n", this.B, this.A);
				this.A = this.B;
				System.out.printf("Moved data of register B (%d) to register A (%d) B->A successfully \n", this.B, this.A);
				this.PC++;
				break;
			case 0x79:
				System.out.printf("Moving data of register C (%d) to register A (%d) C->A \n", this.C, this.A);
				this.A = this.C;
				System.out.printf("Moved data of register C (%d) to register A (%d) C->A successfully \n", this.C, this.A);
				this.PC++;
				break;
			case 0x7A:
				System.out.printf("Moving data of register D (%d) to register A (%d) D->A \n", this.D, this.A);
				this.A = this.D;
				System.out.printf("Moved data of register D (%d) to register A (%d) D->A successfully \n", this.D, this.A);
				this.PC++;
				break;
			case 0x7B:
				System.out.printf("Moving data of register E (%d) to register A (%d) E->A \n", this.E, this.A);
				this.A = this.E;
				System.out.printf("Moved data of register E (%d) to register A (%d) E->A successfully \n", this.E, this.A);
				this.PC++;
				break;
			case 0x7C:
				System.out.printf("Moving data of register H (%d) to register A (%d) H->A \n", this.H, this.A);
				this.A = this.H;
				System.out.printf("Moved data of register H (%d) to register A (%d) H->A successfully \n", this.H, this.A);
				this.PC++;
				break;
			case 0x7D:
				System.out.printf("Moving data of register L (%d) to register A (%d) L->A \n", this.L, this.A);
				this.A = this.L;
				System.out.printf("Moved data of register L (%d) to register A (%d) L->A successfully \n", this.L, this.A);
				this.PC++;
				break;
			case 0x7E:
				//M -> HL
				System.out.printf("Moving data of register M (HL) (%d) to register A (%d) M(HL)->A \n", this.getHL(), this.A);
				this.A = memory.read(getHL());
				System.out.printf("Moved data of register M (HL) (%d) to register A (%d) M(HL)->A successfully \n", this.getHL(), this.A);
				this.PC++;
				break;


			case 0x47:
				System.out.printf("Moving data of register A (%d) to register B (%d) B->A \n", this.A, this.B);
				this.B = this.A;
				System.out.printf("Moved data of register A (%d) to register B (%d) B->A successfully \n", this.A, this.B);
				this.PC++;
				break;
			case 0x40:
				System.out.printf("Moving data of register B (%d) to register B (%d) B->B \n", this.B, this.B);
				this.B = this.B;
				System.out.printf("Moved data of register B (%d) to register B (%d) B->B successfully \n", this.B, this.B);
				this.PC++;
				break;
			case 0x41:
				System.out.printf("Moving data of register C (%d) to register B (%d) C->B \n", this.C, this.B);
				this.C = this.B;
				System.out.printf("Moved data of register C (%d) to register B (%d) C->B successfully \n", this.C, this.B);
				this.PC++;
				break;
			case 0x42:
				System.out.printf("Moving data of register D (%d) to register B (%d) D->B \n", this.D, this.B);
				this.D = this.B;
				System.out.printf("Moved data of register D (%d) to register B (%d) D->B successfully \n", this.D, this.B);
				this.PC++;
				break;
			case 0x43:
				System.out.printf("Moving data of register E (%d) to register B (%d) E->B \n", this.E, this.B);
				this.E = this.B;
				System.out.printf("Moved data of register E (%d) to register B (%d) E->B successfully \n", this.E, this.B);
				this.PC++;
				break;
			case 0x44:
				System.out.printf("Moving data of register H (%d) to register B (%d) H->B \n", this.H, this.B);
				this.H = this.B;
				System.out.printf("Moved data of register H (%d) to register B (%d) H->B successfully \n", this.H, this.B);
				this.PC++;
				break;
			case 0x45:
				System.out.printf("Moving data of register L (%d) to register B (%d) L->B \n", this.L, this.B);
				this.L = this.B;
				System.out.printf("Moved data of register L (%d) to register B (%d) L->B successfully \n", this.L, this.B);
				this.PC++;
				break;
			case 0x46:
				//M -> HL
				System.out.printf("Moving data of register M (HL) (%d) to register B (%d) M (HL)->B \n", this.getHL(), this.B);
				this.B = memory.read(getHL());
				System.out.printf("Moved data of register M (HL) (%d) to register B (%d) M (HL)->B successfully \n", this.getHL(), this.B);
				this.PC++;
				break;


			case 0x4F:
				System.out.printf("Moving data of register A (%d) to register C (%d) A->C \n", this.A, this.C);
				this.C = this.A;
				System.out.printf("Moved data of register A (%d) to register C (%d) A->C successfully \n", this.A, this.C);
				this.PC++;
				break;
			case 0x48:
				System.out.printf("Moving data of register B (%d) to register C (%d) B->C \n", this.B, this.C);
				this.C = this.B;
				System.out.printf("Moved data of register B (%d) to register C (%d) B->C successfully \n", this.B, this.C);
				this.PC++;
				break;
			case 0x49:
				System.out.printf("Moving data of register C (%d) to register C (%d) C->C \n", this.C, this.C);
				this.C = this.C;
				System.out.printf("Moved data of register C (%d) to register C (%d) C->C successfully \n", this.C, this.C);
				this.PC++;
				break;
			case 0x4A:
				System.out.printf("Moving data of register D (%d) to register C (%d) D->C \n", this.D, this.C);
				this.C = this.D;
				System.out.printf("Moved data of register D (%d) to register C (%d) D->C successfully \n", this.D, this.C);
				this.PC++;
				break;
			case 0x4B:
				System.out.printf("Moving data of register E (%d) to register C (%d) E->C \n", this.E, this.C);
				this.C = this.E;
				System.out.printf("Moved data of register E (%d) to register C (%d) E->C successfully \n", this.E, this.C);
				this.PC++;
				break;
			case 0x4C:
				System.out.printf("Moving data of register H (%d) to register C (%d) H->C \n", this.H, this.C);
				this.C = this.H;
				System.out.printf("Moved data of register H (%d) to register C (%d) H->C successfully \n", this.H, this.C);
				this.PC++;
				break;
			case 0x4D:
				System.out.printf("Moving data of register L (%d) to register C (%d) L->C \n", this.L, this.C);
				this.C = this.L;
				System.out.printf("Moved data of register L (%d) to register C (%d) L->C successfully \n", this.L, this.C);
				this.PC++;
				break;
			case 0x4E:
				//M -> HL
				System.out.printf("Moving data of register M (HL) (%d) to register C (%d) M (HL)->C \n", this.getHL(), this.C);
				this.C = memory.read(getHL());
				System.out.printf("Moved data of register M (HL) (%d) to register C (%d) M (HL)->C successfully \n", this.getHL(), this.C);
				this.PC++;
				break;


			case 0x57:
				System.out.printf("Moving data of register A (%d) to register D (%d) A->D \n", this.A, this.D);
				this.D = this.A;
				System.out.printf("Moved data of register A (%d) to register D (%d) A->D successfully \n", this.A, this.D);
				this.PC++;
				break;
			case 0x50:
				System.out.printf("Moving data of register B (%d) to register D (%d) B->D \n", this.B, this.D);
				this.D = this.B;
				System.out.printf("Moved data of register B (%d) to register D (%d) B->D successfully \n", this.B, this.D);
				this.PC++;
				break;
			case 0x51:
				System.out.printf("Moving data of register C (%d) to register D (%d) C->D \n", this.C, this.D);
				this.D = this.C;
				System.out.printf("Moved data of register C (%d) to register D (%d) C->D successfully \n", this.C, this.D);
				this.PC++;
				break;
			case 0x52:
				System.out.printf("Moving data of register D (%d) to register D (%d) D->D \n", this.D, this.D);
				this.D = this.D;
				System.out.printf("Moved data of register D (%d) to register D (%d) D->D successfully \n", this.D, this.D);
				this.PC++;
				break;
			case 0x53:
				System.out.printf("Moving data of register E (%d) to register D (%d) E->D \n", this.E, this.D);
				this.D = this.E;
				System.out.printf("Moved data of register E (%d) to register D (%d) E->D successfully \n", this.E, this.D);
				this.PC++;
				break;
			case 0x54:
				System.out.printf("Moving data of register H (%d) to register D (%d) H->D \n", this.H, this.D);
				this.D = this.H;
				System.out.printf("Moved data of register H (%d) to register D (%d) H->D successfully \n", this.H, this.D);
				this.PC++;
				break;
			case 0x55:
				System.out.printf("Moving data of register L (%d) to register D (%d) L->D \n", this.L, this.D);
				this.D = this.L;
				System.out.printf("Moved data of register L (%d) to register D (%d) L->D successfully \n", this.L, this.D);
				this.PC++;
				break;
			case 0x56:
				//M -> HL
				System.out.printf("Moving data of register M (HL) (%d) to register D (%d) M (HL)->D \n", this.getHL(), this.D);
				this.D = memory.read(getHL());
				System.out.printf("Moved data of register M (HL) (%d) to register D (%d) M (HL)->D successfully \n", this.getHL(), this.D);
				this.PC++;
				break;




		}
//        System.out.println("HELLO");

	}


}
