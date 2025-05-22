import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SLTKNGHT {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] drX = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] drY = {1, 2, 2, 1, -1, -2, -2, -1};

        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();
            int K = sc.nextInt();
            int M = sc.nextInt();
            int D = sc.nextInt();

            int[][] arr = new int[N][N];

            int[][] kArr = new int[K][K - 1];
            for (int i = 0; i < K; i++) {
                kArr[i][0] = sc.nextInt();
                kArr[i][1] = sc.nextInt();
                arr[kArr[i][0]][kArr[i][1]] = 1;
            }

           for (int i = 0; i < M; i++) {
               arr[sc.nextInt()][sc.nextInt()] = 2;
           }

            for (int i = 0; i < D; i++) {
                arr[sc.nextInt()][sc.nextInt()] = 3;
            }

            int max = 0;
            int maxX = 0;
            int maxY = 0;

            for (int i = 0; i < K; i++) {
                int x = kArr[i][0];
                int y = kArr[i][1];

                int count = 0;
                for (int j = 0; j < 8; j++) {

                    int newX = x + drX[j];
                    int newY = y + drY[j];

                    if (newX < 0 || newY < 0 || newX >= N || newY >= N) continue;

                    if (arr[newX][newY] == 2 || arr[newX][newY] == 1) {
                        count++;
                    }
                }

                if (count > max) {
                    max = count;
                    maxX = x;
                    maxY = y;
                }
                System.out.println("#" + tc + " " + maxX + " " + maxY + " " + max);
            }
        }
    }
}
