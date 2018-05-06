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

import vZ80.RegisterFile;
import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.I8bitAccessor;

public class Add8bit implements IInstruction
{

	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private I8bitAccessor operand;

	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public Add8bit( I8bitAccessor operand )
	{
		this.operand = operand;
	}
	

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void execute( VirtualMachine vm )
	{
		RegisterFile reg = vm.getRegisters();
		int a = reg.getA();
		int flags = 0;
		
		int operandValue = operand.get8( vm );
		int newValue = a + operandValue;
		
		// C (Carry) 
		if( newValue > 0xFF )
			flags |= 0x01;
		
		// N (Add/Subtract)
		
		// P/V (Overflow)
		if( newValue > 127 || newValue < -127 )
			flags |= 0x04;
		
		// H (Half Carry)
		if( ((a & 0x0F) + (a  & 0x0F)) > 0x0F )
			flags |= 0x10;
		
		// Z (Zero)
		if( (newValue & 0xFF) == 0 )
			flags |= 0x40;
		
		// S (Sign)
		if( (newValue & 0x80) == 1 )
			flags |= 0x80;
		
		reg.setF( flags );
		reg.setA( newValue );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
