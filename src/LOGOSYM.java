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

            // Symmetry X (horizontal axis)
            boolean isSymX = true;
            boolean isSymY = true;
            for (int j = 0; j < N / 2; j++) {
                for (int k = 0; k < N; k++) {
                    if (matrix[j][k] != matrix[N - 1 - j][k]) {
                        isSymX = false;
                        break;
                    }
                }
                if (!isSymX) {
                    break;
                }
            }

            // Symmetry Y (vertical axis)
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N / 2; k++) {
                    if (matrix[j][k] != matrix[j][N - 1 - k]) {
                        isSymY = false;
                        break;
                    }
                }
                if(!isSymY) {
                    break;
                }
            }

            if (isSymX && isSymY) {
                System.out.println("#" + i + " " + "YES");
            }
            else {
                System.out.println("#" + i + " " + "NO");

            }
        }
    }
}

//This version:
//
//Minimizes comparisons to half the matrix.
//
//Avoids mixing logic.
//
//Only prints once at the end of the check.
