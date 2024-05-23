import java.util.*;

public class kruskals_spanning_tree_algorithm {

    static int k, a, b, u, v, n, ne = 1, min, mincost = 0;
    static int cost[][] = {{0, 10, 20},{12, 0, 15},{16, 18, 0}};
    static int p[] = new int[9];
    static int inf = 999999;
    static int applyfind(int i) {
        while(p[i] != 0)
            i=p[i];
        return i;
    }
    static int applyunion(int i,int j) {
        if(i!=j) {
            p[j]=i;
            return 1;
        }
        return 0;
    }
    public static void main(String args[]) {
        int i, j;
        n = 3;
        for(i=0; i<n; i++)
            for(j=0; j<n; j++) {
                if(cost[i][j]==0)
                    cost[i][j]= inf;
            }
        System.out.println("Minimum Cost Spanning Tree: ");
        while(ne < n) {
            min = inf;
            for(i=0; i<n; i++) {
                for(j=0; j<n; j++) {
                    if(cost[i][j] < min) {
                        min=cost[i][j];
                        a=u=i;
                        b=v=j;
                    }
                }
            }
            u=applyfind(u);
            v=applyfind(v);
            if(applyunion(u,v) != 0) {
                System.out.println(a + " -> " + b);
                mincost += min;
            }
            cost[a][b]=cost[b][a]=999;
            ne +=1;
        }
        System.out.println("Minimum cost = " + mincost);
    }

}
