package WoolfandSheep;


public class Sheep {

	private int Sheeprow;
	private int Sheepcol;
	
	public Sheep(int Sheeprow, int Sheepcol)
	{
		this.Sheeprow = Sheeprow;
		this.Sheepcol = Sheepcol;
	}
	public void setSheeprow(int Sheeprow)
	{
		this.Sheeprow = Sheeprow;
	}
	public void setSheepcol(int Sheepcol)
	{
		this.Sheepcol = Sheepcol;
	}
	public int getSheeprow()
	{
		return Sheeprow;
	}
	public int getSheepcol()
	{
		return Sheepcol;
	}
}
