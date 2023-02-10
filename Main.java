package first_fit;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner myinput = new Scanner(System.in);
		boolean flag = true ;
		while(flag)
		{
			int numofprocess ;
			int numofpartitons;
			ArrayList<Process> process = new ArrayList<Process>();
			ArrayList<Partition> Partitions = new ArrayList<Partition>();
			System.out.print("Please Enter Number Of Partitons : ");
			numofpartitons = myinput.nextInt();
			int counter =0;
			for(int i = 0 ; i < numofpartitons;i++)
			{
				Partition obj = new Partition();
				System.out.print("Please Enter Name Of Partitons  And Size : ");
				obj.setName(myinput.next());
				obj.setSize(myinput.nextInt());
				obj.count = counter;
				counter++;
				Partitions.add(obj);
			}
			counter = 1;
			System.out.print("Please Enter Number Of process : ");
			numofprocess = myinput.nextInt();
			for(int i = 0 ; i < numofprocess;i++)
			{
				Process obj = new Process();
				System.out.print("Please Enter Name Of Process  And Size : ");
				obj.setName(myinput.next());
				obj.setSize(myinput.nextInt());
				obj.count = counter;
				counter++;
				process.add(obj);
			}
			System.out.println("Select the policy you want to apply: ");
			System.out.println("1. First fit ");
			System.out.println("2. Best fit ");
			System.out.println("3. Worst fit ");
			int ch = myinput.nextInt();
			switch(ch)
			{
				case 1 :
				{
					Algorithm First_Fit = new Algorithm(numofpartitons,numofprocess,process,Partitions);
					System.out.println("Do you want to compact? 1.yes 2.no");
					int num = myinput.nextInt();
					if(num == 1)
					{
						First_Fit.Compaction();
						flag= false;
						break;
					}
					else
						flag= false;
					break;
				}
				case 2 :
				{
					Algorithm_best_Fit  Best_Fit= new Algorithm_best_Fit(numofpartitons,numofprocess,process,Partitions);
					System.out.println("Do you want to compact? 1.yes 2.no");
					int num = myinput.nextInt();
					if(num == 1)
					{
						Best_Fit.Compaction();
						flag= false;
						break;
					}

					else
						flag= false;
					break;
				}
				case 3:
				{
					Algoritm_Worst_Fit  Worst_Fit= new Algoritm_Worst_Fit(numofpartitons,numofprocess,process,Partitions);
					System.out.println("Do you want to compact? 1.yes 2.no");
					int num = myinput.nextInt();
					if(num == 1)
					{
						Worst_Fit.Compaction();
						flag = false;
						break;
					}
					else
						flag= false;
					break;
				}
			}
		}

	}
}