import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class calcsqrt {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            int a = sc.nextInt();
          int result = (int) Math.sqrt(a);
          System.out.println("#" + i + " " + result);
        }
    }

//Cách 2:

//    public static void main(String[] args) throws FileNotFoundException {
//        System.setIn(new FileInputStream("input.txt"));
//
//        Scanner sc = new Scanner(System.in);
//
//        int N = sc.nextInt();
//
//        for(int i = 1; i <= N; i++) {
//            int a = sc.nextInt();
//            int sqrt = binarySqrt(a);
//            System.out.println("#" + i + " " + sqrt);
//        }
//    }
//
//    public static int binarySqrt(int number) {
//        int left = 0;
//        int right = number;
//        int ans = 0;
//
//        while (left <= right) {
//            int mid = left + (right - left)/2;
//            long square = (long) mid * mid;
//            if (square == number) {
//               return mid;
//            }
//            else if (square > number) {
//                right = mid - 1;
//            }
//            else {
//                ans = mid;
//                left = mid + 1;
//            }
//        }
//        return ans;
//
//    }
//
//
}

//left          right              mid          mid^2
//0             10                 5             25       mid > ans  --> right = 4
//0             4                  2             4        mid < ans  ---> left = 1
//1             4
//3
//4
//5
