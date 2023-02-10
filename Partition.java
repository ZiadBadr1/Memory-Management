package first_fit;

public class Partition {
	private String Name;
	private int Size;
	private Process p;
	int count;
	public void setName(String Name)
	{
		this.Name = Name;
	}
	public void  setSize(int Size)
	{
		this.Size = Size;
	}
	public void  setProcess(Process p)
	{
		this.p = p;
	}
	public String getName()
	{
		return this.Name;
	}
	public int getSize()
	{
		return this.Size;
	}
	public Process  getProcess()
	{
		return this.p;
	}
	
}
