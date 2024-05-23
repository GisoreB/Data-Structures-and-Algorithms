import java.io.*;
import java.util.Scanner;
import java.lang.Math;

public class exponential_search {

    public static void main(String [] args){

        int i, n, key;
        int[] arr = {6, 11, 19, 24, 33, 54, 67, 81, 94, 99};
        System.out.print("Array elements are: ");
        for (int k : arr) {
            System.out.print(k + " ");
        }
        n = 10;
        key = 67;
        System.out.print("\nThe element to be searched: " + key);
        int pos = expo_search(arr, n, key);
        if(pos >= 0)
            System.out.print("\nThe element is found at " + pos);
        else
            System.out.print("\nUnsuccessful Search");
    }
    static int expo_search(int[] a, int n, int key) {
        int i = 1;
        int m = (int)Math.pow(2,i);
        if(a[0] == key)
            return 0;
        while(a[m] <= key && m < n) {
            i++;
            m = (int)Math.pow(2,i);
            int low = 0;
            int high = n - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if(a[mid] == key)
                    return mid;
                else if(a[mid] < key)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;

    }

}
