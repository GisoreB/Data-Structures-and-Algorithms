import java.io.*;
import java.util.Scanner;

public class fibonacci_search {

    static int min(int a, int b) {
        return Math.min(a, b);
    }
    static int fib_search(int[] arr, int n, int key) {
        int offset = -1;
        int Fm2 = 0;
        int Fm1 = 1;
        int Fm = Fm2 + Fm1;
        while (Fm < n) {
            Fm2 = Fm1;
            Fm1 = Fm;
            Fm = Fm2 + Fm1;
        }
        while (Fm > 1) {
            int i = min(offset + Fm2, n - 1);
            if (arr[i] < key) {
                Fm = Fm1;
                Fm1 = Fm2;
                Fm2 = Fm - Fm1;
                offset = i;
            } else if (arr[i] > key) {
                Fm = Fm2;
                Fm1 = Fm1 - Fm2;
                Fm2 = Fm - Fm1;
            } else
                return i;
        }
        if (Fm1 == 1 && arr[offset + 1] == key)
            return offset + 1;
        return -1;
    }
    public static void main(String[] args) {
        int i, n, key;
        int[] arr = {6, 11, 19, 24, 33, 54, 67, 81, 94, 99};
        System.out.print("Array elements are: ");
        for (int k : arr) {
            System.out.print(k + " ");
        }
        n = 10;
        key = 67;
        System.out.print("\nThe element to be searched: " + key);
        int pos = fib_search(arr, n, key);
        if(pos >= 0)
            System.out.print("\nThe element is found at index " + pos);
        else
            System.out.print("\nUnsuccessful Search");
    }

}
