//Java program for Depth First Traversal

//Complexity of DFS Algorithm
//Time Complexity
//The time complexity of the DFS algorithm is represented in the form of O(V + E), where V is the number of nodes and E is the number of edges.
//
//Space Complexity
//The space complexity of the DFS algorithm is O(V).

public class depth_first_traversal {

    private static final int MAX = 5;
    private static class Vertex {
        char label;
        boolean visited;
    }
    private static int[] stack = new int[MAX];
    private static int top = -1;
    static Vertex[] lstVertices = new Vertex[MAX];
    static int[][] adjMatrix = new int[MAX][MAX];
    static int vertexCount = 0;
    private static void push(int item) {
        stack[++top] = item;
    }
    private static int pop() {
        return stack[top--];
    }
    private static int peek() {
        return stack[top];
    }
    private static boolean isStackEmpty() {
        return top == -1;
    }
    private static void addVertex(char label) {
        Vertex vertex = new Vertex();
        vertex.label = label;
        vertex.visited = false;
        lstVertices[vertexCount++] = vertex;
    }
    private static void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }
    private static void displayVertex(int vertexIndex) {
        System.out.print(lstVertices[vertexIndex].label + " ");
    }
    private static int getAdjUnvisitedVertex(int vertexIndex) {
        for (int i = 0; i < vertexCount; i++) {
            if (adjMatrix[vertexIndex][i] == 1 && !lstVertices[i].visited) {
                return i;
            }
        }
        return -1;
    }
    private static void depthFirstSearch() {
        lstVertices[0].visited = true;
        displayVertex(0);
        push(0);
        while (!isStackEmpty()) {
            int unvisitedVertex = getAdjUnvisitedVertex(peek());

            if (unvisitedVertex == -1) {
                pop();
            } else {
                lstVertices[unvisitedVertex].visited = true;
                displayVertex(unvisitedVertex);
                push(unvisitedVertex);
            }
        }
        for (int i = 0; i < vertexCount; i++) {
            lstVertices[i].visited = false;
        }
    }
    public static void main(String[] args){
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        addVertex('S');   // 0
        addVertex('A');   // 1
        addVertex('B');   // 2
        addVertex('C');   // 3
        addVertex('D');   // 4
        addEdge(0, 1);    // S - A
        addEdge(0, 2);    // S - B
        addEdge(0, 3);    // S - C
        addEdge(1, 4);    // A - D
        addEdge(2, 4);    // B - D
        addEdge(3, 4);    // C - D
        System.out.print("Depth First Search: ");
        depthFirstSearch();
    }

}
