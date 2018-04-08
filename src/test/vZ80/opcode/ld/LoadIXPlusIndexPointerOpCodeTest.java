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
package vZ80.opcode.ld;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import vZ80.Memory;
import vZ80.RegisterFile;
import vZ80.VirtualMachine;

public class LoadIXPlusIndexPointerOpCodeTest
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
	public void testLD_IXPlusIndexPointerA()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xDD );
		memory.write8( BASE_PC + 1, 0x77 );
		memory.write8( BASE_PC + 2, 0x01 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// (IX+1) should contain the value of A
		int ixPlusOnePointerVal = this.memory.read8( 0xCAFE + 1 );
		Assert.assertEquals( 'A', ixPlusOnePointerVal );
	}

	@Test
	public void testLD_IXPlusIndexPointerB()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xDD );
		memory.write8( BASE_PC + 1, 0x70 );
		memory.write8( BASE_PC + 2, 0x01 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// (IX+1) should contain the value that was in B
		int ixPlusOnePointerVal = this.memory.read8( 0xCAFE + 1 );
		Assert.assertEquals( 'B', ixPlusOnePointerVal );
	}
	
	@Test
	public void testLD_IXPlusIndexPointerC()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xDD );
		memory.write8( BASE_PC + 1, 0x71 );
		memory.write8( BASE_PC + 2, 0x01 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// (IX+1) should contain the value that was in C
		int ixPlusOnePointerVal = this.memory.read8( 0xCAFE + 1 );
		Assert.assertEquals( 'C', ixPlusOnePointerVal );
	}
	
	@Test
	public void testLD_IXPlusIndexPointerD()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xDD );
		memory.write8( BASE_PC + 1, 0x72 );
		memory.write8( BASE_PC + 2, 0x01 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// (IX+1) should contain the value that was in D
		int ixPlusOnePointerVal = this.memory.read8( 0xCAFE + 1 );
		Assert.assertEquals( 'D', ixPlusOnePointerVal );
	}
	
	@Test
	public void testLD_IXPlusIndexPointerE()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xDD );
		memory.write8( BASE_PC + 1, 0x73 );
		memory.write8( BASE_PC + 2, 0x01 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// (IX+1) should contain the value that was in E
		int ixPlusOnePointerVal = this.memory.read8( 0xCAFE + 1 );
		Assert.assertEquals( 'E', ixPlusOnePointerVal );
	}
	
	@Test
	public void testLD_IXPlusIndexPointerH()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xDD );
		memory.write8( BASE_PC + 1, 0x74 );
		memory.write8( BASE_PC + 2, 0x01 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// (IX+1) should contain the value that was in H
		int ixPlusOnePointerVal = this.memory.read8( 0xCAFE + 1 );
		Assert.assertEquals( 'H', ixPlusOnePointerVal );
	}
	
	@Test
	public void testLD_IXPlusIndexPointerL()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xDD );
		memory.write8( BASE_PC + 1, 0x75 );
		memory.write8( BASE_PC + 2, 0x01 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// (IX+1) should contain the value that was in L
		int ixPlusOnePointerVal = this.memory.read8( 0xCAFE + 1 );
		Assert.assertEquals( 'L', ixPlusOnePointerVal );
	}
	
	@Test
	public void testLD_IXPlusIndexPointerByte()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xDD );
		memory.write8( BASE_PC + 1, 0x36 );
		memory.write8( BASE_PC + 2, 0x01 );
		memory.write8( BASE_PC + 3, 'K' );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 4
		Assert.assertEquals( BASE_PC + 4, this.registers.getPc() );
		
		// (IX+1) should contain the value that was in the byte param
		int ixPlusOnePointerVal = this.memory.read8( 0xCAFE + 1 );
		Assert.assertEquals( 'K', ixPlusOnePointerVal );
	}
	
	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
