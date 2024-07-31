import java.util.Scanner;

public class Fibonacci_Series
{
    public static void FibonacciSeries(int numner)
    {
        int n1 = 0;
        int n2 = 1;
        System.out.print(n1 + " " + n2 + " ");
        for (int i = 2; i <= numner; i++)
        {
            int n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            System.out.print(n3 + " ");
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.print("Fibonacci Series: ");
        FibonacciSeries(number);
        scanner.close();
    }
}
