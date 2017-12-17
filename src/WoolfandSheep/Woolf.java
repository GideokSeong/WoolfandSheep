package WoolfandSheep;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class Woolf {

	private int woolfrow;
	private int woolfcol;
	
	public Woolf(int woolfrow,int woolfcol)
	{
		this.woolfrow=woolfrow;
		this.woolfcol=woolfcol;
	}
	public void setWoolfrow(int woolfrow)
	{
		this.woolfrow = woolfrow;
	}
	public void setWoolfcol(int woolfcol)
	{
		this.woolfcol = woolfcol;
	}
	public int getWoolfrow()
	{
		return woolfrow;
	}
	public int getWoolfcol()
	{
		return woolfcol;
	}
}

