import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MAXSYMST {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            String input = sc.next();
            int max = 1;
            for (int len = 2; len <= input.length(); len++) {
                for (int j = 0; j < input.length() - len + 1; j++) {
                    int left = j, right = j + len - 1;
                    int valid = 1;
                    while (left < right) {
                        if (input.charAt(left) != input.charAt(right)) {
                            valid = 0;
                            break;
                        }
                        left += 1;
                        right -= 1;
                    }
                    if (valid == 1) {
                        max = Math.max(max, len);
                        break;
                    }
                }
            }

            System.out.println("#" + i + " " + max);
        }
    }


//    public static int countSymmetricSubstrings(String s) {
//
//
//
////        for (int i = 0; i < s.length(); i++) {
////            for (int j = i; j < s.length(); j++) {
////                String sub = s.substring(i, j + 1);
////
////
////            }
////        }
////        return ;
//    }

    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
