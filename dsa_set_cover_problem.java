import java.util.*;
public class dsa_set_cover_problem {
    public static List<Integer> setCover(int[] X, int[][] S) {
        Set<Integer> U = new HashSet<>();
        for (int x : X) {
            U.add(x);
        }
        List<Integer> output = new ArrayList<>();
        while (!U.isEmpty()) {
            int maxIntersectionSize = 0;
            int selectedSetIdx = -1;
            for (int i = 0; i < S.length; i++) {
                int intersectionSize = 0;
                for (int j = 0; j < S[i].length; j++) {
                    if (U.contains(S[i][j])) {
                        intersectionSize++;
                    }
                }
                if (intersectionSize > maxIntersectionSize) {
                    maxIntersectionSize = intersectionSize;
                    selectedSetIdx = i;
                }
            }
            if (selectedSetIdx == -1) {
                break;
            }
            for (int j = 0; j < S[selectedSetIdx].length; j++) {
                U.remove(S[selectedSetIdx][j]);
            }
            output.add(selectedSetIdx);
        }
        return output;
    }
    public static void main(String[] args) {
        int[] X = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] S = {
                {1, 2},
                {2, 3, 4},
                {4, 5, 6},
                {6, 7, 8},
                {8, 9, 10}
        };
        List<Integer> selectedSets = setCover(X, S);
        System.out.print("Selected Sets: ");
        for (int idx : selectedSets) {
            System.out.print(idx + " ");
        }
        System.out.println();
    }

}
