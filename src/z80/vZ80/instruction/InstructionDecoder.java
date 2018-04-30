package vZ80.instruction;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.access.A;
import vZ80.instruction.access.AF;
import vZ80.instruction.access.AFShadow;
import vZ80.instruction.access.B;
import vZ80.instruction.access.BC;
import vZ80.instruction.access.BCPointer;
import vZ80.instruction.access.C;
import vZ80.instruction.access.D;
import vZ80.instruction.access.DE;
import vZ80.instruction.access.DEPointer;
import vZ80.instruction.access.E;
import vZ80.instruction.access.H;
import vZ80.instruction.access.HL;
import vZ80.instruction.access.HLPointer;
import vZ80.instruction.access.I16bitAccessor;
import vZ80.instruction.access.I8bitAccessor;
import vZ80.instruction.access.IX;
import vZ80.instruction.access.IY;
import vZ80.instruction.access.L;
import vZ80.instruction.access.Pointer;
import vZ80.instruction.access.SP;
import vZ80.instruction.access.SPPointer;
import vZ80.instruction.arithmetic.Add8bit;
import vZ80.instruction.load.Exchange;
import vZ80.instruction.load.ExchangeShadow;
import vZ80.instruction.load.Load16bit;
import vZ80.instruction.load.Load8bit;

