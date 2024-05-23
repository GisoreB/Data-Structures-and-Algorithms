import java.util.*;

public class longest_common_subsequence {
    public static int max(int a, int b){
        return Math.max(a, b);
    }
    static int lcs(char[] arr1, char[] arr2, int m, int n) {
        int[][] L = new int[m + 1][n + 1];
        // Building the mtrix in bottom-up way
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (arr1[i - 1] == arr2[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }

        int index = L[m][n];
        int temp = index;

        char[] lcs = new char[index + 1];
        lcs[index] = '\0';

        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (arr1[i - 1] == arr2[j - 1]) {
                lcs[index - 1] = arr1[i - 1];

                i--;
                j--;
                index--;
            }
            else if (L[i - 1][j] > L[i][j - 1])
                i--;
            else
                j--;
        }
        System.out.print("LCS: ");
        for(i = 0; i<=temp; i++){
            System.out.print(lcs[i]);
        }
        System.out.println();
        return L[m][n];
    }

    public static void main(String[] args) {
        String S1 = "ABSDHSGHJERT";
        String S2 = "ABDHSPKJERTY";
        char[] ch1 = S1.toCharArray();
        char[] ch2 = S2.toCharArray();
        int m = ch1.length;
        int n = ch2.length;
        System.out.println("Length of LCS is: " + lcs(ch1, ch2, m, n));
    }

}
