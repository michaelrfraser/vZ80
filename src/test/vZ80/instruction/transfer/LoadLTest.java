package vZ80.instruction.transfer;

import org.junit.Assert;
import org.junit.Test;

import vZ80.Memory;
import vZ80.Registers;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.A;
import vZ80.instruction.access.B;
import vZ80.instruction.access.BCPtr;
import vZ80.instruction.access.ByteValue;
import vZ80.instruction.access.C;
import vZ80.instruction.access.D;
import vZ80.instruction.access.DEPtr;
import vZ80.instruction.access.E;
import vZ80.instruction.access.H;
import vZ80.instruction.access.HLPtr;
import vZ80.instruction.access.IXPtr;
import vZ80.instruction.access.IYPtr;
import vZ80.instruction.access.L;
import vZ80.instruction.access.WordPtr;
import vZ80.instruction.transfer.Load;

public class LoadLTest
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
	public void testLoadL_A()
	{
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setA( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, A.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_B()
	{
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setB( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, B.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_C()
	{
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setC( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, C.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_D()
	{
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setD( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, D.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_E()
	{
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setE( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, E.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_H()
	{
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setH( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, H.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_L()
	{
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setL( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, L.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_HLptr()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set a value at an arbitrary point in memory
		ram.set( 0x0FF0, 0xF0 );
		
		// Set the source register to point to the memory that was set 
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, HLPtr.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_BCptr()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set a value at an arbitrary point in memory
		ram.set( 0x0FF0, 0xF0 );
		
		// Set the source register to point to the memory that was set 
		reg.setBC( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, BCPtr.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_DEptr()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set a value at an arbitrary point in memory
		ram.set( 0x0FF0, 0xF0 );
		
		// Set the source register to point to the memory that was set 
		reg.setDE( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, DEPtr.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_Wordptr()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set a value at an arbitrary point in memory
		ram.set( 0x0FF0, 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, new WordPtr(0x0FF0) );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_IXptr()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set a value at a base point in memory + an offset
		ram.set( 0x0FF0 + 5, 0xF0 );
		
		// Set the source register to point to the base point in memory
		reg.setIX( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, new IXPtr(5) );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_IYptr()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set a value at a base point in memory + an offset
		ram.set( 0x0FF0 + 3, 0xF0 );
		
		// Set the source register to point to the base point in memory
		reg.setIY( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, new IYPtr(3) );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}
	
	@Test
	public void testLoadL_Value()
	{
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		
		// Create and execute the load instruction
		IInstruction load = new Load( L.instance, new ByteValue(0xF0) );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, reg.getL() );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