public class InstructionDecoder
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private VirtualMachine vm;
	private IInstructionCreator[] creators;
	
	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public InstructionDecoder( VirtualMachine vm )
	{
		this.vm = vm;
		this.creators = new IInstructionCreator[0xFF];
		this.initializeCreators();
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	private void initializeCreators()
	{
		IInstructionCreator loadCreator = new GenericLoadCreator();
		IInstructionCreator indexCreator = new IndexFamilyCreator();
		IInstructionCreator edFamilyCreator = new EDFamilyInstructionCreator();
		IInstructionCreator exchangeCreator = new GenericExchangeCreator();
		IInstructionCreator addCreator = new GenericAddCreator();
		
		// Creators registered as per order listed at
		// http://nemesis.lonestar.org/computers/tandy/software/apps/m4/qd/opcodes.html
		this.creators[0x7F] = loadCreator; // LD A,A
		this.creators[0x78] = loadCreator; // LD A,B
		this.creators[0x79] = loadCreator; // LD A,C
		this.creators[0x7A] = loadCreator; // LD A,D
		this.creators[0x7B] = loadCreator; // LD A,E
		this.creators[0x7C] = loadCreator; // LD A,H
		this.creators[0x7D] = loadCreator; // LD A,L
		this.creators[0x7E] = loadCreator; // LD A,(HL)
		this.creators[0x0A] = loadCreator; // LD A,(BC)
		this.creators[0x1A] = loadCreator; // LD A,(DE)
		this.creators[0x3A] = loadCreator; // LD A,(word)
		
		this.creators[0x47] = loadCreator; // LD B,A
		this.creators[0x40] = loadCreator; // LD B,B
		this.creators[0x41] = loadCreator; // LD B,C
		this.creators[0x42] = loadCreator; // LD B,D
		this.creators[0x43] = loadCreator; // LD B,E
		this.creators[0x44] = loadCreator; // LD B,H
		this.creators[0x45] = loadCreator; // LD B,L
		this.creators[0x46] = loadCreator; // LD B,(HL)
		
		this.creators[0x4F] = loadCreator; // LD C,A
		this.creators[0x48] = loadCreator; // LD C,B
		this.creators[0x49] = loadCreator; // LD C,C
		this.creators[0x4A] = loadCreator; // LD C,D
		this.creators[0x4B] = loadCreator; // LD C,E
		this.creators[0x4C] = loadCreator; // LD C,H
		this.creators[0x4D] = loadCreator; // LD C,L
		this.creators[0x4E] = loadCreator; // LD C,(HL)
		
		this.creators[0x57] = loadCreator; // LD D,A
		this.creators[0x50] = loadCreator; // LD D,B
		this.creators[0x51] = loadCreator; // LD D,C
		this.creators[0x52] = loadCreator; // LD D,D
		this.creators[0x53] = loadCreator; // LD D,E
		this.creators[0x54] = loadCreator; // LD D,H
		this.creators[0x55] = loadCreator; // LD D,L
		this.creators[0x56] = loadCreator; // LD D,(HL)
		
		this.creators[0x5F] = loadCreator; // LD E,A
		this.creators[0x58] = loadCreator; // LD E,B
		this.creators[0x59] = loadCreator; // LD E,C
		this.creators[0x5A] = loadCreator; // LD E,D
		this.creators[0x5B] = loadCreator; // LD E,E
		this.creators[0x5C] = loadCreator; // LD E,H
		this.creators[0x5D] = loadCreator; // LD E,L
		this.creators[0x5E] = loadCreator; // LD E,(HL)
		
		this.creators[0x67] = loadCreator; // LD H,A
		this.creators[0x60] = loadCreator; // LD H,B
		this.creators[0x61] = loadCreator; // LD H,C
		this.creators[0x62] = loadCreator; // LD H,D
		this.creators[0x63] = loadCreator; // LD H,E
		this.creators[0x64] = loadCreator; // LD H,H
		this.creators[0x65] = loadCreator; // LD H,L
		this.creators[0x66] = loadCreator; // LD H,(HL)
		
		this.creators[0x6F] = loadCreator; // LD L,A
		this.creators[0x68] = loadCreator; // LD L,B
		this.creators[0x69] = loadCreator; // LD L,C
		this.creators[0x6A] = loadCreator; // LD L,D
		this.creators[0x6B] = loadCreator; // LD L,E
		this.creators[0x6C] = loadCreator; // LD L,H
		this.creators[0x6D] = loadCreator; // LD L,L
		this.creators[0x6E] = loadCreator; // LD L,(HL)
		
		this.creators[0x77] = loadCreator; // LD (HL),A
		this.creators[0x70] = loadCreator; // LD (HL),B
		this.creators[0x71] = loadCreator; // LD (HL),C
		this.creators[0x72] = loadCreator; // LD (HL),D
		this.creators[0x73] = loadCreator; // LD (HL),E
		this.creators[0x74] = loadCreator; // LD (HL),H
		this.creators[0x75] = loadCreator; // LD (HL),L
		
		this.creators[0x3E] = loadCreator; // LD A,byte
		this.creators[0x06] = loadCreator; // LD B,byte
		this.creators[0x0E] = loadCreator; // LD C,byte
		this.creators[0x16] = loadCreator; // LD D,byte
		this.creators[0x1E] = loadCreator; // LD E,byte
		this.creators[0x26] = loadCreator; // LD H,byte
		this.creators[0x2E] = loadCreator; // LD L,byte
		this.creators[0x36] = loadCreator; // LD (HL),byte
		
		this.creators[0x02] = loadCreator; // LD (BC),A
		this.creators[0x12] = loadCreator; // LD (DE),A
		this.creators[0x32] = loadCreator; // LD (word),A
		
		this.creators[0x01] = loadCreator; // LD BC,word
		this.creators[0x11] = loadCreator; // LD DE,word
		this.creators[0x21] = loadCreator; // LD HL,word
		this.creators[0x31] = loadCreator; // LD SP,word
		this.creators[0x2A] = loadCreator; // LD HL,(word)
		this.creators[0x22] = loadCreator; // LD (word),HL
		this.creators[0xF9] = loadCreator; // LD SP,HL 
		
		this.creators[0xEB] = exchangeCreator; // EX DE,HL
		this.creators[0xE3] = exchangeCreator; // EX (SP),HL
		this.creators[0x08] = exchangeCreator; // EX AF,AF'
		this.creators[0xD9] = exchangeCreator; // EXX
		
		this.creators[0xDD] = indexCreator; // IX family
		this.creators[0xFD] = indexCreator; // IY family
		this.creators[0xED] = edFamilyCreator; // instructions starting with 0xED
		
		this.creators[0x87] = addCreator; // ADD A,A
	}
	
	public IInstruction fetchNext() throws IllegalArgumentException
	{
		Memory memory = vm.getRam();
		RegisterFile registers = vm.getRegisters();
		int baseAddress = registers.getPc();
		int baseValue = memory.read8( baseAddress );
		if( creators[baseValue] != null )
		{
			return creators[baseValue].createAndIncrement( vm );
		}
		else
		{
			throw new IllegalArgumentException( "Invalid opcode " + 
			                                    Integer.toString(baseValue, 16) );
		}
	}

	private I8bitAccessor registerCodeTo8bitAccessor( int code )
	{
		switch( code )
		{
			case 0x07:  // 111
				return A.instance;
			case 0x00:  // 000
				return B.instance;
			case 0x01:  // 001
				return C.instance;
			case 0x02:  // 010
				return D.instance;
			case 0x03:  // 011
				return E.instance;
			case 0x04:  // 100
				return H.instance;
			case 0x05:  // 101
				return L.instance;
			case 0x06:  // 110
				return HLPointer.instance;
			default:
				throw new IllegalArgumentException();
		}
	}
	
	private I16bitAccessor registerCodeTo16bitAccessor( int code )
	{
		switch( code )
		{
			case 0x00:  // 00
				return BC.instance;
			case 0x01:  // 01
				return DE.instance;
			case 0x02:  // 10
				return HL.instance;
			case 0x03:  // 11
				return SP.instance;
			default:
				throw new IllegalArgumentException();
		}
	}
	
	private int readDereferenceIncrementPc8bit()
	{
		RegisterFile registers = vm.getRegisters();
		Memory memory = vm.getRam();
		
		// Read PC
		int v0Addr = registers.getPc();
		
		// Dereference
		int value = memory.read8( v0Addr );
		
		// Increment PC
		registers.setPc( v0Addr + 1 );
		
		return value;
	}
	
	private int readDereferenceIncrementPc16bit()
	{
		RegisterFile registers = vm.getRegisters();
		Memory memory = vm.getRam();
		
		// Read PC
		int v0Addr = registers.getPc();
		
		// Dereference
		int value = memory.read16( v0Addr );
		
		// Increment PC
		registers.setPc( v0Addr + 2 );
		
		return value;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
	private interface IInstructionCreator
	{
		public IInstruction createAndIncrement( VirtualMachine vm );
	}
	
	/**
	 * 8-bit Load Group
	 * 
	 * @see Page 70 and 98 of Z80 CPU User Manual
	 */
	private class GenericLoadCreator implements IInstructionCreator
	{
		@Override
		public IInstruction createAndIncrement( VirtualMachine vm )
		{
			//RegisterFile registers = vm.getRegisters();
			//Memory memory = vm.getRam();
			int v0 = readDereferenceIncrementPc8bit();

			// LD r,r'
			// LD r,(HL)
			int v0hi2 = (v0 & 0xC0) >> 6;
			int v0lo3 = v0 & 0x07;
			int v0lo4 = v0 & 0x0F;
			if( v0hi2 == 0x01 )
			{	
				int dstCode = (v0 & 0x38) >> 3;
				
				I8bitAccessor dst = null;
				if( dstCode == 0x06 )
					dst = HLPointer.instance;
				else
					dst = registerCodeTo8bitAccessor( dstCode );
				
				I8bitAccessor src = null;
				if( v0lo3 == 0x06 )
					src = HLPointer.instance;
				else
					src = registerCodeTo8bitAccessor( v0lo3 );
				
				return new Load8bit( dst, src );
			}
			// LD r,n
			else if( v0hi2 == 0x00 && v0lo3 == 0x06 )
			{
				int dstCode = (v0 & 0x38) >> 3;
				
				I8bitAccessor dst = registerCodeTo8bitAccessor( dstCode );
				
				int n = readDereferenceIncrementPc8bit();
				return new Load8bit( dst, n );
			}
			// LD A,(BC)
			else if( v0 == 0x0A )
			{
				return new Load8bit( A.instance, BCPointer.instance );
			}
			// LD A,(DE)
			else if( v0 == 0x1A )
			{
				return new Load8bit( A.instance, DEPointer.instance );
			}
			// LD A,(nn)
			else if( v0 == 0x3A )
			{
				int nn = readDereferenceIncrementPc16bit();
				
				I8bitAccessor src = new Pointer( nn );
				return new Load8bit( A.instance, src );
			}
			// LD (BC),A
			else if( v0 == 0x02 )
			{
				return new Load8bit( BCPointer.instance, A.instance );
			}
			// LD (DE),A
			else if( v0 == 0x12 )
			{
				return new Load8bit( DEPointer.instance, A.instance );
			}
			// LD (nn),A
			else if( v0 == 0x32 )
			{
				int nn = readDereferenceIncrementPc16bit();
				
				I8bitAccessor dst = new Pointer( nn );
				return new Load8bit( dst, A.instance );
			}
			// LD dd,nn
			else if( v0hi2 == 0x00 && v0lo4 == 0x01 )
			{
				int dstCode = (v0 & 0x30) >> 4;
				I16bitAccessor dst = registerCodeTo16bitAccessor( dstCode );
				
				int nn = readDereferenceIncrementPc16bit();
				return new Load16bit( dst, nn );
			}
			// LD HL,(nn)
			else if( v0 == 0x2A )
			{
				int nn = readDereferenceIncrementPc16bit();
				return new Load16bit( HL.instance, new Pointer(nn) );
			}
			// LD (nn),HL
			else if( v0 == 0x22 )
			{
				int nn = readDereferenceIncrementPc16bit();
				return new Load16bit( new Pointer(nn), HL.instance );
			}
			// LD SP,HL
			else if( v0 == 0xF9 )
			{
				return new Load16bit( SP.instance, HL.instance );
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
	}
	
	/**
	 * Creator for instructions that work on the index registers. These instructions usually start
	 * with the 0xDD or 0xFD instructions.
	 */
	private class IndexFamilyCreator implements IInstructionCreator
	{
		@Override
		public IInstruction createAndIncrement( VirtualMachine vm )
		{
			int v0 = readDereferenceIncrementPc8bit();
			
			// LD IX/IY family
			I16bitAccessor base = v0 == 0xDD ? IX.instance : IY.instance;
			int v1 = readDereferenceIncrementPc8bit();
			// IN,nn
			if( v1 == 0x21 )
			{
				int nn = readDereferenceIncrementPc16bit();
				return new Load16bit( base, nn );
			}
			// IN,(nn)
			else if( v1 == 0x2A )
			{
				int nn = readDereferenceIncrementPc16bit();
				return new Load16bit( base, new Pointer(nn) );
			}
			// (nn),IN
			else if( v1 == 0x22 )
			{
				int nn = readDereferenceIncrementPc16bit();
				return new Load16bit( new Pointer(nn), base );
			}
			// SP,IN
			else if( v1 == 0xF9 )
			{
				return new Load16bit( SP.instance, base );
			}
			else if( v1 == 0xE3 )
			{
				return new Exchange( SPPointer.instance, base );
			}
			// 8-bit IN+d load
			else
			{
				int baseAddr = base.get16( vm );
				int v2 = readDereferenceIncrementPc8bit();
				int v1Lo3 = v1 & 0x07;

				// (IN+d),n
				if( v1 == 0x36 )
				{
					int v3 = readDereferenceIncrementPc8bit();
					I8bitAccessor dst = new Pointer( baseAddr + v2 );
					return new Load8bit( dst, v3 );
				}
				// (IN+d),r
				else if( ((v1 & 0xF8) >> 3) == 0x0E )
				{
					int srcCode = v1Lo3;
					I8bitAccessor src = registerCodeTo8bitAccessor( srcCode );
					I8bitAccessor dst = new Pointer( baseAddr + v2 );
					return new Load8bit( dst, src );
				}
				// r, (IN+d)
				else if( v1Lo3 == 0x06 )
				{
					int dstCode = (v1 & 0x38) >> 3;
					I8bitAccessor src = new Pointer( baseAddr + v2 );
					I8bitAccessor dst = registerCodeTo8bitAccessor( dstCode );
					return new Load8bit( dst, src );
				}
				else
				{
					throw new IllegalArgumentException();
				}
			}
		}
	}
	
	/**
	 * Creator for instructions starting with the 0xED byte 
	 */
	private class EDFamilyInstructionCreator implements IInstructionCreator
	{
		@Override
		public IInstruction createAndIncrement( VirtualMachine vm )
		{
			readDereferenceIncrementPc8bit();
			int v1 = readDereferenceIncrementPc8bit();
			int v1hi2 = (v1 & 0xC0) >> 6;
			int v1mid2 = (v1 & 0x30) >> 4;
			int v1lo4 = v1 & 0x0F;
			int nn = readDereferenceIncrementPc16bit();
			if( v1hi2 == 0x01 && v1lo4 == 0x03 )
			{
				// LD (nn),dd
				I16bitAccessor src = registerCodeTo16bitAccessor( v1mid2 );
				return new Load16bit( new Pointer(nn), src );
			}
			else
			{
				// LD dd,(nn)
				I16bitAccessor dst = registerCodeTo16bitAccessor( v1mid2 );
				return new Load16bit( dst, new Pointer(nn) );
			}
		}
	}
	
	private class GenericExchangeCreator implements IInstructionCreator
	{
		@Override
		public IInstruction createAndIncrement( VirtualMachine vm )
		{
			int v0 = readDereferenceIncrementPc8bit();
			
			if( v0 == 0xEB )
			{
				return new Exchange( DE.instance, HL.instance );
			}
			else if( v0 == 0xE3 )
			{
				return new Exchange( SPPointer.instance, HL.instance );
			}
			else if( v0 == 0x08 )
			{
				return new Exchange( AF.instance, AFShadow.instance );
			}
			else if( v0 == 0xD9 )
			{
				return new ExchangeShadow();
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
	}
	
	private class GenericAddCreator implements IInstructionCreator
	{
		@Override
		public IInstruction createAndIncrement( VirtualMachine vm )
		{
			int v0 = readDereferenceIncrementPc8bit();
			if( v0 == 0x87 )
			{
				return new Add8bit( A.instance );
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
	}
}
