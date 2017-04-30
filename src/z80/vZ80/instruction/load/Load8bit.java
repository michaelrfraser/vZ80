package vZ80.instruction.load;

import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.I8bitAccessor;

public class Load8bit implements IInstruction
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private I8bitAccessor dst;
	private I8bitAccessor src;
	private int srcValue;
	
	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public Load8bit( I8bitAccessor dst, int value )
	{
		this.dst = dst;
		this.src = null;
		this.srcValue = value;
	}
	
	public Load8bit( I8bitAccessor dst, I8bitAccessor src )
	{
		this.dst = dst;
		this.src = src;
		this.srcValue = -1;
	}
	

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void execute( VirtualMachine vm )
	{
		int value = src == null ? this.srcValue : src.get8( vm );
		this.dst.set8( vm, value );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
