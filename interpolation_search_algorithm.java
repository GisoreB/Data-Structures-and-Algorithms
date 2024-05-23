import java.io.*;

public class interpolation_search_algorithm {

    static int interpolation_search(int data, int[] list) {
        int lo = 0;
        int hi = list.length - 1;
        int mid = -1;
        int comparisons = 1;
        int index = -1;
        while(lo <= hi) {
            System.out.println("Comparison " + comparisons);
            System.out.println("lo : " + lo + " list[" + lo + "] = " + list[lo]);
            System.out.println("hi : " + hi + " list[" + hi + "] = " + list[hi]);
            comparisons++;

            // probe the mid point
            mid = lo + (((hi - lo) * (data - list[lo])) / (list[hi] - list[lo]));
            System.out.println("mid = " + mid);

            // data found
            if(list[mid] == data) {
                index = mid;
                break;
            } else {
                if(list[mid] < data) {

                    // if data is larger, data is in upper half
                    lo = mid + 1;
                } else {

                    // if data is smaller, data is in lower half
                    hi = mid - 1;
                }
            }
        }
        System.out.println("Total comparisons made: " + (--comparisons));
        return index;
    }
    public static void main(String [] args){
        int[] list = { 10, 14, 19, 26, 27, 31, 33, 35, 42, 44 };

        //find location of 33
        int location = interpolation_search(33, list);

        // if element was found
        if(location != -1)
            System.out.println("Element found at location: " + (location+1));
        else
            System.out.println("Element not found.");
    }

}
