package vZ80.instruction.access;

import vZ80.Memory;
import vZ80.VirtualMachine;

public class Pointer implements I8bitAccessor, I16bitAccessor
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
	public Pointer( int addr )
	{
		this.addr = addr;
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void set8( VirtualMachine vm, int data )
	{
		Memory ram = vm.getRam();
		
		ram.write8( addr, data );
	}

	@Override
	public int get8( VirtualMachine vm )
	{
		Memory ram = vm.getRam();
		
		return ram.read8( addr );
	}
	
	@Override
	public void set16( VirtualMachine vm, int data )
	{
		Memory ram = vm.getRam();
		
		ram.write16( addr, data );
	}

	@Override
	public int get16( VirtualMachine vm )
	{
		Memory ram = vm.getRam();
		
		return ram.read16( addr );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
