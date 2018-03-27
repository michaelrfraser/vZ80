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

public class LoadAOpCodeTest
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
		
		this.memory = this.vm.getRam();
		
		this.memory.write8( 0x484C, 'X' );       // (HL)
		this.memory.write8( 0x4243, 'Y' );       // (BC)
		this.memory.write8( 0x4445, 'Z' );       // (DE)
		
		this.memory.write8( 0xCAFE, 'M' );
		this.memory.write8( 0xCAFF, 'R' );
		
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
	public void testLD_AA()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x7F );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// A should contain the value of A
		Assert.assertEquals( 'A', this.registers.getA() );
	}

	@Test
	public void testLD_AB()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x78 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// A should contain the value that was in B
		Assert.assertEquals( 'B', this.registers.getA() );
	}
	
	@Test
	public void testLD_AC()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x79 );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// A should contain the value that was in C
		Assert.assertEquals( 'C', this.registers.getA() );
	}
	
	@Test
	public void testLD_AD()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x7A );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// A should contain the value that was in D
		Assert.assertEquals( 'D', this.registers.getA() );
	}
	
	@Test
	public void testLD_AE()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x7B );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// A should contain the value that was in E
		Assert.assertEquals( 'E', this.registers.getA() );
	}
	
	@Test
	public void testLD_AH()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x7C );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// A should contain the value that was in H
		Assert.assertEquals( 'H', this.registers.getA() );
	}
	
	@Test
	public void testLD_AL()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( 0x00, 0x7D );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// A should contain the value that was in L
		Assert.assertEquals( 'L', this.registers.getA() );
	}
	
	@Test
	public void testLD_AHLPointer()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x7E );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// A should contain the value that HL was pointing to
		Assert.assertEquals( 'X', this.registers.getA() );
	}
	
	@Test
	public void testLD_ABCPointer()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x0A );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// A should contain the value that BC was pointing to
		Assert.assertEquals( 'Y', this.registers.getA() );
	}
	
	@Test
	public void testLD_ADEPointer()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x1A );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 1
		Assert.assertEquals( BASE_PC + 1, this.registers.getPc() );
		
		// A should contain the value that BC was pointing to
		Assert.assertEquals( 'Z', this.registers.getA() );
	}
	
	@Test
	public void testLD_AWordPointer()
	{
		// Set the opcode as the first instruction in memory
		memory.write8( BASE_PC, 0x3A );
		memory.write16( BASE_PC + 1, 0xCAFE );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 2
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// A should contain the value that was in the word param
		Assert.assertEquals( 'M', this.registers.getA() );
	}
	
	@Test
	public void testLD_AIXPlusIndexPointer()
	{
		// Set the opcode as the first instruction in memory
		memory.write16( BASE_PC, 0xDD7E );
		memory.write8( BASE_PC + 2, 0x01 );
		
		registers.setIX( 0xCAFE );
		
		// Execute
		this.vm.tick();
		
		// PC should have incremented by 3
		Assert.assertEquals( BASE_PC + 3, this.registers.getPc() );
		
		// A should contain the value that was in the word param
		Assert.assertEquals( 'R', this.registers.getA() );
	}
	
	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
