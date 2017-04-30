package vZ80.instruction.load;

import org.junit.Assert;
import org.junit.Test;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.A;
import vZ80.instruction.access.B;
import vZ80.instruction.access.BCPointer;
import vZ80.instruction.access.C;
import vZ80.instruction.access.D;
import vZ80.instruction.access.DEPointer;
import vZ80.instruction.access.E;
import vZ80.instruction.access.H;
import vZ80.instruction.access.HLPointer;
import vZ80.instruction.access.IXPointer;
import vZ80.instruction.access.IYPointer;
import vZ80.instruction.access.L;
import vZ80.instruction.access.Pointer;
import vZ80.instruction.load.Load8bit;

public class LoadATest
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
	public void testLoadA_A()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setA( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, A.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_B()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setB( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, B.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_C()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setC( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, C.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_D()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setD( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, D.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_E()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setE( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, E.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_H()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setH( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, H.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_L()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setL( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, L.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_HLPointer()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Set a value at an arbitrary point in memory
		ram.write8( 0x0FF0, 0xF0 );
		
		// Set the source register to point to the memory that was set 
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, HLPointer.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_BCPointer()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Set a value at an arbitrary point in memory
		ram.write8( 0x0FF0, 0xF0 );
		
		// Set the source register to point to the memory that was set 
		reg.setBC( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, BCPointer.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_DEPointer()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Set a value at an arbitrary point in memory
		ram.write8( 0x0FF0, 0xF0 );
		
		// Set the source register to point to the memory that was set 
		reg.setDE( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, DEPointer.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_Pointer()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Set a value at an arbitrary point in memory
		ram.write8( 0x0FF0, 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, new Pointer(0x0FF0) );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_IXPointer()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Set a value at a base point in memory + an offset
		ram.write8( 0x0FF0 + 5, 0xF0 );
		
		// Set the source register to point to the base point in memory
		reg.setIX( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, new IXPointer(5) );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_IYPointer()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Set a value at a base point in memory + an offset
		ram.write8( 0x0FF0 + 3, 0xF0 );
		
		// Set the source register to point to the base point in memory
		reg.setIY( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, new IYPointer(3) );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}
	
	@Test
	public void testLoadA_Value()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Create and execute the load instruction
		IInstruction load = new Load8bit( A.instance, 0xF0 );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getA() );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
