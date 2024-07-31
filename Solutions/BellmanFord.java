public class BellmanFord
{
    static class Edge
    {
        int source, destination, weight;
        Edge(int source, int destination, int weight)
        {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static class Graph
    {
        int vertices;
        Edge[] edges;
        int edgeCount;

        Graph(int vertices, int edgeCount)
        {
            this.vertices = vertices;
            this.edgeCount = edgeCount;
            edges = new Edge[edgeCount];
        }

        void addEdge(int index, int source, int destination, int weight)
        {
            edges[index] = new Edge(source, destination, weight);
        }

        void printBellmanFord(int[] distance, int src)
        {
            System.out.println("Source index: " + src);
            for (int i=0; i<vertices; i++)
            {
                System.out.println(i + "\t\t" + distance[i]);
            }
        }

        void bellman(int src)
        {
            int[] distance = new int[vertices];
            for (int i=0; i<vertices; i++)
            {
                distance[i] = Integer.MAX_VALUE;
            }
            distance[src] = 0;

            for (int i=1; i<vertices; i++)
            {
                for (int j=0; j<edgeCount; j++)
                {
                    int u = edges[j].source;
                    int v = edges[j].destination;
                    int weight = edges[j].weight;

                    if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v])
                    {
                        distance[v] = distance[u] + weight;
                    }
                }
            }

            for (int j=0; j<edgeCount; j++)
            {
                int u = edges[j].source;
                int v = edges[j].destination;
                int weight = edges[j].weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v])
                {
                    System.out.println("Graph has negative cycles");
                    return;
                }
            }
            printBellmanFord(distance, src);
        }
    }

    public static void main(String[] args)
    {
        Graph graph = new Graph(5, 7);

        graph.addEdge(0, 0, 1, 2);
        graph.addEdge(1, 0, 3, 6);
        graph.addEdge(2, 1, 2, 3);
        graph.addEdge(3, 1, 3, 8);
        graph.addEdge(4, 1, 4, 5);
        graph.addEdge(5, 2, 4, 7);
        graph.addEdge(6, 3, 4, 9);

        graph.bellman(0);
    }
}