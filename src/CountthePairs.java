import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountthePairs {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();


        for (int i = 1; i <= len; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            Set<Integer> set = new HashSet<>();

            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = sc.nextInt();
                set.add(arr[j]);
            }

            int count = 0;
            for (int t = 0; t < N; t++) {
                if (set.contains(arr[t] + K)) {
                    count++;
                }
            }

            System.out.println(count);
        }
    }

    public static int twoPointer(int[] arr, int K, int N) {
        int left = 0;
        int right = 1;
        int count = 0;

        while (right < N) {

            int diff = arr[right] - arr[left];
            if (diff == K) {
                count++;
                right++;
                left++;
            }
            else if (diff < K) {
                right++;
            } else {
                left++;
                if (left == right) right++;
            }
        }
        return count;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static int countPairs(int[] arr, int K) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) == K) {
                    count++;
                }
            }
        }
        return count;
    }
}
