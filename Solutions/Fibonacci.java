import java.util.Scanner;

public class Fibonacci
{
	static void fibo(int number)
	{
		int n1 = 0;
		int n2 = 1;
		System.out.print("Fibonacci Series: ");
		System.out.print(n1 + " ");
		System.out.print(n2 + " ");
		for (int i=1; i<number; i++)
		{
			int n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(n3 + " ");	
		}
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter range limit: ");
		int n = sc.nextInt();
		fibo(n);
		sc.close();
	}

}
