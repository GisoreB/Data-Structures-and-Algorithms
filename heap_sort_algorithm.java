// Time-complexity : O(nlogn)

public class heap_sort_algorithm  {

    static void build_maxheap(int[] heap, int n) {
        for (int i = 1; i < n; i++) {
            int c = i;
            do {
                int r = (c - 1) / 2;
                if (heap[r] < heap[c]) { // to create MAX heap array
                    int t = heap[r];
                    heap[r] = heap[c];
                    heap[c] = t;
                }
                c = r;
            } while (c != 0);
        }
        System.out.println("Heap array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(heap[i] + " ");
        }
        heapify(heap, n);
    }
    static void heapify(int heap[], int n) {
        for (int j = n - 1; j >= 0; j--) {
            int c;
            int temp = heap[0];
            heap[0] = heap[j]; // swap max element with rightmost leaf element
            heap[j] = temp;
            int root = 0;
            do {
                c = 2 * root + 1; // left node of root element
                if ((heap[c] < heap[c + 1]) && c < j-1)
                    c++;
                if (heap[root]<heap[c] && c<j) { // again rearrange to max heap array
                    temp = heap[root];
                    heap[root] = heap[c];
                    heap[c] = temp;
                }
                root = c;
            } while (c < j);
        }
        System.out.println("\nThe sorted array is: ");
        for (int i = 0; i < n; i++) {
            System.out.print(heap[i] + " ");
        }
    }
    public static void main(String [] args){

        int[] heap = new int[10];
        heap[0] = 4;
        heap[1] = 3;
        heap[2] = 1;
        heap[3] = 0;
        heap[4] = 2;
        int n = 5;
        build_maxheap(heap, n);

    }

}
