import java.util.Arrays;

public class quick_sort_algorithm {

    int[] intArray = {4,6,3,2,1,9,7};

    void swap(int num1, int num2) {
        int temp = intArray[num1];
        intArray[num1] = intArray[num2];
        intArray[num2] = temp;
    }
    int partition(int left, int right, int pivot) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (intArray[++leftPointer] < pivot) {
                // do nothing
            }
            while (rightPointer > 0 && intArray[--rightPointer] > pivot) {
                // do nothing
            }

            if (leftPointer >= rightPointer) {
                break;
            } else {
                swap(leftPointer, rightPointer);
            }
        }
        swap(leftPointer, right);

        // System.out.println("Updated Array: ");
        return leftPointer;
    }
    void quickSort(int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            int pivot = intArray[right];
            int partitionPoint = partition(left, right, pivot);
            quickSort(left, partitionPoint - 1);
            quickSort(partitionPoint + 1, right);
        }
    }
    public static void main(String[] args) {
        quick_sort_algorithm sort = new quick_sort_algorithm();
        int max = sort.intArray.length;
        System.out.println("Contents of the array :");
        System.out.println(Arrays.toString(sort.intArray));

        sort.quickSort(0, max - 1);
        System.out.println("Contents of the array after sorting :");
        System.out.println(Arrays.toString(sort.intArray));
    }

}
