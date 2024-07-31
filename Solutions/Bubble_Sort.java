import java.util.Scanner;

public class Bubble_Sort
{
	static void BubbleSort(int[] array, int size)
	{
        for (int i=0; i<size; i++)
        {
        	for (int j=0; j<size-i-1; j++)
        	{
        		if (array[j+1] < array[j])
        		{
        			int temp = array[j];
        			array[j] = array[j+1];
        			array[j+1] = temp;
        		}
        	}
        }
    }

	static void PrintArray(int[] array, int size)
	{
		
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
		System.out.print("Unsorted array: ");
		PrintArray(array, size);
		BubbleSort(array, size);
		System.out.print("Sorted array: ");
		PrintArray(array, size);
		sc.close();

	}
}
