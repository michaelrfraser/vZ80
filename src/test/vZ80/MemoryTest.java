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
package vZ80;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MemoryTest
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
	public void testGetSetMemory8()
	{
		Memory memory = new Memory();
		
		// Set values at arbitrary points in memory
		memory.write8( 0x0AA0, 0x0F );
		memory.write8( 0xA00A, 0xF0 );
		memory.write8( 0x000F, 0xFF );
		memory.write8( 0xF000, 0x01 );
		
		// Ensure they can be read out correctly
		Assert.assertEquals( 0x0F, memory.read8(0x0AA0) );
		Assert.assertEquals( 0xF0, memory.read8(0xA00A) );
		Assert.assertEquals( 0xFF, memory.read8(0x000F) );
		Assert.assertEquals( 0x01, memory.read8(0xF000) );
	}

	@Test
	public void testGetSetMemory16()
	{
		Memory memory = new Memory();
		
		// Set values at arbitrary points in memory
		memory.write16( 0x0AA0, 0x0FF0 );
		memory.write16( 0xA00A, 0xF00F );
		
		// Ensure they can be read out correctly
		Assert.assertEquals( 0x0FF0, memory.read16(0x0AA0) );
		Assert.assertEquals( 0xF00F, memory.read16(0xA00A) );
		
		// Ensure that the values are stored in little endian format
		Assert.assertEquals( 0xF0, memory.read8(0x0AA0) );
		Assert.assertEquals( 0x0F, memory.read8(0x0AA1) );
		
		Assert.assertEquals( 0x0F, memory.read8(0xA00A) );
		Assert.assertEquals( 0xF0, memory.read8(0xA00B) );
	}
	
	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
