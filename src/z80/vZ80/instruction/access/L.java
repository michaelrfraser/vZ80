package vZ80.instruction.access;

import vZ80.Registers;
import vZ80.VirtualMachine;

public class L implements IDataSource, IDataDestination
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static L instance = new L();

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	private L()
	{
		
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void setData( VirtualMachine vm, int data )
	{
		Registers reg = vm.getRegisters();
		reg.setL( data );
	}

	@Override
	public int getData( VirtualMachine vm )
	{
		Registers reg = vm.getRegisters();
		return reg.getL();
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
