import java.util.Scanner;

public class Merge_sort
{
	public static void Merge(int[] array, int low, int mid, int high)
	{
		int i, j, k;
		int[] temp = new int[10000000];
		i = low;
		k = 0;
		j = mid+1;
		
		while((i<=mid) && (j<=high))
		{
			if (array[i] < array[j])
			{
				temp[k] = array[i];
				i++;
			}
			else
			{
				temp[k] = array[j];
				j++;
			}
			k++;
		}
		
		while (i<=mid)
		{
			temp[k++] = array[i++];
		}
		
		while (j<=high)
		{
			temp[k++] = array[j++];
		}
		
		for (i=low, k=0; i<=high; i++, k++)
		{
			array[i] = temp[k];
		}
	}
	
	public static void MergeSort(int[] array, int low, int high)
	{
		int mid;
		if (low < high)
		{
			mid = (high + low)/2;
			MergeSort(array, low, mid);
			MergeSort(array, mid+1, high);
			Merge(array, low, mid, high);
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
		MergeSort(array, 0, size-1);
		System.out.print("Sorted array: ");
		PrintArray(array, size);
		sc.close();
	}

}
