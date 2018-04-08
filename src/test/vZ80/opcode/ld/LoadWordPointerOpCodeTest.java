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

public class LoadWordPointerOpCodeTest
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
	public void testLD_WordPointerA()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x32 );
		memory.write16( BASE_PC + 1, 0xBABE );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// (word) should contain the value of A
		int wordPointerVal = this.memory.read8( 0xBABE );
		Assert.assertEquals( 'A', wordPointerVal );
	}
	
	@Test
	public void testLD_WordPointerHL()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x22 );
		memory.write16( BASE_PC + 1, 0xF00D );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// The memory address that the word param pointed to should contain the value that was in HL
		Assert.assertEquals( 0x484C, this.memory.read16(0xF00D) );
	}
	
	@Test
	public void testLD_WordPointerBC()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xED );
		memory.write8( BASE_PC + 1, 0x43 );
		memory.write16( BASE_PC + 2, 0xF00D );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 4
		Assert.assertEquals( BASE_PC + 4, this.registers.getPc() );
		
		// The memory address that the word param pointed to should contain the value that was in BC
		Assert.assertEquals( 0x4243, this.memory.read16(0xF00D) );
	}
	
	@Test
	public void testLD_WordPointerDE()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xED );
		memory.write8( BASE_PC + 1, 0x53 );
		memory.write16( BASE_PC + 2, 0xF00D );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 4
		Assert.assertEquals( BASE_PC + 4, this.registers.getPc() );
		
		// The memory address that the word param pointed to should contain the value that was in DE
		Assert.assertEquals( 0x4445, this.memory.read16(0xF00D) );
	}
	
	@Test
	public void testLD_WordPointerHL2()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xED );
		memory.write8( BASE_PC + 1, 0x63 );
		memory.write16( BASE_PC + 2, 0xF00D );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 4
		Assert.assertEquals( BASE_PC + 4, this.registers.getPc() );
		
		// The memory address that the word param pointed to should contain the value that was in HL
		Assert.assertEquals( 0x484C, this.memory.read16(0xF00D) );
	}
	
	@Test
	public void testLD_WordPointerIX()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xDD );
		memory.write8( BASE_PC + 1, 0x22 );
		memory.write16( BASE_PC + 2, 0xF00D );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 4
		Assert.assertEquals( BASE_PC + 4, this.registers.getPc() );
		
		// The memory address that the word param pointed to should contain the value that was in IX
		Assert.assertEquals( 0xCAFE, this.memory.read16(0xF00D) );
	}
	
	@Test
	public void testLD_WordPointerIY()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xFD );
		memory.write8( BASE_PC + 1, 0x22 );
		memory.write16( BASE_PC + 2, 0xF00D );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 4
		Assert.assertEquals( BASE_PC + 4, this.registers.getPc() );
		
		// The memory address that the word param pointed to should contain the value that was in IY
		Assert.assertEquals( 0xBEEF, this.memory.read16(0xF00D) );
	}
	
	@Test
	public void testLD_WordPointerSP()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xED );
		memory.write8( BASE_PC + 1, 0x73 );
		memory.write16( BASE_PC + 2, 0xF00D );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 4
		Assert.assertEquals( BASE_PC + 4, this.registers.getPc() );
		
		// The memory address that the word param pointed to should contain the value that was in SP
		Assert.assertEquals( BASE_SP, this.memory.read16(0xF00D) );
	}
	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
