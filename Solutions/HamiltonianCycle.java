public class HamiltonianCycle {
    private int[][] graph;
    private boolean[] visited;
    private int V;
    private boolean hasCycle;

    public HamiltonianCycle(int[][] graph) {
        this.graph = graph;
        this.V = graph.length;
        this.visited = new boolean[V];
        this.hasCycle = false;
    }

    private void findHamiltonianCycle(int pos, int count) {
        if (count == V && graph[pos][0] > 0) {
            hasCycle = true;
            return;
        }
        for (int i = 0; i < V; i++) {
            if (!visited[i] && graph[pos][i] > 0) {
                visited[i] = true;
                findHamiltonianCycle(i, count + 1);
                visited[i] = false;
            }
        }
    }

    public boolean hasHamiltonianCycle() {
        visited[0] = true;
        findHamiltonianCycle(0, 1);
        return hasCycle;
    }

    public static void main(String[] args) {
        int[][] graph = { { 0, 1, 1, 1 },
                          { 1, 0, 1, 1 },
                          { 1, 1, 0, 1 },
                          { 1, 1, 1, 0 } };

        HamiltonianCycle hc = new HamiltonianCycle(graph);
        System.out.println("Contains Hamiltonian Cycle: " + hc.hasHamiltonianCycle());
    }
}
