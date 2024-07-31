public class JobAssignment
{
    static int N = 4;
    static int[][] cost = {
        {9, 2, 7, 8}, {6, 4, 3, 7}, {5, 8, 1, 8}, {7, 6, 9, 4}
    };
    static boolean[] assigned = new boolean[N];
    static int minCost = Integer.MAX_VALUE;

    static void findMinCost(int person, int currentCost)
    {
        if (person == N)
        {
            if (currentCost < minCost)
            {
                minCost = currentCost;
            }
            return;
        }

        for (int job=0; job<N; job++)
        {
            if (!assigned[job])
            {
                assigned[job] = true;
                findMinCost(person+1, currentCost+cost[person][job]);
                assigned[job] = false;
            }
        }
    }

    public static void main(String[] args)
    {
        findMinCost(0, 0);
        System.out.println("Minimum cost: " + minCost);
    }
}
