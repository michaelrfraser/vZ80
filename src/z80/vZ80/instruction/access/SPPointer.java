package vZ80.instruction.access;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;

public class SPPointer implements I16bitAccessor
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static SPPointer instance = new SPPointer();

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	private SPPointer()
	{
		
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void set16( VirtualMachine vm, int data )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int address = reg.getSP();
		
		ram.write16( address, data );
	}

	@Override
	public int get16( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int address = reg.getSP();
		
		return ram.read16( address );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
