package vZ80.instruction.access;

import vZ80.VirtualMachine;

public interface IDataDestination
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	public void setData( VirtualMachine vm, int data );
}
