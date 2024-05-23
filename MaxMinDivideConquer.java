public class MaxMinDivideConquer {
    // Class to store both maximum and minimum elements
    static class Pair {
        int max;
        int min;
    }
    static Pair maxMinDivideConquer(int[] arr, int low, int high) {
        Pair result = new Pair();
        Pair left, right;
        int mid;
        // If only one element in the array
        if (low == high) {
            result.max = arr[low];
            result.min = arr[low];
            return result;
        }
        // If there are two elements in the array
        if (high == low + 1) {
            if (arr[low] < arr[high]) {
                result.min = arr[low];
                result.max = arr[high];
            } else {
                result.min = arr[high];
                result.max = arr[low];
            }
            return result;
        }
        // If there are more than two elements in the array
        mid = (low + high) / 2;
        left = maxMinDivideConquer(arr, low, mid);
        right = maxMinDivideConquer(arr, mid + 1, high);
        // Compare and get the maximum of both parts
        result.max = Math.max(left.max, right.max);
        // Compare and get the minimum of both parts
        result.min = Math.min(left.min, right.min);
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {6, 4, 26, 14, 33, 64, 46};
        Pair result = maxMinDivideConquer(arr, 0, arr.length - 1);
        System.out.println("Maximum element is: " + result.max);
        System.out.println("Minimum element is: " + result.min);
    }
}

//Compared to Naïve method, in divide and conquer approach, the number of comparisons is less. However,
//using the asymptotic notation both of the approaches are represented by O(n).