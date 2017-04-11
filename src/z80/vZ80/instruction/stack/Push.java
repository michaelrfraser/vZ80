package vZ80.instruction.stack;

import vZ80.Memory;
import vZ80.Registers;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.IDataSource;

public class Push implements IInstruction
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private IDataSource src;

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public Push( IDataSource src )
	{
		this.src = src;
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void execute( VirtualMachine vm )
	{
		Registers reg = vm.getRegisters();
		Memory ram = vm.getRam();
		
		int value = src.getData( vm );
		int sp = reg.getSP();
		
		int hi = (value & 0xFF00) >> 8;
		int lo = (value & 0xFF);
		
		ram.set( sp - 1, hi );
		ram.set( sp - 2, lo );
		
		reg.setSP( sp - 2 );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
