public class Knapsack
{
    static void knapsack(int capacity, int[] values, int[] weights, int n)
    {
        int[][] dp = new int[n+1][capacity+1];

        for (int i=0; i<=n; i++)
        {
            for (int j=0; j<=capacity; j++)
            {
                if (i==0 || j==0)
                    dp[i][j] = 0;
                else if (weights[i-1] <= j)
                    dp[i][j] = Math.max(values[i-1] + dp[i-1][j-weights[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println("Max value of knapsack: " + dp[n][capacity]);
    }
    
    public static void main(String[] args)
    {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        int n = values.length;
        knapsack(capacity, values, weights, n);
    }
}
