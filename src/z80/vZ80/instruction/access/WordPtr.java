package vZ80.instruction.access;

import vZ80.Memory;
import vZ80.VirtualMachine;

public class WordPtr implements IDataSource, IDataDestination
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private int addr;
	
	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public WordPtr( int addr )
	{
		this.addr = addr & 0xFFFF;
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void setData( VirtualMachine vm, int data )
	{
		Memory ram = vm.getRam();
		
		ram.set( addr, data );
	}

	@Override
	public int getData( VirtualMachine vm )
	{
		Memory ram = vm.getRam();
		
		return ram.get( addr );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
