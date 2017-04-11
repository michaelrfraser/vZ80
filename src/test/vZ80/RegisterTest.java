package vZ80;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vZ80.Registers;

public class RegisterTest
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
	public void testGetSetA()
	{
		Registers reg = new Registers();
		
		reg.setA( 0x00 );
		Assert.assertEquals( 0x00, reg.getA() );
		
		reg.setA( 0x0F );
		Assert.assertEquals( 0x0F, reg.getA() );
		
		reg.setA( 0xF0 );
		Assert.assertEquals( 0xF0, reg.getA() );
		
		reg.setA( 0xFF );
		Assert.assertEquals( 0xFF, reg.getA() );
	}
	
	@Test
	public void testGetSetF()
	{
		Registers reg = new Registers();
		
		reg.setF( 0x00 );
		Assert.assertEquals( 0x00, reg.getF() );
		
		reg.setF( 0x0F );
		Assert.assertEquals( 0x0F, reg.getF() );
		
		reg.setF( 0xF0 );
		Assert.assertEquals( 0xF0, reg.getF() );
		
		reg.setF( 0xFF );
		Assert.assertEquals( 0xFF, reg.getF() );
	}
	
	@Test
	public void testGetSetAF()
	{
		Registers reg = new Registers();
		
		reg.setAF( 0 );
		Assert.assertEquals( 0, reg.getAF() );
		Assert.assertEquals( 0, reg.getA() );
		Assert.assertEquals( 0, reg.getF() );
		
		reg.setAF( 0x00FF );
		Assert.assertEquals( 0x00FF, reg.getAF() );
		Assert.assertEquals( 0x00, reg.getA() );
		Assert.assertEquals( 0xFF, reg.getF() );
		
		reg.setAF( 0x0FF0 );
		Assert.assertEquals( 0x0FF0, reg.getAF() );
		Assert.assertEquals( 0x0F, reg.getA() );
		Assert.assertEquals( 0xF0, reg.getF() );
		
		reg.setAF( 0xFF00 );
		Assert.assertEquals( 0xFF00, reg.getAF() );
		Assert.assertEquals( 0xFF, reg.getA() );
		Assert.assertEquals( 0x00, reg.getF() );
		
		reg.setAF( 0xFFFF );
		Assert.assertEquals( 0xFFFF, reg.getAF() );
		Assert.assertEquals( 0xFF, reg.getA() );
		Assert.assertEquals( 0xFF, reg.getF() );
		
		reg.setA(  0x00 );
		Assert.assertEquals( 0x00FF, reg.getAF() );
		
		reg.setF( 0x00 );
		Assert.assertEquals( 0x0000, reg.getAF() );
	}
	
	@Test
	public void testGetSetB()
	{
		Registers reg = new Registers();
		
		reg.setB( 0x00 );
		Assert.assertEquals( 0x00, reg.getB() );
		
		reg.setB( 0x0F );
		Assert.assertEquals( 0x0F, reg.getB() );
		
		reg.setB( 0xF0 );
		Assert.assertEquals( 0xF0, reg.getB() );
		
		reg.setB( 0xFF );
		Assert.assertEquals( 0xFF, reg.getB() );
	}
	
	@Test
	public void testGetSetC()
	{
		Registers reg = new Registers();
		
		reg.setC( 0x00 );
		Assert.assertEquals( 0x00, reg.getC() );
		
		reg.setC( 0x0F );
		Assert.assertEquals( 0x0F, reg.getC() );
		
		reg.setC( 0xF0 );
		Assert.assertEquals( 0xF0, reg.getC() );
		
		reg.setC( 0xFF );
		Assert.assertEquals( 0xFF, reg.getC() );
	}
	
	@Test
	public void testGetSetBC()
	{
		Registers reg = new Registers();
		
		reg.setBC( 0 );
		Assert.assertEquals( 0, reg.getBC() );
		Assert.assertEquals( 0, reg.getB() );
		Assert.assertEquals( 0, reg.getC() );
		
		reg.setBC( 0x00FF );
		Assert.assertEquals( 0x00FF, reg.getBC() );
		Assert.assertEquals( 0x00, reg.getB() );
		Assert.assertEquals( 0xFF, reg.getC() );
		
		reg.setBC( 0x0FF0 );
		Assert.assertEquals( 0x0FF0, reg.getBC() );
		Assert.assertEquals( 0x0F, reg.getB() );
		Assert.assertEquals( 0xF0, reg.getC() );
		
		reg.setBC( 0xFF00 );
		Assert.assertEquals( 0xFF00, reg.getBC() );
		Assert.assertEquals( 0xFF, reg.getB() );
		Assert.assertEquals( 0x00, reg.getC() );
		
		reg.setBC( 0xFFFF );
		Assert.assertEquals( 0xFFFF, reg.getBC() );
		Assert.assertEquals( 0xFF, reg.getB() );
		Assert.assertEquals( 0xFF, reg.getC() );
		
		reg.setB(  0x00 );
		Assert.assertEquals( 0x00FF, reg.getBC() );
		
		reg.setC( 0x00 );
		Assert.assertEquals( 0x0000, reg.getBC() );
	}
	
	@Test
	public void testGetSetD()
	{
		Registers reg = new Registers();
		
		reg.setD( 0x00 );
		Assert.assertEquals( 0x00, reg.getD() );
		
		reg.setD( 0x0F );
		Assert.assertEquals( 0x0F, reg.getD() );
		
		reg.setD( 0xF0 );
		Assert.assertEquals( 0xF0, reg.getD() );
		
		reg.setD( 0xFF );
		Assert.assertEquals( 0xFF, reg.getD() );
	}
	
	@Test
	public void testGetSetE()
	{
		Registers reg = new Registers();
		
		reg.setE( 0x00 );
		Assert.assertEquals( 0x00, reg.getE() );
		
		reg.setE( 0x0F );
		Assert.assertEquals( 0x0F, reg.getE() );
		
		reg.setE( 0xF0 );
		Assert.assertEquals( 0xF0, reg.getE() );
		
		reg.setE( 0xFF );
		Assert.assertEquals( 0xFF, reg.getE() );
	}
	
	@Test
	public void testGetSetDE()
	{
		Registers reg = new Registers();
		
		reg.setDE( 0 );
		Assert.assertEquals( 0, reg.getDE() );
		Assert.assertEquals( 0, reg.getD() );
		Assert.assertEquals( 0, reg.getE() );
		
		reg.setDE( 0x00FF );
		Assert.assertEquals( 0x00FF, reg.getDE() );
		Assert.assertEquals( 0x00, reg.getD() );
		Assert.assertEquals( 0xFF, reg.getE() );
		
		reg.setDE( 0x0FF0 );
		Assert.assertEquals( 0x0FF0, reg.getDE() );
		Assert.assertEquals( 0x0F, reg.getD() );
		Assert.assertEquals( 0xF0, reg.getE() );
		
		reg.setDE( 0xFF00 );
		Assert.assertEquals( 0xFF00, reg.getDE() );
		Assert.assertEquals( 0xFF, reg.getD() );
		Assert.assertEquals( 0x00, reg.getE() );
		
		reg.setDE( 0xFFFF );
		Assert.assertEquals( 0xFFFF, reg.getDE() );
		Assert.assertEquals( 0xFF, reg.getD() );
		Assert.assertEquals( 0xFF, reg.getE() );
		
		reg.setD(  0x00 );
		Assert.assertEquals( 0x00FF, reg.getDE() );
		
		reg.setE( 0x00 );
		Assert.assertEquals( 0x0000, reg.getDE() );
	}
	
	@Test
	public void testGetSetH()
	{
		Registers reg = new Registers();
		
		reg.setH( 0x00 );
		Assert.assertEquals( 0x00, reg.getH() );
		
		reg.setH( 0x0F );
		Assert.assertEquals( 0x0F, reg.getH() );
		
		reg.setH( 0xF0 );
		Assert.assertEquals( 0xF0, reg.getH() );
		
		reg.setH( 0xFF );
		Assert.assertEquals( 0xFF, reg.getH() );
	}
	
	@Test
	public void testGetSetL()
	{
		Registers reg = new Registers();
		
		reg.setL( 0x00 );
		Assert.assertEquals( 0x00, reg.getL() );
		
		reg.setL( 0x0F );
		Assert.assertEquals( 0x0F, reg.getL() );
		
		reg.setL( 0xF0 );
		Assert.assertEquals( 0xF0, reg.getL() );
		
		reg.setL( 0xFF );
		Assert.assertEquals( 0xFF, reg.getL() );
	}
	
	@Test
	public void testGetSetHL()
	{
		Registers reg = new Registers();
		
		reg.setHL( 0 );
		Assert.assertEquals( 0, reg.getHL() );
		Assert.assertEquals( 0, reg.getH() );
		Assert.assertEquals( 0, reg.getL() );
		
		reg.setHL( 0x00FF );
		Assert.assertEquals( 0x00FF, reg.getHL() );
		Assert.assertEquals( 0x00, reg.getH() );
		Assert.assertEquals( 0xFF, reg.getL() );
		
		reg.setHL( 0x0FF0 );
		Assert.assertEquals( 0x0FF0, reg.getHL() );
		Assert.assertEquals( 0x0F, reg.getH() );
		Assert.assertEquals( 0xF0, reg.getL() );
		
		reg.setHL( 0xFF00 );
		Assert.assertEquals( 0xFF00, reg.getHL() );
		Assert.assertEquals( 0xFF, reg.getH() );
		Assert.assertEquals( 0x00, reg.getL() );
		
		reg.setHL( 0xFFFF );
		Assert.assertEquals( 0xFFFF, reg.getHL() );
		Assert.assertEquals( 0xFF, reg.getH() );
		Assert.assertEquals( 0xFF, reg.getL() );
		
		reg.setH( 0x00 );
		Assert.assertEquals( 0x00FF, reg.getHL() );
		
		reg.setL( 0x00 );
		Assert.assertEquals( 0x0000, reg.getHL() );
	}
	
	@Test
	public void testGetSetIX()
	{
		Registers reg = new Registers();
		
		reg.setIX( 0x0000 );
		Assert.assertEquals( 0x0000, reg.getIX() );
		
		reg.setIX( 0x00FF );
		Assert.assertEquals( 0x00FF, reg.getIX() );
		
		reg.setIX( 0xFF00 );
		Assert.assertEquals( 0xFF00, reg.getIX() );
		
		reg.setIX( 0xFFFF );
		Assert.assertEquals( 0xFFFF, reg.getIX() );
	}
	
	@Test
	public void testGetSetIY()
	{
		Registers reg = new Registers();
		
		reg.setIY( 0x0000 );
		Assert.assertEquals( 0x0000, reg.getIY() );
		
		reg.setIY( 0x00FF );
		Assert.assertEquals( 0x00FF, reg.getIY() );
		
		reg.setIY( 0xFF00 );
		Assert.assertEquals( 0xFF00, reg.getIY() );
		
		reg.setIY( 0xFFFF );
		Assert.assertEquals( 0xFFFF, reg.getIY() );
	}
	
	@Test
	public void testGetSetSP()
	{
		Registers reg = new Registers();
		
		reg.setSP( 0x0000 );
		Assert.assertEquals( 0x0000, reg.getSP() );
		
		reg.setSP( 0x00FF );
		Assert.assertEquals( 0x00FF, reg.getSP() );
		
		reg.setSP( 0xFF00 );
		Assert.assertEquals( 0xFF00, reg.getSP() );
		
		reg.setSP( 0xFFFF );
		Assert.assertEquals( 0xFFFF, reg.getSP() );
	}
	
	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
