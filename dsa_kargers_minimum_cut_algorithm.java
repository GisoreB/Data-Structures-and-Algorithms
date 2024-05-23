import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Edge {
    int u;
    int v;
    public Edge(int u, int v) {
        this.u = u;
        this.v = v;
    }
}

public class dsa_kargers_minimum_cut_algorithm {
    private int V;
    private List<Edge> edges;
    public dsa_kargers_minimum_cut_algorithm(int vertices) {
        V = vertices;
        edges = new ArrayList<>();
    }
    public void addEdge(int u, int v) {
        edges.add(new Edge(u, v));
    }
    private int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }
    private void union(int[] parent, int[] rank, int x, int y) {
        int xroot = find(parent, x);
        int yroot = find(parent, y);
        if (rank[xroot] < rank[yroot])
            parent[xroot] = yroot;
        else if (rank[xroot] > rank[yroot])
            parent[yroot] = xroot;
        else {
            parent[yroot] = xroot;
            rank[xroot]++;
        }
    }
    public int kargerMinCut() {
        int[] parent = new int[V];
        int[] rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        int v = V;
        while (v > 2) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(edges.size());
            int u = edges.get(randomIndex).u;
            int w = edges.get(randomIndex).v;
            int setU = find(parent, u);
            int setW = find(parent, w);
            if (setU != setW) {
                v--;
                union(parent, rank, setU, setW);
            }
            edges.remove(randomIndex);
        }
        int minCut = 0;
        for (Edge edge : edges) {
            int setU = find(parent, edge.u);
            int setW = find(parent, edge.v);
            if (setU != setW)
                minCut++;
        }
        return minCut;
    }
    public static void main(String[] args) {
        // Create a graph
        dsa_kargers_minimum_cut_algorithm g = new dsa_kargers_minimum_cut_algorithm(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        // Set seed for random number generation
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis());
        // Find the minimum cut
        int minCut = g.kargerMinCut();
        System.out.println("Minimum Cut: " + minCut);
    }
}
