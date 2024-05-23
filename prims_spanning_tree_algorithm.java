public class prims_spanning_tree_algorithm {

    static int inf = 999999;
    static int MAX = 10;
    static int[][] G = {
            {0, 19, 8},
            {21, 0, 13},
            {15, 18, 0}
    };
    static int[][] S = new int[MAX][MAX];
    static int n;
    public static void main(String[] args) {
        int i, j, cost;
        n = 3;
        cost=prims();
        System.out.print("Spanning tree: ");
        for(i=0; i<n; i++) {
            System.out.println();
            for(j=0; j<n; j++)
                System.out.print(S[i][j] + " ");
        }
        System.out.println("\nMinimum cost = " + cost);
    }
    static int prims() {
        int[][] C = new int[MAX][MAX];
        int u, v = 0, min_dist;
        int[] dist = new int[MAX];
        int[] from = new int[MAX];
        int[] visited = new int[MAX];
        int ne,i,min_cost,j;
        //create cost matrix and spanning tree
        for(i=0; i<n; i++)
            for(j=0; j<n; j++) {
                if(G[i][j]==0)
                    C[i][j]=inf;
                else
                    C[i][j]=G[i][j];
                S[i][j]=0;
            }
        //initialise visited[],distance[] and from[]
        dist[0]=0;
        visited[0]=1;
        for(i=1; i<n; i++) {
            dist[i] = C[0][i];
            from[i] = 0;
            visited[i] = 0;
        }
        min_cost = 0; //cost of spanning tree
        ne = n-1; //no. of edges to be added
        while(ne > 0) {
            //find the vertex at minimum distance from the tree
            min_dist = inf;
            for(i=1; i<n; i++)
                if(visited[i] == 0 && dist[i] < min_dist) {
                    v = i;
                    min_dist = dist[i];
                }
            u = from[v];
            //insert the edge in spanning tree
            S[u][v] = dist[v];
            S[v][u] = dist[v];
            ne--;
            visited[v]=1;
            //updated the distance[] array
            for(i=1; i<n; i++)
                if(visited[i] == 0 && C[i][v] < dist[i]) {
                    dist[i] = C[i][v];
                    from[i] = v;
                }
            min_cost = min_cost + C[u][v];
        }
        return(min_cost);
    }

}
