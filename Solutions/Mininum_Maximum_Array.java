import java.util.Scanner;

public class Mininum_Maximum_Array
{
	static int min, max, min1, max1;
	
	public static void MinMax(int[] array, int i, int j)
	{
		if (i == j)
		{
			min = max = array[i];
		}
		else if (j == i+1)
		{
			if (array[i] < array[j])
			{
				min = array[i];
				max = array[j];
			}
			else
			{
				max = array[i];
				min = array[j];
			}
		}
		else
		{
			int mid = (i+j)/2;
			MinMax(array, i, mid);
			min1 = min;
			max1 = max;
			MinMax(array, mid+1, j);
			if (max1 > max)
				max = max1;
			if (min1 < min)
				min = min1;
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter size of array: ");
		int size = sc.nextInt();
		int[] array = new int[size];
		System.out.print("Enter array elements: ");
		for (int i=0; i<size; i++)
		{
			array[i] = sc.nextInt();
		}
		MinMax(array, 0, size-1);
		System.out.println("Smallest element: " + min);
		System.out.println("Largest element: " + max);
		sc.close();
	}
}
