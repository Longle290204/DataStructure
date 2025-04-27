

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FnStr2 {
    public static void main(String[] args) throws FileNotFoundException {

        System.setIn(new FileInputStream("input.txt"));

        Scanner scanner = new Scanner(System.in);

        // 10 test cases
        for (int t = 0; t < 10; t++) {
            int testCaseNumber = Integer.parseInt(scanner.nextLine());
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();

            int count = countOccurrences(s1, s2);
            System.out.println("#" + testCaseNumber + " " + count);
        }

        scanner.close();
    }

    private static int countOccurrences(String s1, String s2) {
        int count = 0;
        int index = 0;

        while ((index = s2.indexOf(s1, index)) != -1) {
            System.out.println(index);
            count++;
            index++; // Cho phép các lần xuất hiện chồng lên nhau
        }

        return count;
    }
}
