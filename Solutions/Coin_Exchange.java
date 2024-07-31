import java.util.Arrays;
import java.util.Scanner;

public class Coin_Exchange
{
	public static void FindMinimumCoins(int[] coins, int denominations, int amount)
	{
		Arrays.sort(coins);
		int n = denominations;
		int[] CoinCount = new int[n];
		
		for (int i=n-1; i>=0; i--)
		{
			while (amount >= coins[i])
			{
				amount = amount - coins[i];
				CoinCount[i]++;
			}
		}
		
		System.out.println("Coins required to form the amount: ");
		for (int i=n-1; i>=0; i--)
		{
			if (CoinCount[i] != 0)
			{
				System.out.print(coins[i] + " coins: " + CoinCount[i]);
			}
		}
	}
	
	public static void main(String[] args)
	{
		 Scanner scanner = new Scanner(System.in);
	     System.out.print("Enter number of denominations: ");
	     int denominations = scanner.nextInt();

	     int[] coins = new int[denominations];
	     System.out.print("Enter denominations: ");
	     for (int i=0; i<denominations; i++)
	         coins[i] = scanner.nextInt();

	     System.out.print("Enter amount: ");
	     int amount = scanner.nextInt();

	     FindMinimumCoins(coins, denominations, amount);
	     scanner.close();
	}
}
