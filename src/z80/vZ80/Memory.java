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
		int wrappedAddress = address & SIZE;
		return memory[wrappedAddress] & 0xFF;
	}
	
	public void write8( int address, int value )
	{
		int wrappedAddress = address & SIZE;
		memory[wrappedAddress] = (byte)(value & 0xFF);
	}
	
	public int read16( int address )
	{
		int wrappedLoAddress = address & SIZE;
		int wrappedHiAddress = (address + 1) & SIZE;
		
		return (memory[wrappedHiAddress] & 0xFF) << 8 | memory[wrappedLoAddress] & 0xFF;
	}
	
	public void write16( int address, int value )
	{
		int wrappedLoAddress = address & SIZE;
		int wrappedHiAddress = (address + 1) & SIZE;
		
		memory[wrappedLoAddress] = (byte)(value & 0xFF);
		memory[wrappedHiAddress] = (byte)((value & 0xFF00) >> 8);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
