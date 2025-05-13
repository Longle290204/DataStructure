import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindMatrix {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {

            int N = sc.nextInt();
            int M = sc.nextInt();
            int K = sc.nextInt();

            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            int[][] prefix = new int[N + 1][N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    prefix[i][j] = matrix[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
                }
            }

            int minAlEqual = Integer.MAX_VALUE;
            int minSum = Integer.MAX_VALUE;
            int resultInX = 0;
            int resultInY = 0;

            for (int i = 1; i <= N - M + 1; i++) {
                for (int j = 1; j <= N - M + 1; j++) {
                    int sum = prefix[i + M - 1][j + M - 1] - prefix[i - 1][j + M - 1] - prefix[i + M - 1][j - 1] + prefix[i - 1][j - 1];

                    int alEqual = Math.abs(sum - K);

                    if (alEqual < minAlEqual
                            || (alEqual == minAlEqual && sum < minSum)
                            || (alEqual == minAlEqual && sum == minSum && i - 1 < resultInX)
                            || (alEqual == minAlEqual && sum == minSum && i - 1 == resultInX && j - 1 < resultInY)) {
                        minAlEqual = alEqual;
                        minSum = sum;
                        resultInX = i - 1;
                        resultInY = j - 1;
                    }
                }
            }

            System.out.println("#" + t + " " + (resultInX) + " " + (resultInY));
        }
    }
}
