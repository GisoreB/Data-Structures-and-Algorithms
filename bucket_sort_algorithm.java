// Time-complexity : Θ(n)

public class bucket_sort_algorithm {
    static void bucketsort(int[] a, int n) { // function to implement bucket sort
        int max = a[0]; // get the maximum element in the array
        for (int i = 1; i < n; i++)
            if (a[i] > max)
                max = a[i];
        int[] b = new int[max+1];
        for (int i = 0; i <= max; i++) {
            b[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            b[a[i]]++;
        }
        for (int i = 0, j = 0; i <= max; i++) {
            while (b[i] > 0) {
                a[j++] = i;
                b[i]--;
            }
        }
    }
    public static void main(String[] args) {

        int n = 9;
        int[] a = {12, 45, 33, 87, 56, 9, 11, 7, 67};
        System.out.println("Before sorting array elements are: ");
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
        bucketsort(a, n);
        System.out.println("\nAfter sorting array elements are: ");
        for (int i = 0; i < n; ++i)
            System.out.print(a[i] + " ");
    }
}
