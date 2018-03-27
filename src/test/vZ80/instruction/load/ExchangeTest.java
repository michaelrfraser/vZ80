package vZ80.instruction.load;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.DE;
import vZ80.instruction.access.HL;
import vZ80.instruction.access.IX;
import vZ80.instruction.access.IY;
import vZ80.instruction.access.SPPointer;

public class ExchangeTest
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
	public void testExchangeHL_DE()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Set initial values
		reg.setHL( 0x0FF0 );
		reg.setDE( 0x0AA0 );
		
		// Create and execute the exchange instruction
		IInstruction exchange = new Exchange( HL.instance, DE.instance );
		exchange.execute( vm );
		
		// Values should now be swapped
		Assert.assertEquals( 0x0AA0, reg.getHL() );
		Assert.assertEquals( 0x0FF0, reg.getDE() );
	}
	
	@Test
	public void testExchangeSPPointer_HL()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Set the stack pointer and write a value to it 
		int baseSP = 0x2000;
		reg.setSP( baseSP );
		ram.write16( baseSP, 0x0FF0 );
		
		// Set register value
		reg.setHL( 0x0AA0 );
		
		// Create and execute the exchange instruction
		IInstruction exchange = new Exchange( SPPointer.instance, HL.instance );
		exchange.execute( vm );
		
		// Values should now be swapped
		Assert.assertEquals( 0x0AA0, ram.read16(baseSP) );
		Assert.assertEquals( 0x0FF0, reg.getHL() );
	}
	
	@Test
	public void testExchangeSPPointer_IX()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Set the stack pointer and write a value to it 
		int baseSP = 0x2000;
		reg.setSP( baseSP );
		ram.write16( baseSP, 0x0FF0 );
		
		// Set register value
		reg.setIX( 0x0AA0 );
		
		// Create and execute the exchange instruction
		IInstruction exchange = new Exchange( SPPointer.instance, IX.instance );
		exchange.execute( vm );
		
		// Values should now be swapped
		Assert.assertEquals( 0x0AA0, ram.read16(baseSP) );
		Assert.assertEquals( 0x0FF0, reg.getIX() );
	}
	
	@Test
	public void testExchangeSPPointer_IY()
	{
		VirtualMachine vm = new VirtualMachine();
		Memory ram = vm.getRam();
		RegisterFile reg = vm.getRegisters();
		
		// Set the stack pointer and write a value to it 
		int baseSP = 0x2000;
		reg.setSP( baseSP );
		ram.write16( baseSP, 0x0FF0 );
		
		// Set register value
		reg.setIY( 0x0AA0 );
		
		// Create and execute the exchange instruction
		IInstruction exchange = new Exchange( SPPointer.instance, IY.instance );
		exchange.execute( vm );
		
		// Values should now be swapped
		Assert.assertEquals( 0x0AA0, ram.read16(baseSP) );
		Assert.assertEquals( 0x0FF0, reg.getIY() );
	}
	
	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
