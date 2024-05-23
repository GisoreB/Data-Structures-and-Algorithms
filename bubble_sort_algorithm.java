import java.io.*;
import java.util.*;

// Time complexity : Ο(n2)

public class bubble_sort_algorithm {

    public static void main(String [] args){

        int n = 5;
        int[] arr = {67, 44, 82, 17, 20}; //initialize an array
        System.out.print("Array before Sorting: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        for(int i = 0; i<n; i++) {
            int swaps = 0; //flag to detect any swap is there or not
            for(int j = 0; j<n-i-1; j++) {
                if(arr[j] > arr[j+1]) { //when the current item is bigger than next
                    int temp;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps = 1; //set swap flag
                }
            }
            if(swaps == 0)
                break;
        }
        System.out.print("Array After Sorting: ");
        for(int i = 0; i<n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

    }

}
