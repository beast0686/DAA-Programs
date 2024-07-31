import java.util.Scanner;

public class Selection_Sort
{
	static void PrintArray(int[] array, int size)
	{
		
		for (int i=0; i<size; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	static void SelectionSort(int[] array, int size)
	{
        for (int i=0; i<size-1; i++)
        {
        	int min_index = i;
        	for (int j=i+1; j<size; j++)
        	{
        		if (array[j] < array[min_index])
        		{
        			min_index = j;
        		}
        	}
        	
        	int temp = array[min_index];
        	array[min_index] = array[i];
        	array[i] = temp;
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
		System.out.print("Unsorted array: ");
		PrintArray(array, size);
		SelectionSort(array, size);
		System.out.print("Sorted array: ");
		PrintArray(array, size);
		sc.close();
	}

}
