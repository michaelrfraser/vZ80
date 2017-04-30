package vZ80.instruction.access;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;

public class IYPointer implements I8bitAccessor, I16bitAccessor
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
	public IYPointer( int offset )
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
		int iy = reg.getIY();
		
		ram.write8( iy + offset, data );
	}

	@Override
	public int get8( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int iy = reg.getIY();
		
		return ram.read8( iy + offset );
	}
	
	@Override
	public void set16( VirtualMachine vm, int data )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int iy = reg.getIY();
		
		ram.write16( iy + offset, data );
	}

	@Override
	public int get16( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int iy = reg.getIY();
		
		return ram.read16( iy + offset );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
