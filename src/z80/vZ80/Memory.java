package vZ80;

public class Memory
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	private static int SIZE = 0xFFFF;

	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private byte[] memory;
	
	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public Memory()
	{
		this.memory = new byte[SIZE + 1];
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	public int read8( int address )
	{
		int wrappedAddress = address & 0xFFFF;		
		return memory[wrappedAddress] & 0xFF;
	}
	
	public void write8( int address, int value )
	{
		int wrappedAddress = address & 0xFFFF;
		memory[wrappedAddress] = (byte)(value & 0xFF);
	}
	
	public int read16( int address )
	{
		int wrappedHiAddress = address & 0xFFFF;
		int wrappedLoAddress = (address + 1) & 0xFFFF;
		
		return (memory[wrappedHiAddress] & 0xFF) << 8 | memory[wrappedLoAddress] & 0xFF;
	}
	
	public void write16( int address, int value )
	{
		int wrappedHiAddress = address & 0xFFFF;
		int wrappedLoAddress = (address + 1) & 0xFFFF;
		
		memory[wrappedHiAddress] = (byte)((value & 0xFF00) >> 8);
		memory[wrappedLoAddress] = (byte)(value & 0xFF);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
