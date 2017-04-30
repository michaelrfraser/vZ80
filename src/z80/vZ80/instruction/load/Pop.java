package vZ80.instruction.load;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.I16bitAccessor;


public class Pop implements IInstruction
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private I16bitAccessor dst;

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public Pop( I16bitAccessor dst )
	{
		this.dst = dst;
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void execute( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		
		int sp = reg.getSP();
		int value = ram.read16( sp );
		dst.set16( vm, value );
		
		reg.setSP( sp + 2 );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
