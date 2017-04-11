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
import vZ80.instruction.access.HLPtr;
import vZ80.instruction.access.L;
import vZ80.instruction.transfer.Load;

public class LoadHLPtrTest
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
	public void testLoadHLPtr_A()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setA( 0xF0 );
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( HLPtr.instance, A.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPtr_B()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setB( 0xF0 );
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( HLPtr.instance, B.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPtr_C()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setC( 0xF0 );
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( HLPtr.instance, C.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPtr_D()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setD( 0xF0 );
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( HLPtr.instance, D.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPtr_E()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setE( 0xF0 );
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( HLPtr.instance, E.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPtr_H()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( HLPtr.instance, H.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0x0F, ram.get(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPtr_L()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Load an initial value into the source
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( HLPtr.instance, L.instance );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF0) );
	}
	
	@Test
	public void testLoadHLPtr_Value()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		Registers reg = vm.getRegisters();
		
		// Point HL to the memory address to load into
		reg.setHL( 0x0FF0 );
		
		// Create and execute the load instruction
		IInstruction load = new Load( HLPtr.instance, new ByteValue(0xF0) );
		load.execute( vm );
		
		// The destination should now contain the source
		Assert.assertEquals( 0xF0, ram.get(0x0FF0) );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
