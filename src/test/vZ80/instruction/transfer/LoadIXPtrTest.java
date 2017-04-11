package vZ80.instruction.transfer;

import org.junit.Assert;
import org.junit.Test;

import vZ80.Memory;
import vZ80.Registers;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.A;
import vZ80.instruction.access.B;
import vZ80.instruction.access.ByteValue;
import vZ80.instruction.access.C;
import vZ80.instruction.access.D;
import vZ80.instruction.access.E;
import vZ80.instruction.access.H;
import vZ80.instruction.access.IXPtr;
import vZ80.instruction.access.L;
import vZ80.instruction.transfer.Load;

public class LoadIXPtrTest
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
	public void testLoadIXPtr_A()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set the base destination address in IX
		reg.setIX( 0x0FF0 );
		
		// Load an initial value into the source
		reg.setA( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( new IXPtr(8), A.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF8) );
	}
	
	@Test
	public void testLoadIXPtr_B()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set the base destination address in IX
		reg.setIX( 0x0FF0 );
		
		// Load an initial value into the source
		reg.setB( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( new IXPtr(8), B.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF8) );
	}
	
	@Test
	public void testLoadIXPtr_C()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set the base destination address in IX
		reg.setIX( 0x0FF0 );
		
		// Load an initial value into the source
		reg.setC( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( new IXPtr(8), C.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF8) );
	}
	
	@Test
	public void testLoadIXPtr_D()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set the base destination address in IX
		reg.setIX( 0x0FF0 );
		
		// Load an initial value into the source
		reg.setD( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( new IXPtr(8), D.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF8) );
	}
	
	@Test
	public void testLoadIXPtr_E()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set the base destination address in IX
		reg.setIX( 0x0FF0 );
		
		// Load an initial value into the source
		reg.setE( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( new IXPtr(8), E.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF8) );
	}
	
	@Test
	public void testLoadIXPtr_H()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set the base destination address in IX
		reg.setIX( 0x0FF0 );
		
		// Load an initial value into the source
		reg.setH( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( new IXPtr(8), H.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF8) );
	}
	
	@Test
	public void testLoadIXPtr_L()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set the base destination address in IX
		reg.setIX( 0x0FF0 );
		
		// Load an initial value into the source
		reg.setL( 0xF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( new IXPtr(8), L.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF8) );
	}
	
	@Test
	public void testLoadIXPtr_Value()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Set the base destination address in IX
		reg.setIX( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( new IXPtr(8), new ByteValue(0xF0) );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF8) );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
