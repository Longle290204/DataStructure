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

            int[][] prefix = new int[M + 1][N + 1];
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    prefix[i][j] = matrix[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
                }
            }

            int maxSum = 0;
            for (int i = 0; i <= M - H; i++) {
                for (int j = 0; j <= N - W; j++) {

                    int sum = prefix[i + H][j + W] - prefix[i][j + W] - prefix[i + H][j] + prefix[i][j];

                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
            System.out.println("#" + tc + " " + maxSum);
        }
    }
}
