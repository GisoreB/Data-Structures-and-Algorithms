import java.util.ArrayList;
import java.util.List;

public class vertex_cover_algorithm {
    static final int MAX_VERTICES = 100;
    static int[][] graph = new int[MAX_VERTICES][MAX_VERTICES];
    static boolean[] included = new boolean[MAX_VERTICES];
    public static void approx_vertex_cover(int vertices, int edges) {
        int[][] edges_remaining = new int[MAX_VERTICES][MAX_VERTICES];
        for (int i = 0; i < vertices; i++) {
            System.arraycopy(graph[i], 0, edges_remaining[i], 0, vertices);
        }
        while (edges > 0) {
            int u = 1, v = 1;
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (edges_remaining[i][j] != 0) {
                        u = i;
                        v = j;
                        break;
                    }
                }
            }
            included[u] = included[v] = true;
            for (int i = 0; i < vertices; i++) {
                edges_remaining[u][i] = edges_remaining[i][u] = 0;
                edges_remaining[v][i] = edges_remaining[i][v] = 0;
            }
            edges--;
        }
    }
    public static void main(String[] args) {
        int vertices = 8;
        int edges = 10;
        List<int[]> edges_data = new ArrayList<>();
        edges_data.add(new int[] {1, 6});
        edges_data.add(new int[] {1, 2});
        edges_data.add(new int[] {1, 4});
        edges_data.add(new int[] {2, 3});
        edges_data.add(new int[] {2, 4});
        edges_data.add(new int[] {6, 7});
        edges_data.add(new int[] {4, 7});
        edges_data.add(new int[] {7, 8});
        edges_data.add(new int[] {3, 5});
        edges_data.add(new int[] {8, 5});
        for (int[] edge : edges_data) {
            int u = edge[0];
            int v = edge[1];
            graph[u][v] = graph[v][u] = 1;
        }
        approx_vertex_cover(vertices, edges);
        System.out.print("Vertex Cover: ");
        for (int i = 1; i <= vertices; i++) {
            if (included[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

}
