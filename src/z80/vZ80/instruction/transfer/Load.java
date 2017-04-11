package vZ80.instruction.transfer;

import vZ80.VirtualMachine;
import vZ80.instruction.IInstruction;
import vZ80.instruction.access.IDataDestination;
import vZ80.instruction.access.IDataSource;

public class Load implements IInstruction
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private IDataDestination dst;
	private IDataSource src;
	
	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public Load( IDataDestination dst, IDataSource src )
	{
		this.dst = dst;
		this.src = src;
	}
	

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	@Override
	public void execute( VirtualMachine vm )
	{
		int value = this.src.getData( vm );
		this.dst.setData( vm, value );
	}

	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
