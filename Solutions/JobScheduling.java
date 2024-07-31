import java.util.Scanner;

public class JobScheduling
{
	public static void ScheduleJobs(int n, int[] jobID, int[] deadline, int[] profit)
	{
		for (int i=0; i<n-1; i++)
		{
			for (int j=0; j<n-i-1; j++)
			{
				if (profit[j+1] > profit[j])
				{
					int tempJobID = jobID[j];
					jobID[j] = jobID[j+1];
					jobID[j+1] = tempJobID;
					
					int tempDeadline = deadline[j];
					deadline[j] = deadline[j+1];
					deadline[j+1] = tempDeadline;
					
					int tempProfit = profit[j];
					profit[j] = profit[j+1];
					profit[j+1] = tempProfit;
				}
			}
		}
		
		boolean[] slots = new boolean[n];
		int[] result = new int[n];
		int TotalProfit = 0;
		for (int i=0; i<n; i++)
		{
			for (int j=Math.min(n,  deadline[i])-1; j>=0; j++)
			{
				if (!slots[j])
				{
					slots[j] = true;
					result[i] = jobID[i];
					TotalProfit += profit[i];
				}
			}
		}
		
		System.out.print("Job Sequence: ");
		for (int i=0; i<n; i++)
		{
			System.out.print(result[i] + " ");
		}
		System.out.println();
		System.out.print("Total Profit: " + TotalProfit);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of jobs: ");
		int n = sc.nextInt();
		
		int[] jobID = new int[n];
		int[] deadline = new int[n];
		int[] profit = new int[n];
		for (int i=0; i<n; i++)
			jobID[i] = i+1;
		System.out.print("Enter deadline of each job: ");
		for (int i=0; i<n; i++)
			deadline[i] = i+1;
		System.out.print("Enter profit of each job: ");
		for (int i=0; i<n; i++)
			profit[i] = i+1;
		
		ScheduleJobs(n, jobID, deadline, profit);
		sc.close();
	}
}
