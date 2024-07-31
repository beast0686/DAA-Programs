import java.util.Scanner;

public class Quick_Sort
{
	public static void swap(int[] array, int i, int j)
	{
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static int Index(int[] array, int low, int high)
	{
		int pivot = array[high];
		int i = low;
		
		for (int j=low; j<high; j++)
		{
			if (array[j] <= pivot)
			{
				swap(array, i, j);
				i++;
			}
		}
		swap(array, i, high);
		return i;
	}
	
	public static void QuickSort(int[] array, int low, int high)
	{
		int pivot;
		if (low < high)
		{
			pivot = Index(array, low, high);
			QuickSort(array, low, pivot-1);
			QuickSort(array, pivot+1, high);
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
		QuickSort(array, 0, size-1);
		System.out.print("Sorted array: ");
		PrintArray(array, size);
		sc.close();
	}
}
