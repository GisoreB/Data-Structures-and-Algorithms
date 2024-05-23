// Time-complexity : Θ(n)

public class counting_sort_algorithm {

    static void sort(int[] a, int n) {
        int i, j;
        int[] output = new int[15];
        int[] c = new int[100];
        for (i = 0; i < 100; i++)
            c[i] = 0;
        for (j = 0; j < n; j++)
            ++c[a[j]];
        for (i = 1; i <= 99; i++)
            c[i] += c[i-1];
        for (j = n-1; j >= 0; j--) {
            output[c[a[j]] - 1] = a[j];
            --c[a[j]];
        }
        System.out.println("\nAfter sorting array elements are: ");
        for (i = 0; i < n; ++i)
            System.out.print(output[i] + " ");
    }
    public static void main(String [] args){

        int[] a = {12, 32, 44, 8, 16};
        int n = a.length;
        System.out.println("Before sorting array elements are: ");
        for(int i = 0; i<n; i++){
            System.out.print(a[i] + " ");
        }
        // Function call
        sort(a, n);
    }

}
