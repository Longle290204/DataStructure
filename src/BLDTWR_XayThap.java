import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BLDTWR_XayThap {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {

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

            int nextFloor1 = 1;
            int nextFloor2 = 1;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                if (nextFloor1 <= M1 && nextFloor1 == nextFloor2 || nextFloor2 > M2) {
                    sum += bricks[i] * nextFloor1;
                    nextFloor1++;
                } else {
                    sum += bricks[i] * nextFloor2;
                    nextFloor2++;
                }
            }

//			int sum = 0, i = 0;
//			while (i < N) {
//				if (nextFloor1 <= M1) {
//					sum += bricks[i] * nextFloor1;
//					nextFloor1++;
//					i++;
//				}
//
//				if (nextFloor2 <= M2) {
//					sum += bricks[i] * nextFloor2;
//					nextFloor2++;
//					i++;
//				}
//			}
            System.out.println("#" + t + " " + sum);
        }
    }
}
