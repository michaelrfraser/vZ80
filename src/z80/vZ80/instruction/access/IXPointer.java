package vZ80.instruction.access;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;

public class IXPointer implements I8bitAccessor, I16bitAccessor
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
	public IXPointer( int offset )
	{
		this.offset = offset;
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void set8( VirtualMachine vm, int data )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int ix = reg.getIX();
		
		ram.write8( ix + offset, data );
	}

	@Override
	public int get8( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int ix = reg.getIX();
		
		return ram.read8( ix + offset );
	}
	
	@Override
	public void set16( VirtualMachine vm, int data )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int ix = reg.getIX();
		
		ram.write16( ix + offset, data );
	}

	@Override
	public int get16( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int ix = reg.getIX();
		
		return ram.read16( ix + offset );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
