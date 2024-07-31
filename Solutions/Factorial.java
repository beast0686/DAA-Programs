import java.util.Scanner;

public class Factorial
{
	static void factorial(int number)
	{
		int fact = 1;
		if (number == 0)
		{
			fact = 1;
		}
		else
		{
			for (int i=2; i<=number; i++)
			{
				fact = fact * i;
			}
		}
		System.out.println("Factorial: " + fact);
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number: ");
		int n = sc.nextInt();
		factorial(n);
		sc.close();
	}

}
