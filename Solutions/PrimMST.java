class PrimMST
{
    static class Edge
    {
        int destination, weight;
        Edge(int destination, int weight)
        {
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph
    {
        int vertices;
        Edge[][] adjacencyMatrix;

        Graph(int vertices)
        {
            this.vertices = vertices;
            adjacencyMatrix = new Edge[vertices][vertices];
        }

        void addEdge(int source, int destination, int weight)
        {
            adjacencyMatrix[source][destination] = new Edge(destination, weight);
            adjacencyMatrix[destination][source] = new Edge(source, weight);
        }

        int minKey(int[] key, boolean[] inMST)
        {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int v=0; v<vertices; v++)
            {
                if (!inMST[v] && key[v] < min)
                {
                    key[v] = min;
                    minIndex = v;
                }
            }
            return minIndex;
        }

        void printMST(int[] parent)
        {
            for (int i=1; i<vertices; i++)
            {
                System.out.println("Edge: " + parent[i] + " - " + i + " Weight: " + adjacencyMatrix[i][parent[i]].weight);;
            }
        }

        void primMST()
        {
            boolean[] inMST = new boolean[vertices];
            int[] key = new int[vertices];
            int[] parent = new int[vertices];

            for (int i=0; i<vertices; i++)
            {
                key[i] = Integer.MAX_VALUE;
                parent[i] = -1;
            }
            key[0] = 0;

            for (int count=0; count<vertices-1; count++)
            {
                int u = minKey(key, inMST);
                inMST[u] = true;

                for (int v=0; v<vertices; v++)
                {
                    if (adjacencyMatrix[u][v] != null && !inMST[v] && adjacencyMatrix[u][v].weight < key[v])
                    {
                        key[v] = adjacencyMatrix[u][v].weight;
                        parent[v] = u;
                    }
                }
            }
            printMST(parent);
        }
    }

    public static void main(String[] args)
    {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.primMST();
    }
}