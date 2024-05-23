public class merge_sort_algorithm {

    static int[] a = { 10, 14, 19, 26, 27, 31, 33, 35, 42, 44, 0 };
    static int[] b = new int[a.length];
    static void merging(int low, int mid, int high) {
        int l1, l2, i;
        for(l1 = low, l2 = mid + 1, i = low; l1 <= mid && l2 <= high; i++) {
            if(a[l1] <= a[l2])
                b[i] = a[l1++];
            else
                b[i] = a[l2++];
        }
        while(l1 <= mid)
            b[i++] = a[l1++];
        while(l2 <= high)
            b[i++] = a[l2++];
        for(i = low; i <= high; i++)
            a[i] = b[i];
    }
    static void sort(int low, int high) {
        int mid;
        if(low < high) {
            mid = (low + high) / 2;
            sort(low, mid);
            sort(mid+1, high);
            merging(low, mid, high);
        } else {
            return;
        }
    }
    public static void main(String[] args){

        int i;
        int n = a.length;
        System.out.println("Array before sorting");
        for(i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        sort(0, n-1);
        System.out.println("\nArray after sorting");
        for(i = 0; i < n; i++)
            System.out.print(a[i]+" ");

    }

}
