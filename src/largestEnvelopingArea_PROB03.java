import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class largestEnvelopingArea_PROB03 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int tc = 1; tc <= n; tc++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int M = sc.nextInt();
            int N = sc.nextInt();

            int[][] matrix = new int[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    int val = sc.nextInt();
                    matrix[i][j] = (val % 2 == 0) ? val : 0;
                }
            }

            long maxSum = 0;
            for (int i = 0; i <= M - H; i++) {
                for (int j = 0; j <= N - W; j++) {
                    long sum = 0;

                    for (int k = 0; k < W; k++) {
                        sum += matrix[i][k + j];
                        sum += matrix[i + H - 1][k + j];
                    }

                    for (int l = i + 1; l < i + H - 1; l++) {
                        sum += matrix[l][j];
                        sum += matrix[l][j + W - 1];
                    }

                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
            System.out.println("#" + tc + " " + maxSum);
        }
    }
}
