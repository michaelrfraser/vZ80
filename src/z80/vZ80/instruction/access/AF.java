package vZ80.instruction.access;

import vZ80.RegisterFile;
import vZ80.VirtualMachine;

public class AF implements I16bitAccessor
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static AF instance = new AF();

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	private AF()
	{
		
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void set16( VirtualMachine vm, int data )
	{
		RegisterFile reg = vm.getRegisters();
		reg.setAF( data );
	}

	@Override
	public int get16( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		return reg.getAF();
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
