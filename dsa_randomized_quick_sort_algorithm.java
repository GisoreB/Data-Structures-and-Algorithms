import java.util.Arrays;
import java.util.Random;
public class dsa_randomized_quick_sort_algorithm {
    // Function to swap two elements
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // Function to partition the array
    static int partitionLeft(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }
    // Function to perform random partition
    static int partitionRight(int[] arr, int low, int high) {
        Random rand = new Random();
        int r = low + rand.nextInt(high - low);
        swap(arr, r, high);
        return partitionLeft(arr, low, high);
    }
    // Recursive function for quicksort
    static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partitionRight(arr, low, high);
            quicksort(arr, low, p - 1);
            quicksort(arr, p + 1, high);
        }
    }
    // Function to print the array
    static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    // Driver code
    public static void main(String[] args) {
        int[] arr = {6, 4, 12, 8, 15, 16};
        int n = arr.length;
        System.out.print("Original array: ");
        printArray(arr);
        quicksort(arr, 0, n - 1);
        System.out.print("Sorted array: ");
        printArray(arr);
    }
}
