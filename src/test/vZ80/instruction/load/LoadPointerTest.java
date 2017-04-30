package vZ80.instruction.load;

import org.junit.Assert;
import org.junit.Test;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.A;
import vZ80.instruction.access.BC;
import vZ80.instruction.access.DE;
import vZ80.instruction.access.HL;
import vZ80.instruction.access.IX;
import vZ80.instruction.access.IY;
import vZ80.instruction.access.Pointer;
import vZ80.instruction.access.SP;
import vZ80.instruction.load.Load16bit;
import vZ80.instruction.load.Load8bit;

public class LoadPointerTest
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
	public void testLoadPointer_A()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setA( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( new Pointer(0x0FF0), A.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.read8(0x0FF0) );
	}
	
	@Test
	public void testLoadPointer_HL()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setHL( 0x0AA0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( new Pointer(0x0FF0), HL.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0AA0, ram.read16(0x0FF0) );
	}
	
	@Test
	public void testLoadPointer_BC()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setBC( 0x0AA0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( new Pointer(0x0FF0), BC.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0AA0, ram.read16(0x0FF0) );
	}
	
	@Test
	public void testLoadPointer_DE()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setDE( 0x0AA0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( new Pointer(0x0FF0), DE.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0AA0, ram.read16(0x0FF0) );
	}
	
	@Test
	public void testLoadPointer_IX()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setIX( 0x0AA0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( new Pointer(0x0FF0), IX.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0AA0, ram.read16(0x0FF0) );
	}
	
	@Test
	public void testLoadPointer_IY()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setIY( 0x0AA0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( new Pointer(0x0FF0), IY.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0AA0, ram.read16(0x0FF0) );
	}
	
	@Test
	public void testLoadPointer_SP()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setSP( 0x0AA0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load16bit( new Pointer(0x0FF0), SP.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0AA0, ram.read16(0x0FF0) );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
