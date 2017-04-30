package vZ80.instruction.access;

import vZ80.VirtualMachine;

public interface I8bitAccessor
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	public int get8( VirtualMachine vm );
	public void set8( VirtualMachine vm, int data );
}
