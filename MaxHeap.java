// Java code for for Max Heap construction  Algorithm
//Structure to represent a heap
public class MaxHeap {
    private int[] heap; // To store heap elements
    private int capacity; // Maximum capacity of the heap
    private int size; // Current size of the heap
    // To create a new heap
    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }
    private int parent(int i) {
        return (i - 1) / 2;
    }
    private int leftChild(int i) {
        return 2 * i + 1;
    }
    private int rightChild(int i) {
        return 2 * i + 2;
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    // Heapify a subtree rooted at index i
    private void heapifyDown(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);
        // Check if the left child is larger than the root
        if (left < size && heap[left] > heap[largest])
            largest = left;
        // Check if the right child is larger than the largest so far
        if (right < size && heap[right] > heap[largest])
            largest = right;
        // If the largest is not the root, swap the root with the largest
        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }
    private void heapifyUp(int i) {
        while (i > 0 && heap[i] > heap[parent(i)]) {
            int parent = parent(i);
            swap(i, parent);
            i = parent;
        }
    }
    // Insert the new element at the end
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert more elements.");
            return;
        }
        heap[size] = value;
        size++;
        heapifyUp(size - 1);
    }
    // Function to extract the maximum element from the heap
    public int extractMax() {
        if (size == 0) {
            System.out.println("Heap is empty. Cannot extract maximum element.");
            return -1;
        }
        // store th root element
        int max = heap[0];
        //Replace the root with the last elements
        heap[0] = heap[size - 1];
        size--;
        heapifyDown(0);
        return max;
    }
    //print the elements of the heap
    public void printHeap() {
        System.out.print("Heap elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        MaxHeap heap = new MaxHeap(10);
        heap.insert(35);
        heap.insert(33);
        heap.insert(42);
        heap.insert(10);
        heap.insert(14);
        heap.insert(19);
        heap.insert(27);
        heap.insert(44);
        heap.insert(26);
        heap.insert(31);
        heap.printHeap();
        int max = heap.extractMax();
        System.out.println("Maximum element: " + max);
    }
}