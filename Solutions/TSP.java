public class TSP
{
    private int[][] graph;
    private boolean[] visited;
    private int V;
    private int minCost;

    public TSP(int[][] graph)
    {
        this.graph = graph;
        this.V = graph.length;
        this.visited = new boolean[V];
        this.minCost = Integer.MAX_VALUE;
    }

    private void tsp(int pos, int count, int cost)
    {
        if (count == V && graph[pos][0] > 0)
        {
            minCost = Math.min(minCost, cost + graph[pos][0]);
            return;
        }
        for (int i = 0; i < V; i++)
        {
            if (!visited[i] && graph[pos][i] > 0)
            {
                visited[i] = true;
                tsp(i, count + 1, cost + graph[pos][i]);
                visited[i] = false;
            }
        }
    }

    public int findMinCost()
    {
        visited[0] = true;
        tsp(0, 1, 0);
        return minCost;
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 10, 15, 20 },
                          { 10, 0, 35, 25 },
                          { 15, 35, 0, 30 },
                          { 20, 25, 30, 0 } };

        TSP tsp = new TSP(graph);
        System.out.println("Minimum TSP cost: " + tsp.findMinCost());
    }
}
