public class FloydWarshall
{
    public static void floyd(int[][] w, int n)
    {
        int i ,j ,k;

        for (k=0; k<n; k++)
        {
            for (i=0; i<n; i++)
            {
                for (j=0; j<n; j++)
                {
                    //w[i][j] = Math.min(w[i][j], w[i][k] + w[k][j]);
                    w[i][j] = (w[i][j] != 0) || (w[i][k] !=0 && w[k][j] !=0 ) ? 1:0;
                }
            }
        }
    }

    public static void printShortestPath(int[][] w, int n)
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {
                System.out.print(w[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        int[][] arr = { {0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14} };
        int n = arr.length;
        floyd(arr, n);
        printShortestPath(arr, n);
    }   
}
