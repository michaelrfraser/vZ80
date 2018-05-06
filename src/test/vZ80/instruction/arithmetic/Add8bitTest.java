/*
 *   Copyright 2017 Calytrix Technologies
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
package vZ80.instruction.arithmetic;

import org.junit.Assert;
import org.junit.Test;

import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.A;
import vZ80.instruction.access.B;
import vZ80.instruction.access.C;
import vZ80.instruction.access.D;

public class Add8bitTest
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
	public void testAddA_A()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Set initial value for A
		reg.setA( 0x01 );
		
		// Create and execute the add instruction
		IInstruction add = new Add8bit( A.instance );
		add.execute( vm );
		
		// A should now equal A + Operand
		Assert.assertEquals( 0x02, reg.getA() );
		
		int flags = reg.getF();
		
		// Carry flag should be 0
		Assert.assertTrue( (flags & 0x01) == 0 );
		
		// Add/Subtract flag should be 0
		Assert.assertTrue( (flags & 0x02) == 0 );
		
		// Overflow flag should be 0
		Assert.assertTrue( (flags & 0x04) == 0 );
		
		// Half Carry?
		
		// Zero flag should be 0
		Assert.assertTrue( (flags & 0x40) == 0 );
		
		// Sign flag should be 0
		Assert.assertTrue( (flags & 0x80) == 0 );
	}
	
	@Test
	public void testAddA_A_Zero()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Set initial value for A
		reg.setA( 0x00 );
		
		// Create and execute the add instruction
		IInstruction add = new Add8bit( A.instance );
		add.execute( vm );
		
		// A should now equal A + Operand
		Assert.assertEquals( 0x00, reg.getA() );
		
		int flags = reg.getF();
		
		// Carry flag should be 0
		Assert.assertTrue( (flags & 0x01) == 0 );
		
		// Add/Subtract flag should be 0
		Assert.assertTrue( (flags & 0x02) == 0 );
		
		// Overflow flag should be 0
		Assert.assertTrue( (flags & 0x04) == 0 );
		
		// Half Carry?
		
		// Zero flag should be 1
		Assert.assertTrue( (flags & 0x40) != 0 );
		
		// Sign flag should be 0
		Assert.assertTrue( (flags & 0x80) == 0 );
	}
	
	@Test
	public void testAddA_A_Carryover()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Set initial value for A
		reg.setA( 0xF3 );
		
		// Create and execute the add instruction
		IInstruction add = new Add8bit( A.instance );
		add.execute( vm );
		
		// A should now equal A + Operand with Carry flag set
		Assert.assertEquals( 0xE6, reg.getA() );
		
		int flags = reg.getF();
		
		// Carry flag should be 1
		Assert.assertTrue( (flags & 0x01) != 0 );
		
		// Add/Subtract flag should be 0
		Assert.assertTrue( (flags & 0x02) == 0 );
		
		// Overflow flag should be 1
		Assert.assertTrue( (flags & 0x04) != 0 );
		
		// Half Carry?
		
		// Zero flag should be 0
		Assert.assertTrue( (flags & 0x40) == 0 );
		
		// Sign flag should be 0
		Assert.assertTrue( (flags & 0x80) == 0 );
	}
	
	@Test
	public void testAddA_B()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Set initial value for A
		reg.setA( 0x30 );
		
		// Set initial value for the operand
		reg.setB( 0x1F );
		
		// Create and execute the add instruction
		IInstruction add = new Add8bit( B.instance );
		add.execute( vm );
		
		// A should now equal A + Operand
		Assert.assertEquals( 0x4F, reg.getA() );
	}
	
	@Test
	public void testAddA_C()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Set initial value for A
		reg.setA( 0x30 );
		
		// Set initial value for the operand
		reg.setC( 0x1F );
		
		// Create and execute the add instruction
		IInstruction add = new Add8bit( C.instance );
		add.execute( vm );
		
		// A should now equal A + Operand
		Assert.assertEquals( 0x4F, reg.getA() );
	}
	
	@Test
	public void testAddA_D()
	{
		VirtualMachine vm = new VirtualMachine();
		RegisterFile reg = vm.getRegisters();
		
		// Set initial value for A
		reg.setA( 0x30 );
		
		// Set initial value for the operand
		reg.setD( 0x1F );
		
		// Create and execute the add instruction
		IInstruction add = new Add8bit( D.instance );
		add.execute( vm );
		
		// A should now equal A + Operand
		Assert.assertEquals( 0x4F, reg.getA() );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
