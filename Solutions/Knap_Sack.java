import java.util.Scanner;

public class Knap_Sack
{
	public static double GetMaxValue(int n, int[] weights, int[] values, int capacity)
	{
		double[] ratios = new double[n];
		int[] indices = new int[n];
		for (int i=0; i<n; i++)
		{
			ratios[i] = (double) values[i] / weights[i];
			indices[i] = i;
		}
		
		for (int i=0; i<n-1; i++)
		{
			for (int j=0; j<n-i-1; j++)
			{
				if (ratios[j] < ratios[j+1])
				{
					double tempRatio = ratios[j];
					ratios[j] = ratios[j+1];
					ratios[j+1] = tempRatio;
					
					int tempIndex = indices[j];
					indices[j] = indices[j+1];
					indices[j=1] = tempIndex;
				}
			}
		}
		
		double TotalValue = 0.0;
		int CurrentWeight = 0;
		for (int i=0; i<n && CurrentWeight < capacity; i++)
		{
			int index = i;
			if (CurrentWeight + weights[index] <= capacity)
			{
				CurrentWeight += weights[index];
				TotalValue += values[index];
			}
			else
			{
				int RemainingCapacity = capacity - CurrentWeight;
				TotalValue += values[index] * ((double) RemainingCapacity / weights[index]);
				break; //Knapsack is full
			}
		}
		return TotalValue;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of items: ");
		int n = sc.nextInt();
		
		int[] weights = new int[n];
		System.out.print("Enter weights of each item: ");
		for (int i=0; i<n; i++)
			weights[i] = sc.nextInt();
		
		int[] values = new int[n];
		System.out.print("Enter values of each item: ");
		for (int i=0; i<n; i++)
			values[i] = sc.nextInt();
		
		System.out.print("Enter Knapsack capacity: ");
		int capacity = sc.nextInt();
		
		double maxvalue = GetMaxValue(n, weights, values, capacity);
		System.out.println("Maximum value: " + maxvalue);
		
		sc.close();
	}

}
