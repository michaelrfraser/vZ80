package vZ80.instruction.access;

import vZ80.VirtualMachine;

public interface IDataSource
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	public int getData( VirtualMachine vm );
}
