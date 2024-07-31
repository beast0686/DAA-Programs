import java.util.Scanner;

public class Binary_Search
{
	public static void BinarySearch(int[] array, int size, int search)
	{
		int low = 0;
		int high = size - 1;
		while (low <= high)
		{
			int mid = (low + high)/2;
			if (search == array[mid])
			{
				System.out.print("Enter found at index position: " + mid);
				System.exit(mid);
			}
			else if (search < array[mid])
			{
				high = mid - 1;
			}
			else if (search > array[mid])
			{
				low = mid + 1;
			}
			else
			{
				break;
			}
		}
		System.out.print("Element not found!");
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter array size: ");
		int size = sc.nextInt();
		int[] array = new int[size];
		System.out.print("Enter array elements: ");
		for (int i=0; i<size; i++)
			array[i] = sc.nextInt();
		System.out.print("Enter search element: ");
		int search = sc.nextInt();
		BinarySearch(array, size, search);
		sc.close();
	}
}
