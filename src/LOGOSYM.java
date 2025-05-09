import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LOGOSYM {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 1; i <= tc; i++) {
            int N = sc.nextInt();

            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = sc.nextInt();
                }
            }

            boolean isSym = true;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (matrix[j][k] != matrix[j][N - 1 - k]) {
                        isSym = false;
                        System.out.println("#" + i + " " + "NO");
                        break;
                    }
                    if (matrix[j][k] != matrix[N - 1 - j][k]) {
                        isSym = false;
                        System.out.println("#" + i + " " + "NO");
                        break;
                    }
                }
                if (!isSym) {
                    break;
                }
            }
            if (isSym) {
                System.out.println("#" + i + " " + "YES");
            }
        }
    }
}
