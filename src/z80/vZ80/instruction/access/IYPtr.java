package vZ80.instruction.access;

import vZ80.Memory;
import vZ80.Registers;
import vZ80.VirtualMachine;

public class IYPtr implements IDataSource, IDataDestination
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private int offset;
	
	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public IYPtr( int offset )
	{
		this.offset = offset;
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void setData( VirtualMachine vm, int data )
	{
		Registers reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int iy = reg.getIY();
		
		ram.set( iy + offset, data );
	}

	@Override
	public int getData( VirtualMachine vm )
	{
		Registers reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int iy = reg.getIY();
		
		return ram.get( iy + offset );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
