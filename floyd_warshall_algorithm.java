import java.util.Arrays;

public class floyd_warshall_algorithm {

    public static void floyds(int[][] b) {
        int i, j, k;
        for (k = 0; k < 3; k++) {
            for (i = 0; i < 3; i++) {
                for (j = 0; j < 3; j++) {
                    if ((b[i][k] * b[k][j] != 0) && (i != j)) {
                        if ((b[i][k] + b[k][j] < b[i][j]) || (b[i][j] == 0)) {
                            b[i][j] = b[i][k] + b[k][j];
                        }
                    }
                }
            }
        }
        for (i = 0; i < 3; i++) {
            System.out.println("Minimum Cost With Respect to Node:" + i);
            for (j = 0; j < 3; j++) {
                System.out.print(b[i][j] + "\t");
            }
        }
    }
    public static void main(String[] args) {
        int[][] b = new int[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(b[i], 0);
        }
        b[0][1] = 10;
        b[1][2] = 15;
        b[2][0] = 12;
        floyds(b);
    }

}
