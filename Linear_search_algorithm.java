import java.io.*;
import java.util.*;

public class Linear_search_algorithm {

    static void linear_search(int[] a, int n, int key) {
        int i, count = 0;
        for(i = 0; i < n; i++) {
            if(a[i] == key) { // compares each element of the array
                System.out.println("The element is found at position " + (i+1));
                count = count + 1;
            }
        }
        if(count == 0) // for unsuccessful search
            System.out.println("The element is not present in the array");
    }
    public static void main(String [] args){

        int i, n, key;
        n = 6;
        int[] a = {12, 44, 32, 18, 4, 10, 66};
        key = 12;
        linear_search(a, n, key);
        key = 54;
        linear_search(a, n, key);

    }

}
