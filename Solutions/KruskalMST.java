public class KruskalMST
{
    int[] parent;

    public KruskalMST(int size)
    {
        parent = new int[size+1];
        for (int i=1; i<=size; i++)
            parent[i] = 0;
    }

    int find(int node)
    {
        int p = node;
        while (parent[p] != 0)
        {
            p = parent[p];
        }
        return p;
    }

    void union(int set1, int set2)
    {
        if (set1 < set2)
            parent[set1] = set2;
        else
            parent[set2] = set1;
    }

    void kruskals(int[][] graph, int vertices)
    {
        int minCost = 0;
        int edgeCount = 0;

        while (edgeCount < vertices-1)
        {
            int min = Integer.MAX_VALUE;
            int u=-1, v=-1;

            for (int i=1; i<=vertices; i++)
            {
                for (int j=1; j<=vertices; j++)
                {
                    if (find(u) != find(v) && graph[i][j] < min)
                    {
                        min = graph[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            int rootU = find(u);
            int rootV = find(v);
            if (rootU != rootV)
            {
                union(rootU, rootV);
                System.out.println("Edge: " + u + " to " + v + " Weight: " + graph[u][v]);
                minCost += graph[u][v];
                edgeCount++;
            }

            graph[u][v] = graph[v][u] = Integer.MAX_VALUE;
        }
        System.out.println("Minimum cost of MST: " + minCost);
    }

    public static void main(String[] args) {
        // Sample input for testing
        int vertices = 4;
        int[][] graph = {
            {0, 0, 0, 0, 0},  // 0th index not used for 1-based indexing
            {0, 0, 10, 0, 6},
            {0, 10, 0, 7, 0},
            {0, 0, 7, 0, 9},
            {0, 6, 0, 9, 0}
        };

        // Initialize Kruskal's algorithm
        KruskalMST kruskal = new KruskalMST(vertices);
        kruskal.kruskals(graph, vertices);
    }
}