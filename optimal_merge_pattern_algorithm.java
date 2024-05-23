
public class optimal_merge_pattern_algorithm {

    public static int optimalMerge(int[] files, int n) {
        // Sort the files in ascending order
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (files[j] > files[j + 1]) {
                    // Swap files[j] and files[j + 1]
                    int temp = files[j];
                    files[j] = files[j + 1];
                    files[j + 1] = temp;
                }
            }
        }
        int cost = 0;
        while (n > 1) {
            // Merge the smallest two files
            int mergedFileSize = files[0] + files[1];
            cost += mergedFileSize;
            // Replace the first file with the merged file size
            files[0] = mergedFileSize;
            // Shift the remaining files to the left
            for (int i = 1; i < n - 1; i++) {
                files[i] = files[i + 1];
            }
            n--; // Reduce the number of files
            // Sort the files again
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (files[j] > files[j + 1]) {
                        // Swap files[j] and files[j + 1]
                        int temp = files[j];
                        files[j] = files[j + 1];
                        files[j + 1] = temp;
                    }
                }
            }
        }
        return cost;
    }
    public static void main(String[] args) {
        int[] files = {5, 10, 20, 30, 30};
        int n = files.length;
        int minCost = optimalMerge(files, n);
        System.out.println("Minimum cost of merging is: " + minCost + " Comparisons");
    }

}
