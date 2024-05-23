public class max_min_problem_naive_method {

    static class Pair {
        int max;
        int min;
    }
    // Function to find maximum and minimum using the naive algorithm
    static Pair maxMinNaive(int[] arr) {
        Pair result = new Pair();
        result.max = arr[0];
        result.min = arr[0];
        // Loop through the array to find the maximum and minimum values
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > result.max) {
                result.max = arr[i]; // Update the maximum value if a larger element is found
            }
            if (arr[i] < result.min) {
                result.min = arr[i]; // Update the minimum value if a smaller element is found
            }
        }
        return result; // Return the pair of maximum and minimum values
    }
    public static void main(String[] args) {
        int[] arr = {6, 4, 26, 14, 33, 64, 46};
        Pair result = maxMinNaive(arr);
        System.out.println("Maximum element is: " + result.max);
        System.out.println("Minimum element is: " + result.min);
    }
}
