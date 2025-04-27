import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CNTSYMSTR {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());

        for (int i = 1; i <= N; i++) {
            String input = sc.nextLine();
            int result = countSymmetricSubstrings(input);

            System.out.println("#" + i + " " + result);
        }
    }

    public static int countSymmetricSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isPalindrome(String string) {
    int left = 0;
    int right = string.length() - 1;

        while (left <= right) {
            if(string.charAt(left) != string.charAt(right)) {
                    return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
