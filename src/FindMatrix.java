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

            int minAlEqual = Integer.MAX_VALUE;
            int minSum = Integer.MAX_VALUE;
            int resultInX = -1;
            int resultInY = -1;

            for (int i = 0; i <= N - M; i++) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;

                    // Tính tổng ma trận con MxM bắt đầu tại (i, j)
                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) {
                            sum += matrix[i + x][j + y];
                        }
                    }

                    int alEqual = Math.abs(sum - K);

                    if (alEqual < minAlEqual
                            || (alEqual == minAlEqual && sum < minSum)
                            || (alEqual == minAlEqual && sum == minSum && i < resultInX)
                            || (alEqual == minAlEqual && sum == minSum && i == resultInX && j < resultInY)) {
                        minAlEqual = alEqual;
                        minSum = sum;
                        resultInX = i;
                        resultInY = j;
                    }
                }
            }

            System.out.println("#" + t + " " + resultInX + " " + resultInY);
        }
    }
}
