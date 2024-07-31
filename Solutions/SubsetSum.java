public class SubsetSum
{
    static boolean exists(int[] set, int n, int sum)
    {
        if (sum == 0) return true;
        if (n == 0) return false;
        if (set[n-1] > sum) return exists(set, n-1, sum);
        return exists(set, n-1, sum) || exists(set, n-1, sum-set[n-1]);
    }

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        boolean result = exists(set, set.length, sum);

        if (result) {
            System.out.println("Found a subset with given sum");
        } else {
            System.out.println("No subset with given sum");
            System.out.println("Not found");
        }
    }
}
