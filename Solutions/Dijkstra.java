class Dijkstra
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
        }

        int minKey(int[] key, boolean[] inMST)
        {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int v=0; v<vertices; v++)
            {
                if (!inMST[v] && key[v]<min)
                {
                    min = key[v];
                    minIndex = v;
                }
            }
            return minIndex;
        }

        void dijkstra(int src)
        {
            boolean[] inMST = new boolean[vertices];
            int[] distance = new int[vertices];

            for (int i=0; i<vertices; i++)
            {
                distance[i] = Integer.MAX_VALUE;
                inMST[i] = false;

            }
            distance[src] = 0;

            for (int count=0; count<vertices; count++)
            {
                int u = minKey(distance, inMST);
                inMST[u] = true;

                for (int v=0; v<vertices; v++)
                {
                    if (adjacencyMatrix[u][v] != null && !inMST[v] && distance[u] + adjacencyMatrix[u][v].weight < distance[v] && distance[u] != Integer.MAX_VALUE)
                    {
                        distance[v] = distance[u] + adjacencyMatrix[u][v].weight;
                    }
                }
            }
            printDijkstra(distance, src);
        }

        void printDijkstra(int[] distance, int src)
        {
            System.out.println("Shortest path from: " + src);
            for (int i=0; i<vertices; i++)
            {
                System.out.println(i + "\t\t" + distance[i]);
            }
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

        graph.dijkstra(0);
    }
}
