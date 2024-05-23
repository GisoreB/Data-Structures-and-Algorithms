public class dijkstras_shortest_path_algorithm {

    static int min_dist(int[] dist, boolean[] visited) { // finding minimum dist
        int minimum = Integer.MAX_VALUE;
        int ind = -1;
        for (int k = 0; k < 6; k++) {
            if (!visited[k] && dist[k] <= minimum) {
                minimum = dist[k];
                ind = k;
            }
        }
        return ind;
    }
    static void greedy_dijkstra(int[][] graph, int src) {
        int[] dist = new int[6];
        boolean[] visited = new boolean[6];
        for (int k = 0; k < 6; k++) {
            dist[k] = Integer.MAX_VALUE;
            visited[k] = false;
        }
        dist[src] = 0; // Source vertex dist is set 0
        for (int k = 0; k < 6; k++) {
            int m = min_dist(dist, visited);
            visited[m] = true;
            for (int j = 0; j < 6; j++) {
                // updating the dist of neighboring vertex
                if (!visited[j] && graph[m][j] != 0 && dist[m] != Integer.MAX_VALUE
                        && dist[m] + graph[m][j] < dist[j])
                    dist[j] = dist[m] + graph[m][j];
            }
        }
        System.out.println("Vertex\t\tdist from source vertex");
        for (int k = 0; k < 6; k++) {
            char str = (char) (65 + k);
            System.out.println(str + "\t\t\t" + dist[k]);
        }
    }
    public static void main(String[] args) {
        int[][] graph = { { 0, 1, 2, 0, 0, 0 }, { 1, 0, 0, 5, 1, 0 }, { 2, 0, 0, 2, 3, 0 },
                { 0, 5, 2, 0, 2, 2 }, { 0, 1, 3, 2, 0, 1 }, { 0, 0, 0, 2, 1, 0 } };
        greedy_dijkstra(graph, 0);
    }

}
