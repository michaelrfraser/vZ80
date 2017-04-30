package vZ80;

import vZ80.instruction.IInstruction;
import vZ80.instruction.InstructionDecoder;

public class VirtualMachine
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private RegisterFile registers;
	private InstructionDecoder decoder;
	private Memory ram;
	
	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public VirtualMachine()
	{
		this.ram = new Memory();
		this.registers = new RegisterFile();
		this.decoder = new InstructionDecoder( this );
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	public void tick()
	{
		IInstruction nextInstruction = this.decoder.fetchNext();
		nextInstruction.execute( this );
	}

	public RegisterFile getRegisters()
	{
		return this.registers;
	}
	
	public Memory getRam()
	{
		return this.ram;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
	
}
