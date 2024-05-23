import java.util.Arrays;
public class dsa_travelling_salesman_approximation_algorithm {
    static final int V = 6; // Number of vertices in the graph
    // Function to find the minimum key vertex from the set of vertices not yet included in MST
    static int findMinKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    // Function to perform Prim's algorithm to find the Minimum Spanning Tree (MST)
    static void primMST(int[][] graph, int[] parent) {
        int[] key = new int[V];
        boolean[] mstSet = new boolean[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(mstSet, false);
        key[0] = 0;
        parent[0] = -1;
        for (int count = 0; count < V - 1; count++) {
            int u = findMinKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
    }
    // Function to print the preorder traversal of the Minimum Spanning Tree
    static void printPreorderTraversal(int[] parent) {
        System.out.print("The preorder traversal of the tree is found to be  ");
        for (int i = 1; i < V; i++) {
            System.out.print(parent[i] + " -> ");
        }
        System.out.println();
    }
    // Main function for the Traveling Salesperson Approximation Algorithm
    static void tspApproximation(int[][] graph) {
        int[] parent = new int[V];
        int root = 0; // Choosing vertex 0 as the starting and ending point
        // Find the Minimum Spanning Tree using Prim's Algorithm
        primMST(graph, parent);
        // Print the preorder traversal of the Minimum Spanning Tree
        printPreorderTraversal(parent);
        // Print the Hamiltonian path (preorder traversal with the starting point added at the end)
        System.out.print("Adding the root node at the end of the traced path ");
        for (int i = 0; i < V; i++) {
            System.out.print(parent[i] + " -> ");
        }
        System.out.println(root + "  " + parent[0]);
        // Calculate and print the cost of the Hamiltonian path
        int cost = 0;
        for (int i = 1; i < V; i++) {
            cost += graph[parent[i]][i];
        }
        // The cost of the path would be the sum of all the costs in the minimum spanning tree.
        System.out.println("Sum of all the costs in the minimum spanning tree: " + cost);
    }
    public static void main(String[] args) {
        // Example graph represented as an adjacency matrix
        int[][] graph = {
                {0, 3, 1, 6, 0, 0},
                {3, 0, 5, 0, 3, 0},
                {1, 5, 0, 5, 6, 4},
                {6, 0, 5, 0, 0, 2},
                {0, 3, 6, 0, 0, 6},
                {0, 0, 4, 2, 6, 0}
        };
        tspApproximation(graph);
    }

}
