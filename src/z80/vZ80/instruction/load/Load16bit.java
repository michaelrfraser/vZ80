package vZ80.instruction.load;

import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.I16bitAccessor;

public class Load16bit implements IInstruction
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private I16bitAccessor dst;
	private I16bitAccessor src;
	private int srcValue;
	
	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public Load16bit( I16bitAccessor dst, int value )
	{
		this.dst = dst;
		this.src = null;
		this.srcValue = value;
	}
	
	public Load16bit( I16bitAccessor dst, I16bitAccessor src )
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
		int value = src == null ? this.srcValue : this.src.get16( vm );
		this.dst.set16( vm, value );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
