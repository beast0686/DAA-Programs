import java.util.Scanner;

public class Linear_Search
{
	static void LinearSearch(int[] array, int size, int search)
	{
		int found = 0;
		for (int i=0; i<size; i++)
		{
			if (array[i] == search)
			{
				found = i;
			}
		}
		if (found == 0)
		{
			System.out.print("Element not found!");
		}
		else
		{
			System.out.print("Element found at index position: " + found);
		}
	}
	
	static void PrintArray(int[] array, int size)
	{
		System.out.println("Array elements: ");
		for (int i=0; i<size; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
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
		PrintArray(array, size);
		System.out.print("Enter element to find: ");
		int search = sc.nextInt();
		LinearSearch(array, size, search);
		sc.close();
	}

}
