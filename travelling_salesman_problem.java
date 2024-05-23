import java.util.*;

public class travelling_salesman_problem {

    static int[][] tsp_g = {
            {12, 30, 33, 10, 45},
            {56, 22, 9, 15, 18},
            {29, 13, 8, 5, 12},
            {33, 28, 16, 10, 3},
            {1, 4, 30, 24, 20}};
    static int[] visited;
    static int n, cost;
    public static void travellingsalesman(int c) {
        int k, adj_vertex = 999;
        int min = 999;
        visited[c] = 1;
        System.out.print((c + 1) + " ");
        for (k = 0; k < n; k++) {
            if ((tsp_g[c][k] != 0) && (visited[k] == 0)) {
                if (tsp_g[c][k] < min) {
                    min = tsp_g[c][k];
                    adj_vertex = k;
                }
            }
        }
        if (min != 999) {
            cost = cost + min;
        }
        if (adj_vertex == 999) {
            adj_vertex = 0;
            System.out.print((adj_vertex + 1));
            cost = cost + tsp_g[c][adj_vertex];
            return;
        }
        travellingsalesman(adj_vertex);
    }
    public static void main(String[] args) {
        int i, j;
        n = 5;
        visited = new int[n];
        Arrays.fill(visited, 0);
        System.out.print("Shortest Path: ");
        travellingsalesman(0);
        System.out.print("\nMinimum Cost: ");
        System.out.print(cost);
    }

}
