import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FirstDuplicate {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));


        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int t = 1; t <= tc; t++) {

            int N = sc.nextInt();

            int[] arr = new int[N];

            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
            }

            int[] newArr = new int[N + 1];
            int result = -1;
            for (int i = 0; i < N; i++) {
                if (newArr[arr[i]] == 1) {
                    result = arr[i];
                    break;
                }
                newArr[arr[i]]++;
            }

            System.out.println("#" + t + " " + result);
        }
    }
}
