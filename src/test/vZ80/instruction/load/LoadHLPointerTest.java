package vZ80.instruction.load;

import org.junit.Assert;
import org.junit.Test;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.A;
import vZ80.instruction.access.B;
import vZ80.instruction.access.C;
import vZ80.instruction.access.D;
import vZ80.instruction.access.E;
import vZ80.instruction.access.H;
import vZ80.instruction.access.HLPointer;
import vZ80.instruction.access.L;
import vZ80.instruction.load.Load8bit;

public class LoadHLPointerTest
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
	public void testLoadHLPointer_A()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setA( 0xF0 );
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( HLPointer.instance, A.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.read8(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPointer_B()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setB( 0xF0 );
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( HLPointer.instance, B.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.read8(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPointer_C()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setC( 0xF0 );
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( HLPointer.instance, C.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.read8(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPointer_D()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setD( 0xF0 );
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( HLPointer.instance, D.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.read8(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPointer_E()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setE( 0xF0 );
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( HLPointer.instance, E.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.read8(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPointer_H()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( HLPointer.instance, H.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0F, ram.read8(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPointer_L()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( HLPointer.instance, L.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.read8(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPointer_Value()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( HLPointer.instance, 0xF0 );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.read8(0x0FF0) );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
