package vZ80.instruction.access;

import vZ80.RegisterFile;
import vZ80.VirtualMachine;

public class F implements I8bitAccessor
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static F instance = new F();

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	private F()
	{
		
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void set8( VirtualMachine vm, int data )
	{
		RegisterFile reg = vm.getRegisters();
		reg.setF( data );
	}

	@Override
	public int get8( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		return reg.getF();
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
