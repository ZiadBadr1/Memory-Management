package first_fit;

public class Process {
	private String Name;
	private int Size;
	private Partition partition;
	int count;
	public void setName(String Name)
	{
		this.Name = Name;
	}
	public void  setSize(int Size)
	{
		this.Size = Size;
	}
	public void setpartituion(Partition partition)
	{
		this.partition = partition;
	}
	public String getName()
	{
		return this.Name;
	}
	public int getSize()
	{
		return this.Size;
	}
	public Partition getPartition()
	{
		return this.partition;
	}
}
