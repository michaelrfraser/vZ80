package vZ80.instruction.load;

import org.junit.Assert;
import org.junit.Test;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.DE;
import vZ80.instruction.access.Pointer;
import vZ80.instruction.load.Load16bit;

public class LoadDETest
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Test
	public void testLoadDE_Value()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( DE.instance, 0x0FF0 );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0FF0, reg.getDE() );
	}
	
	@Test
	public void testLoadDE_Pointer()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Set a value at an arbitrary point in memory
		ram.write16( 0x0FF0, 0x0AA0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( DE.instance, new Pointer(0x0FF0) );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0AA0, reg.getDE() );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
