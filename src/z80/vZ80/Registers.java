package vZ80;

public class Registers
{
	//----------------------------------------------------------
	//                    STATIC VARIABLES
	//----------------------------------------------------------
	public static final byte C_MASK = 0x01;
	public static final byte N_MASK = 0x02;
	public static final byte P_MASK = 0x04;
	public static final byte H_MASK = 0x10;
	public static final byte Z_MASK = 0x40;
	public static final byte S_MASK = (byte)0x80;
	
	//----------------------------------------------------------
	//                   INSTANCE VARIABLES
	//----------------------------------------------------------
	private byte a;
	private byte f;
	
	// General Purpose Registers
	private byte b;
	private byte c;
	private byte d;
	private byte e;
	private byte h;
	private byte l;
	
	// Special Purpose Registers
	private byte i;
	private byte r;
	private short ix;
	private short iy;
	private short sp;
	private short pc;
	
	//----------------------------------------------------------
	//                      CONSTRUCTORS
	//----------------------------------------------------------
	public Registers()
	{
		
	}

	//----------------------------------------------------------
	//                    INSTANCE METHODS
	//----------------------------------------------------------
	public int getA()
	{
		return (int)(a & 0xFF);
	}
	
	public void setA( int a )
	{
		this.a = (byte)(a & 0xFF);
	}

	public int getF()
	{
		return (int)(f & 0xFF);
	}

	public void setF( int f )
	{
		this.f = (byte)(f & 0xFF);
	}
	
	public int getAF()
	{
		return (a & 0xFF) << 8 | f & 0xFF;
	}
	
	public void setAF( int af )
	{
		this.a = (byte)((af & 0xFF00) >> 8);
		this.f = (byte)((af & 0x00FF));
	}
	
	public int getB()
	{
		return (int)(b & 0xFF);
	}
	
	public void setB( int b )
	{
		this.b = (byte)(b & 0xFF);
	}

	public int getC()
	{
		return (int)(c & 0xFF);
	}

	public void setC( int c )
	{
		this.c = (byte)(c & 0xFF);
	}
	
	public int getBC()
	{
		return (b & 0xFF) << 8 | c & 0xFF;
	}
	
	public void setBC( int bc )
	{
		this.b = (byte)((bc & 0xFF00) >> 8);
		this.c = (byte)((bc & 0x00FF));
	}
	
	public int getD()
	{
		return (int)(d & 0xFF);
	}
	
	public void setD( int d )
	{
		this.d = (byte)(d & 0xFF);
	}

	public int getE()
	{
		return (int)(e & 0xFF);
	}

	public void setE( int e )
	{
		this.e = (byte)(e & 0xFF);
	}
	
	public int getDE()
	{
		return (d & 0xFF) << 8 | e & 0xFF;
	}
	
	public void setDE( int de )
	{
		this.d = (byte)((de & 0xFF00) >> 8);
		this.e = (byte)((de & 0x00FF));
	}
	
	public int getH()
	{
		return (int)(h & 0xFF);
	}
	
	public void setH( int h )
	{
		this.h = (byte)(h & 0xFF);
	}

	public int getL()
	{
		return (int)(l & 0xFF);
	}

	public void setL( int l )
	{
		this.l = (byte)(l & 0xFF);
	}
	
	public int getHL()
	{
		return (h & 0xFF) << 8 | l & 0xFF;
	}
	
	public void setHL( int hl )
	{
		this.h = (byte)((hl & 0xFF00) >> 8);
		this.l = (byte)((hl & 0x00FF));
	}
	
	/*
	public int getI()
	{
		return i;
	}

	public void setI( int i )
	{
		this.i = i;
	}

	public int getR()
	{
		return r;
	}

	public void setR( int r )
	{
		this.r = r;
	}
	*/
	public int getIX()
	{
		return ix & 0xFFFF;
	}

	public void setIX( int ix )
	{
		this.ix = (short)(ix & 0xFFFF);;
	}

	public int getIY()
	{
		return iy & 0xFFFF;
	}

	public void setIY( int iy )
	{
		this.iy = (short)(iy & 0xFFFF);
	}
	
	public int getSP()
	{
		return sp & 0xFFFF;
	}

	public void setSP( int sp )
	{
		this.sp = (short)(sp & 0xFFFF);
	}
	/*
	public int getPc()
	{
		return pc;
	}

	public void setPc( int pc )
	{
		this.pc = pc;
	}
	*/
	
	////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////// Accessor and Mutator Methods ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////

	//----------------------------------------------------------
	//                     STATIC METHODS
	//----------------------------------------------------------
}
