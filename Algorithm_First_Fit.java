package first_fit;

import java.util.ArrayList;

public class Algorithm {
	int numofPartitons;
	int numofProcess;
	ArrayList<Process> process;
	ArrayList<Partition> partition;
	int counter;
	public Algorithm(int numofPartitons,int numofProcess,ArrayList<Process> process,ArrayList<Partition> partition)
	{
		this.numofPartitons = numofPartitons;
		this.numofProcess = numofProcess;
		this.process = process;
		this.partition = partition;
		counter = numofPartitons;
		for(int i = 0 ; i < numofProcess;i++)
		{
			for(int j = 0 ; j < partition.size();j++)
			{
				if(partition.get(j).getProcess() == null && partition.get(j).getSize() >= process.get(i).getSize())
				{
					partition.get(j).setProcess(process.get(i));
					process.get(i).setpartituion(partition.get(j));
					int SizeOfNewPartition = partition.get(j).getSize()-partition.get(j).getProcess().getSize();
					partition.get(j).setSize(partition.get(j).getProcess().getSize());
					if(SizeOfNewPartition > 0)
					{
						String Name = "Paertition" + numofPartitons ;
						Partition newpartition =  new Partition();
						newpartition.setName(Name);
						newpartition.setSize(SizeOfNewPartition);
						newpartition.count = this.counter;
						this.counter++;
						partition.add(j + 1, newpartition);
					}
					break;
				}
			}	
		}
		for(int i = 0 ; i < partition.size();i++)
		{
			if(partition.get(i).getProcess() != null)
			{
				System.out.println("Partition " + partition.get(i).count + " ( " + partition.get(i).getSize() + " KB ) => " + "Process " + partition.get(i).getProcess().count);
			}
			else
			{
				System.out.println("Partition " + partition.get(i).count + " ( " + partition.get(i).getSize() + " KB ) => External Fragment");

			}
		}
		for(int i = 0 ; i < numofProcess;i++)
		{
			if(process.get(i).getPartition() == null)
			{
				System.out.println("Process " + process.get(i).count + " can not be allocated");
			}
		}
	}
	public void Compaction()
	{
		int EmptySize = 0;
		for(int i = 0 ; i < partition.size();i++)
		{
			if(partition.get(i).getProcess() == null)
			{
				EmptySize +=partition.get(i).getSize();
				partition.remove(i);
				i--;
			}
		}
		if(EmptySize > 0)
		{
			Partition NewPartition = new Partition();
			NewPartition.setSize(EmptySize);
			NewPartition.count = counter;
			counter++;
			partition.add(NewPartition);
			Partition p = NewPartition;
			for(int i = 0 ; i < numofProcess;i++)
			{
				if(process.get(i).getPartition() == null)
				{
					if(process.get(i).getSize() <= p.getSize())
					{
						p.setProcess(process.get(i));
						process.get(i).setpartituion(p);
						int newsize = p.getSize() - process.get(i).getSize();
						p.setSize(process.get(i).getSize());
						if(newsize > 0)
						{
							Partition NewPartition2 = new Partition();
							NewPartition2.setSize(newsize);
							NewPartition2.count = counter;
							counter++;
							p = NewPartition2;
							partition.add(p);
						}
						else
						{
							break;
						}
							
 					}
				}
			}
		}
		for(int i = 0 ; i < partition.size();i++)
		{
			if(partition.get(i).getProcess() != null)
			{
				System.out.println("Partition " + partition.get(i).count + " ( " + partition.get(i).getSize() + " KB ) => " + "Process " + partition.get(i).getProcess().count);
			}
			else
			{
				System.out.println("Partition " + partition.get(i).count + " ( " + partition.get(i).getSize() + " KB ) => External Fragment");

			}
		}
		for(int i = 0 ; i < numofProcess;i++)
		{
			if(process.get(i).getPartition() == null)
			{
				System.out.println("Process " + process.get(i).count + " can not be allocated");
			}
		}
	}
	
}
