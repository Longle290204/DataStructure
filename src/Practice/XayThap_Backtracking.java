package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class XayThap_Backtracking {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int tc = 0; tc < t; tc++) {
            int N = sc.nextInt();
            int M1 = sc.nextInt();
            int M2 = sc.nextInt();

            int[] bricks = new int[N];
            for (int i = 0; i < N; i++) {
                bricks[i] = sc.nextInt();
            }

            for (int i = 0; i < N - 1; i++) {
                for (int j = 0; j < N - 1 - i; j++) {
                    if (bricks[j] < bricks[j + 1]) {
                        int temp = bricks[j];
                        bricks[j] = bricks[j + 1];
                        bricks[j + 1] = temp;
                    }
                }
            }

            boolean[] check = new boolean[N];
            int tower1 = 1;
            int tower2 = 1;
            back_track(tower1, tower2, 1, 1, M1, M2, bricks, check);

        }
    }

    public static void back_track(int tower1, int tower2, int cost1, int cost2, int M1, int M2, int[] bricks, boolean[] check) {
        if (tower1 < M1) {
            cost1 *= bricks[cost1];
        }
    }
}
