package vZ80.instruction;

import vZ80.VirtualMachine;

public interface IInstruction
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	public void execute( VirtualMachine vm );
}
