package vZ80.instruction.load;

import org.junit.Assert;
import org.junit.Test;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.HL;
import vZ80.instruction.access.IX;
import vZ80.instruction.access.IY;
import vZ80.instruction.access.Pointer;
import vZ80.instruction.access.SP;
import vZ80.instruction.load.Load16bit;

public class LoadSPTest
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
	public void testLoadSP_Value()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( SP.instance, 0x0FF0 );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0FF0, reg.getSP() );
	}
	
	@Test
	public void testLoadSP_Pointer()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Set a value at an arbitrary point in memory
		ram.write16( 0x0FF0, 0x0AA0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( SP.instance, new Pointer(0x0FF0) );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0AA0, reg.getSP() );
	}
	
	@Test
	public void testLoadSP_HL()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( SP.instance, HL.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0FF0, reg.getSP() );
	}
	
	@Test
	public void testLoadSP_IX()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setIX( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( SP.instance, IX.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0FF0, reg.getSP() );
	}
	
	@Test
	public void testLoadSP_IY()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setIY( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( SP.instance, IY.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0FF0, reg.getSP() );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
