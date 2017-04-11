package vZ80.instruction.access;

import vZ80.Registers;
import vZ80.VirtualMachine;

public class C implements IDataSource, IDataDestination
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static C instance = new C();

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	private C()
	{
		
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void setData( VirtualMachine vm, int data )
	{
		Registers reg = vm.getRegisters();
		reg.setC( data );
	}

	@Override
	public int getData( VirtualMachine vm )
	{
		Registers reg = vm.getRegisters();
		return reg.getC();
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
