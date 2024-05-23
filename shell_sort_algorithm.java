// Time-complexity : O(n)

public class shell_sort_algorithm {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {33, 45, 62, 12, 98}; //initialize an array
        System.out.print("Array before Sorting: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        int gap;
        for(gap = n/2; gap > 0; gap = gap / 2) { //initially gap = n/2, decreasing by gap /2
            for(int j = gap; j<n; j++) {
                for(int k = j-gap; k>=0; k -= gap) {
                    if(arr[k+gap] >= arr[k])
                        break;
                    else {
                        int temp;
                        temp = arr[k+gap];
                        arr[k+gap] = arr[k];
                        arr[k] = temp;
                    }
                }
            }
        }
        System.out.print("Array After Sorting: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
