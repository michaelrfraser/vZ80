package vZ80.instruction.stack;

import vZ80.Memory;
import vZ80.Registers;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.IDataDestination;

public class Pop implements IInstruction
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private IDataDestination dst;

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public Pop( IDataDestination dst )
	{
		this.dst = dst;
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void execute( VirtualMachine vm )
	{
		Registers reg = vm.getRegisters();
		Memory ram = vm.getRam();
		
		int sp = reg.getSP();
		
		int hi = ram.get( sp + 1 );
		int lo = ram.get( sp );
		
		dst.setData( vm, (hi << 8) | lo );
		
		reg.setSP( sp + 2 );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
