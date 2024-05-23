public class insertion_sort_algorithm {

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {67, 44, 82, 17, 20}; //initialize an array
        System.out.print("Array before Sorting: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        for(int i = 1; i<n; i++) {
            int key = arr[i];//take value
            int j = i;
            while(j > 0 && arr[j-1]>key) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key; //insert in right place
        }
        System.out.print("Array After Sorting: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
