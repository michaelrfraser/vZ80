package vZ80.instruction.access;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;

public class DEPointer implements I8bitAccessor, I16bitAccessor
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static DEPointer instance = new DEPointer();

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	private DEPointer()
	{
		
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void set8( VirtualMachine vm, int data )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int addr = reg.getDE();
		
		ram.write8( addr, data );
	}

	@Override
	public int get8( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int addr = reg.getDE();
		
		return ram.read8( addr );
	}
	
	@Override
	public void set16( VirtualMachine vm, int data )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int addr = reg.getDE();
		
		ram.write16( addr, data );
	}

	@Override
	public int get16( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		int addr = reg.getDE();
		
		return ram.read16( addr );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
