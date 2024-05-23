public class selection_sort_algorithm {

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {12, 19, 55, 2, 16}; //initialize an array
        System.out.print("Array before Sorting: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        int imin;
        for(int i = 0; i<n-1; i++) {
            imin = i; //get index of minimum data
            for(int j = i+1; j<n; j++)
                if(arr[j] < arr[imin])
                    imin = j;

            //placing in correct position
            int temp;
            temp = arr[i];
            arr[i] = arr[imin];
            arr[imin] = temp;
        }
        System.out.print("Array After Sorting: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
