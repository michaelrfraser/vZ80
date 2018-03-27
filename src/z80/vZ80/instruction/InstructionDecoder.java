package vZ80.instruction;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.access.A;
import vZ80.instruction.access.B;
import vZ80.instruction.access.BCPointer;
import vZ80.instruction.access.C;
import vZ80.instruction.access.D;
import vZ80.instruction.access.DEPointer;
import vZ80.instruction.access.E;
import vZ80.instruction.access.H;
import vZ80.instruction.access.HLPointer;
import vZ80.instruction.access.I16bitAccessor;
import vZ80.instruction.access.I8bitAccessor;
import vZ80.instruction.access.L;
import vZ80.instruction.access.Pointer;
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
		IInstructionCreator ldCreator = new LDCreator();
		
		// Creators registered as per order listed at
		// http://nemesis.lonestar.org/computers/tandy/software/apps/m4/qd/opcodes.html
		this.creators[0x7F] = ldCreator; // LD A,A
		this.creators[0x78] = ldCreator; // LD A,B
		this.creators[0x79] = ldCreator; // LD A,C
		this.creators[0x7A] = ldCreator; // LD A,D
		this.creators[0x7B] = ldCreator; // LD A,E
		this.creators[0x7C] = ldCreator; // LD A,H
		this.creators[0x7D] = ldCreator; // LD A,L
		this.creators[0x7E] = ldCreator; // LD A,(HL)
		this.creators[0x0A] = ldCreator; // LD A,(BC)
		this.creators[0x1A] = ldCreator; // LD A,(DE)
		this.creators[0x3A] = ldCreator; // LD A,(word)
		this.creators[0xDD] = ldCreator; // LD IX family
		
		this.creators[0x3E] = ldCreator; // LD A,(word)
		
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
			default:
				throw new IllegalArgumentException();
		}
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
	 * @see Page 70 of Z80 CPU User Manual
	 */
	private class LDCreator implements IInstructionCreator
	{
		@Override
		public IInstruction createAndIncrement( VirtualMachine vm )
		{
			RegisterFile registers = vm.getRegisters();
			Memory memory = vm.getRam();
			int v0Addr = registers.getPcAndIncrement();
			int v0 = memory.read8( v0Addr );

			// LD r,r'
			// LD r,(HL)
			int v0hi2 = (v0 & 0xC0) >> 6;
			int v0lo3 = v0 & 0x07;
			if( v0hi2 == 0x01 )
			{	
				int dstCode = (v0 & 0x38) >> 3;
				I8bitAccessor dst = registerCodeTo8bitAccessor( dstCode );
				
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
				
				int value = memory.read8( registers.getPcAndIncrement() );
				return new Load8bit( dst, value );
			}
			// LD IX family
			else if( v0 == 0xDD )
			{
				int v1Addr = registers.getPcAndIncrement();
				int v1 = memory.read8( v1Addr );

				int dstCode = (v1 & 0x1C) >> 2;
				int srcCode = v1 & 0x07;
				
				// LD r, (IX+d)
				if( srcCode == 0x06 )
				{
					I8bitAccessor dst = registerCodeTo8bitAccessor( dstCode );
					int ix = registers.getIX();
					int v2Addr = registers.getPcAndIncrement();
					int v2 = memory.read8( v2Addr );
					I8bitAccessor src = new Pointer( ix + v2 );
					
					return new Load8bit( dst, src );
				}
				else
				{
					throw new IllegalArgumentException();
				}
				
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
				int pc = registers.getPc();
				int nn = memory.read16( pc );
				registers.setPc( pc + 2 );
				
				I8bitAccessor src = new Pointer( nn );
				return new Load8bit( A.instance, src );
			}
			else
			{
				throw new IllegalArgumentException();
			}
		}
	}
}
