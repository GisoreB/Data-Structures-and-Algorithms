import java.util.*;
public class graph_data_structure {

    //class to store edges of the graph
    static class Edge {
        int src, dest;
        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }
    // Graph class
    public class Graph {

        // node of adjacency list
        static class vertex {
            int v;

            vertex(int v) {
                this.v = v;
            }
        }
    }
    // define adjacency list to represent the graph
    List<List<Graph.vertex>> adj_list = new ArrayList<>();

    //Graph Constructor
    public graph_data_structure(List<Edge> edges){

        // adjacency list memory allocation
        for (int i = 0; i < edges.size(); i++)
            adj_list.add(i, new ArrayList<>());

        // add edges to the graph
        for (Edge e : edges){

            // allocate new node in adjacency List from src to dest
            adj_list.get(e.src).add(new Graph.vertex(e.dest));
        }
    }
    public static void main(String[] args){
        // define edges of the graph
        List<Edge> edges = Arrays.asList(new Edge(0, 1),new Edge(0, 2),
                new Edge(0, 3),new Edge(1, 2), new Edge(1, 4),
                new Edge(2, 4), new Edge(2, 3),new Edge(3, 1));

        // call graph class Constructor to construct a graph
        graph_data_structure graph = new graph_data_structure(edges);

        // print the graph as an adjacency list
        int src = 0;
        int lsize = graph.adj_list.size();
        System.out.println("The graph created is: ");
        while (src < lsize) {

            //traverse through the adjacency list and print the edges
            for (Graph.vertex edge : graph.adj_list.get(src)) {
                System.out.print(src + " -> " + edge.v + "\t");
            }
            System.out.println();
            src++;
        }
    }
}
