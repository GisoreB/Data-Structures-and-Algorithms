import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class Jump_search_algorithm {

    public static void main(String[] args) {

        int i, n, key, index;
        int[] arr = {0, 6, 12, 14, 19, 22, 48, 66, 79, 88, 104, 126};
        System.out.println("Array elements are: ");
        for (int k : arr) {
            System.out.print(k + " ");
        }
        n = 12;
        key = 66;
        System.out.println("\nThe element to be searched: "+ key);
        index = jump_search(arr, n, key);
        if(index >= 0)
            System.out.print("The element is found at position " + (index+1));
        else
            System.out.print("Unsuccessful Search");
    }
    static int jump_search(int[] arr, int n, int key) {
        int i, j, m, k;
        i = 0;
        m = (int)Math.sqrt(n);
        k = m;
        while(arr[m] <= key && m < n) {
            i = m;
            m += k;
            if(m > n - 1)
                return -1;
        }

        // linear search on the block
        for(j = i; j<m; j++) {
            if(arr[j] == key)
                return j;
        }
        return -1;

    }

}
