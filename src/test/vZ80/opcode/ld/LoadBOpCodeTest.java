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

public class LoadBOpCodeTest
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
	public void testLD_BA()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x47 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// B should contain the value of A
		Assert.assertEquals( 'A', this.registers.getB() );
	}

	@Test
	public void testLD_BB()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x40 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// B should contain the value that was in B
		Assert.assertEquals( 'B', this.registers.getB() );
	}
	
	@Test
	public void testLD_BC()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x41 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// B should contain the value that was in C
		Assert.assertEquals( 'C', this.registers.getB() );
	}
	
	@Test
	public void testLD_BD()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x42 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// B should contain the value that was in D
		Assert.assertEquals( 'D', this.registers.getB() );
	}
	
	@Test
	public void testLD_BE()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x43 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// B should contain the value that was in E
		Assert.assertEquals( 'E', this.registers.getB() );
	}
	
	@Test
	public void testLD_BH()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x44 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// B should contain the value that was in H
		Assert.assertEquals( 'H', this.registers.getB() );
	}
	
	@Test
	public void testLD_BL()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( 0x00, 0x45 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// B should contain the value that was in L
		Assert.assertEquals( 'L', this.registers.getB() );
	}
	
	@Test
	public void testLD_BHLPointer()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x46 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// B should contain the value that HL was pointing to
		Assert.assertEquals( 'X', this.registers.getB() );
	}
	
	@Test
	public void testLD_BIXPlusIndexPointer()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xDD );
		memory.write8( BASE_PC + 1, 0x46 );
		memory.write8( BASE_PC + 2, 0x01 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// B should contain the value that was in the word param
		Assert.assertEquals( 'M', this.registers.getB() );
	}
	
	@Test
	public void testLD_BIYPlusIndexPointer()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0xFD );
		memory.write8( BASE_PC + 1, 0x46 );
		memory.write8( BASE_PC + 2, 0x01 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// B should contain the value that was in the word param
		Assert.assertEquals( 'F', this.registers.getB() );
	}
	
	@Test
	public void testLD_BByte()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x06 );
		memory.write8( BASE_PC + 1, 'F' );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 2
		Assert.assertEquals( BASE_PC + 2, this.registers.getPc() );
		
		// B should contain the value that was in the byte param
		Assert.assertEquals( 'F', this.registers.getB() );
	}
	
	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
