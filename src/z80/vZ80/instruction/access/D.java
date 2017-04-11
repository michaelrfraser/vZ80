package vZ80.instruction.access;

import vZ80.Registers;
import vZ80.VirtualMachine;

public class D implements IDataSource, IDataDestination
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static D instance = new D();

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	private D()
	{
		
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void setData( VirtualMachine vm, int data )
	{
		Registers reg = vm.getRegisters();
		reg.setD( data );
	}

	@Override
	public int getData( VirtualMachine vm )
	{
		Registers reg = vm.getRegisters();
		return reg.getD();
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
