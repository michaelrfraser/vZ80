package vZ80.instruction.stack;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vZ80.Memory;
import vZ80.Registers;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.AF;
import vZ80.instruction.access.BC;
import vZ80.instruction.access.DE;
import vZ80.instruction.access.HL;
import vZ80.instruction.access.IX;
import vZ80.instruction.access.IY;
import vZ80.instruction.stack.Pop;

public class PopTest
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
	public void testPopAF()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		Memory ram = vm.getRam();
		
		ram.set( baseSP - 4, 0xA0 );
		ram.set( baseSP - 3, 0x0A );
		ram.set( baseSP - 2, 0xF0 );
		ram.set( baseSP - 1, 0x0F );
		reg.setSP( baseSP - 4 );
		
		IInstruction pop = new Pop( AF.instance );
		
		// 1st Pop should put 0x0AA0 into the register 
		pop.execute( vm );
		Assert.assertEquals( 0x0AA0, reg.getAF() );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		// 2nd Pop should put 0x0FF0 into the register
		pop.execute( vm );
		Assert.assertEquals( 0x0FF0, reg.getAF() );
		Assert.assertEquals( baseSP, reg.getSP() );
	}
	
	@Test
	public void testPopBC()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		Memory ram = vm.getRam();
		
		ram.set( baseSP - 4, 0xA0 );
		ram.set( baseSP - 3, 0x0A );
		ram.set( baseSP - 2, 0xF0 );
		ram.set( baseSP - 1, 0x0F );
		reg.setSP( baseSP - 4 );
		
		IInstruction pop = new Pop( BC.instance );
		
		// 1st Pop should put 0x0AA0 into the register 
		pop.execute( vm );
		Assert.assertEquals( 0x0AA0, reg.getBC() );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		// 2nd Pop should put 0x0FF0 into the register
		pop.execute( vm );
		Assert.assertEquals( 0x0FF0, reg.getBC() );
		Assert.assertEquals( baseSP, reg.getSP() );
	}
	
	@Test
	public void testPopDE()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		Memory ram = vm.getRam();
		
		ram.set( baseSP - 4, 0xA0 );
		ram.set( baseSP - 3, 0x0A );
		ram.set( baseSP - 2, 0xF0 );
		ram.set( baseSP - 1, 0x0F );
		reg.setSP( baseSP - 4 );
		
		IInstruction pop = new Pop( DE.instance );
		
		// 1st Pop should put 0x0AA0 into the register 
		pop.execute( vm );
		Assert.assertEquals( 0x0AA0, reg.getDE() );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		// 2nd Pop should put 0x0FF0 into the register
		pop.execute( vm );
		Assert.assertEquals( 0x0FF0, reg.getDE() );
		Assert.assertEquals( baseSP, reg.getSP() );
	}
	
	@Test
	public void testPopHL()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		Memory ram = vm.getRam();
		
		ram.set( baseSP - 4, 0xA0 );
		ram.set( baseSP - 3, 0x0A );
		ram.set( baseSP - 2, 0xF0 );
		ram.set( baseSP - 1, 0x0F );
		reg.setSP( baseSP - 4 );
		
		IInstruction pop = new Pop( HL.instance );
		
		// 1st Pop should put 0x0AA0 into the register 
		pop.execute( vm );
		Assert.assertEquals( 0x0AA0, reg.getHL() );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		// 2nd Pop should put 0x0FF0 into the register
		pop.execute( vm );
		Assert.assertEquals( 0x0FF0, reg.getHL() );
		Assert.assertEquals( baseSP, reg.getSP() );
	}
	
	@Test
	public void testPopIX()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		Memory ram = vm.getRam();
		
		ram.set( baseSP - 4, 0xA0 );
		ram.set( baseSP - 3, 0x0A );
		ram.set( baseSP - 2, 0xF0 );
		ram.set( baseSP - 1, 0x0F );
		reg.setSP( baseSP - 4 );
		
		IInstruction pop = new Pop( IX.instance );
		
		// 1st Pop should put 0x0AA0 into the register 
		pop.execute( vm );
		Assert.assertEquals( 0x0AA0, reg.getIX() );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		// 2nd Pop should put 0x0FF0 into the register
		pop.execute( vm );
		Assert.assertEquals( 0x0FF0, reg.getIX() );
		Assert.assertEquals( baseSP, reg.getSP() );
	}
	
	@Test
	public void testPopIY()
	{
		int baseSP = 0x0100;
		
		VirtualMachine vm = new VirtualMachine();
		Registers reg = vm.getRegisters();
		Memory ram = vm.getRam();
		
		ram.set( baseSP - 4, 0xA0 );
		ram.set( baseSP - 3, 0x0A );
		ram.set( baseSP - 2, 0xF0 );
		ram.set( baseSP - 1, 0x0F );
		reg.setSP( baseSP - 4 );
		
		IInstruction pop = new Pop( IY.instance );
		
		// 1st Pop should put 0x0AA0 into the register 
		pop.execute( vm );
		Assert.assertEquals( 0x0AA0, reg.getIY() );
		Assert.assertEquals( baseSP - 2, reg.getSP() );
		
		// 2nd Pop should put 0x0FF0 into the register
		pop.execute( vm );
		Assert.assertEquals( 0x0FF0, reg.getIY() );
		Assert.assertEquals( baseSP, reg.getSP() );
	}
	
	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
