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
                    matrix[i][j] = sc.nextInt();
                }
            }

            int max = 0;
            int sum = 0;
            for (int i = 0; i <= M - H; i++) {
                for (int j = 0; j <= N - W; j++) {

                    for (int x = 0; x < H; x++) {
                        for (int y = 0; y < W; y++) {
                            if (matrix[x + i][y + j] % 2 == 0) {
                                sum += matrix[x + i][y + j];
                            }
                        }
                    }

                    if (sum > max) {
                        max = sum;
                    }

                    sum = 0;
                }
            }
            System.out.println("#" + tc + " " + max);
        }
    }
}
