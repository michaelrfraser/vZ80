package vZ80.instruction.access;

import vZ80.Registers;
import vZ80.VirtualMachine;

public class A implements IDataSource, IDataDestination
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static A instance = new A();

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	private A()
	{
		
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void setData( VirtualMachine vm, int data )
	{
		Registers reg = vm.getRegisters();
		reg.setA( data );
	}

	@Override
	public int getData( VirtualMachine vm )
	{
		Registers reg = vm.getRegisters();
		return reg.getA();
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
