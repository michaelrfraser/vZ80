package vZ80.instruction.access;

import vZ80.RegisterFile;
import vZ80.VirtualMachine;

public class E implements I8bitAccessor
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static E instance = new E();

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	private E()
	{
		
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void set8( VirtualMachine vm, int data )
	{
		RegisterFile reg = vm.getRegisters();
		reg.setE( data );
	}

	@Override
	public int get8( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		return reg.getE();
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
