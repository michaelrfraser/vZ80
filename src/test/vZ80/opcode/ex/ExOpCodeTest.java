/*
 *   Copyright 2018 Calytrix Technologies
 *
 *   This file is part of vZ80.
 *
 *   NOTICE:  All information contained herein is, and remains
 *            the property of Calytrix Technologies Pty Ltd.
 *            The intellectual and technical concepts contained
 *            herein are proprietary to Calytrix Technologies Pty Ltd.
 *            Dissemination of this information or reproduction of
 *            this material is strictly forbidden unless prior written
 *            permission is obtained from Calytrix Technologies Pty Ltd.
 *
 *   Unless required by applicable law or agreed to in writing,
 *   software distributed under the License is distributed on an
 *   "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *   KIND, either express or implied.  See the License for the
 *   specific language governing permissions and limitations
 *   under the License.
 */
package vZ80.opcode.ex;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;

public class ExOpCodeTest
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static final int BASE_SP = 0xFFFF;
	public static final int BASE_PC = 0x0000;
	
	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private VirtualMachine vm; 
	private RegisterFile registers;
	private Memory memory;

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	
	@Before
	public void setUp()
	{
		this.vm = new VirtualMachine();
		
		this.registers = this.vm.getRegisters();
		this.registers.setSP( BASE_SP );	// initial stack pointer
		this.registers.setPc( BASE_PC );  // initial program pointer
		
		// Seed registers with some values
		this.registers.setA( 'A' );
		this.registers.setB( 'B' );
		this.registers.setC( 'C' );
		this.registers.setD( 'D' );
		this.registers.setE( 'E' );
		this.registers.setH( 'H' );
		this.registers.setL( 'L' );
		this.registers.setIX( 0xCAFE );
		this.registers.setIY( 0xBEEF );
		
		this.memory = this.vm.getRam();
		
		this.memory.write8( 0x484C, 'X' );       // (HL)
		this.memory.write8( 0x4243, 'Y' );       // (BC)
		this.memory.write8( 0x4445, 'Z' );       // (DE)
		
		this.memory.write8( 0xCAFE + 1, 'M' );       // (IX+1)
		this.memory.write8( 0xBEEF + 1, 'F' );       // (IY+1)
		
		this.memory.write8( 0xBABE, 'J' );
		
	}

	@After
	public void tearDown()
	{
		this.registers = null;
		this.memory = null;
		this.vm = null;
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void testEX_DEHL()
	{
		// Set the opcode as the first instruction in memory
		this.memory.write8( BASE_PC, 0xEB );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// Registers should have swapped values
		Assert.assertEquals( 0x484C, registers.getDE() );
		Assert.assertEquals( 0x4445, registers.getHL() );
	}
	
	@Test
	public void testEX_SPPointerHL()
	{
		// Write value to be swapped
		this.registers.setSP( BASE_SP -2 );
		this.memory.write16( BASE_SP - 2, 0xF00D );
		
		// Set the opcode as the first instruction in memory
		this.memory.write8( BASE_PC, 0xE3 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// Values should now be swapped
		Assert.assertEquals( 0x484C, memory.read16(BASE_SP -2) );
		Assert.assertEquals( 0xF00D, registers.getHL() );
	}

	@Test
	public void testEX_SPPointerIX()
	{
		// Write value to be swapped
		this.registers.setSP( BASE_SP -2 );
		this.memory.write16( BASE_SP - 2, 0xF00D );
		
		// Set the opcode as the first instruction in memory
		this.memory.write8( BASE_PC, 0xDD );
		this.memory.write8( BASE_PC + 1, 0xE3 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 2
		Assert.assertEquals( BASE_PC + 2, this.registers.getPc() );
		
		// Values should now be swapped
		Assert.assertEquals( 0xCAFE, memory.read16(BASE_SP -2) );
		Assert.assertEquals( 0xF00D, registers.getIX() );
	}
	
	@Test
	public void testEX_SPPointerIY()
	{
		// Write value to be swapped
		this.registers.setSP( BASE_SP -2 );
		this.memory.write16( BASE_SP - 2, 0xF00D );
		
		// Set the opcode as the first instruction in memory
		this.memory.write8( BASE_PC, 0xFD );
		this.memory.write8( BASE_PC + 1, 0xE3 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 2
		Assert.assertEquals( BASE_PC + 2, this.registers.getPc() );
		
		// Values should now be swapped
		Assert.assertEquals( 0xBEEF, memory.read16(BASE_SP -2) );
		Assert.assertEquals( 0xF00D, registers.getIY() );
	}
	
	@Test
	public void testEX_AFAFShadow()
	{
		this.registers.setAF( 0xCAFE );
		this.registers.setAFShadow( 0xBEEF );
		
		// Set the opcode as the first instruction in memory
		this.memory.write8( BASE_PC, 0x08 );
		this.memory.write8( BASE_PC + 1, 0x08 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// Values should now be swapped
		Assert.assertEquals( 0xBEEF, registers.getAF() );
		Assert.assertEquals( 0xCAFE, registers.getAFShadow() );
		
		// Execute swap again
		this.vm.tick();
		
		// PC should have incremented by 1 again
		Assert.assertEquals( BASE_PC + 2, this.registers.getPc() );
		
		// Values should be back to their original form
		Assert.assertEquals( 0xCAFE, registers.getAF() );
		Assert.assertEquals( 0xBEEF, registers.getAFShadow() );
	}
	
	@Test
	public void testEXX()
	{
		// Set shadow register values
		this.registers.setBCShadow( 0xBEEF );
		this.registers.setDEShadow( 0x1337 );
		this.registers.setHLShadow( 0x600D );
		
		// Set the opcode as the first instruction in memory
		this.memory.write8( BASE_PC, 0xD9 );
		
		// Execute
		this.vm.tick();
		
		// Values should now be swapped
		Assert.assertEquals( 0xBEEF, registers.getBC() );
		Assert.assertEquals( 0x4243, registers.getBCShadow() );
		Assert.assertEquals( 0x1337, registers.getDE() );
		Assert.assertEquals( 0x4445, registers.getDEShadow() );
		Assert.assertEquals( 0x600D, registers.getHL() );
		Assert.assertEquals( 0x484C, registers.getHLShadow() );
	}
	
	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
