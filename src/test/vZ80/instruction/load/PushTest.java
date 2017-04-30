package vZ80.instruction.load;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.AF;
import vZ80.instruction.access.BC;
import vZ80.instruction.access.DE;
import vZ80.instruction.access.HL;
import vZ80.instruction.access.IX;
import vZ80.instruction.access.IY;
import vZ80.instruction.load.Push;

public class PushTest
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
	@Before
	public void setUp()
	{
	}

	@After
	public void tearDown()
	{
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testPushAF()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		reg.setSP( baseSP );
		
		IInstruction push = new Push( AF.instance );
		
		// Push 2 values onto the stack
		reg.setAF( 0x0FF0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		reg.setAF( 0x0AA0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 4, reg.getSP() );
		
		Assert.assertEquals( 0x0FF0, ram.read16(baseSP - 2) );
		Assert.assertEquals( 0x0AA0, ram.read16(baseSP - 4) );
	}
	
	@Test
	public void testPushBC()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		reg.setSP( baseSP );
		
		IInstruction push = new Push( BC.instance );
		
		// Push 2 values onto the stack
		reg.setBC( 0x0FF0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		reg.setBC( 0x0AA0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 4, reg.getSP() );
		
		Assert.assertEquals( 0x0FF0, ram.read16(baseSP - 2) );
		Assert.assertEquals( 0x0AA0, ram.read16(baseSP - 4) );
	}
	
	@Test
	public void testPushDE()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		reg.setSP( baseSP );
		
		IInstruction push = new Push( DE.instance );
		
		// Push 2 values onto the stack
		reg.setDE( 0x0FF0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		reg.setDE( 0x0AA0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 4, reg.getSP() );
		
		Assert.assertEquals( 0x0FF0, ram.read16(baseSP - 2) );
		Assert.assertEquals( 0x0AA0, ram.read16(baseSP - 4) );
	}
	
	@Test
	public void testPushHL()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		reg.setSP( baseSP );
		
		IInstruction push = new Push( HL.instance );
		
		// Push 2 values onto the stack
		reg.setHL( 0x0FF0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		reg.setHL( 0x0AA0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 4, reg.getSP() );
		
		Assert.assertEquals( 0x0FF0, ram.read16(baseSP - 2) );
		Assert.assertEquals( 0x0AA0, ram.read16(baseSP - 4) );
	}
	
	@Test
	public void testPushIX()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		reg.setSP( baseSP );
		
		IInstruction push = new Push( IX.instance );
		
		// Push 2 values onto the stack
		reg.setIX( 0x0FF0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		reg.setIX( 0x0AA0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 4, reg.getSP() );
		
		Assert.assertEquals( 0x0FF0, ram.read16(baseSP - 2) );
		Assert.assertEquals( 0x0AA0, ram.read16(baseSP - 4) );
	}
	
	@Test
	public void testPushIY()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		Memory ram = vm.getRam();
		reg.setSP( baseSP );
		
		IInstruction push = new Push( IY.instance );
		
		// Push 2 values onto the stack
		reg.setIY( 0x0FF0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		reg.setIY( 0x0AA0 );
		push.execute( vm );
		Assert.assertEquals( baseSP - 4, reg.getSP() );
		
		Assert.assertEquals( 0x0FF0, ram.read16(baseSP - 2) );
		Assert.assertEquals( 0x0AA0, ram.read16(baseSP - 4) );
	}

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
