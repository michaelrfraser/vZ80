package vZ80.instruction.access;

import vZ80.RegisterFile;
import vZ80.VirtualMachine;

public class IY implements I16bitAccessor
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static IY instance = new IY();

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	private IY()
	{
		
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void set16( VirtualMachine vm, int data )
	{
		RegisterFile reg = vm.getRegisters();
		reg.setIY( data );
	}

	@Override
	public int get16( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		return reg.getIY();
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
