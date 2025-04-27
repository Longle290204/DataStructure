import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ToAndFro {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        while (true) {
            int cols = sc.nextInt();       // cols = 5
            if (cols == 0) {
                break;
            }

            String s = sc.next();
            int rows = s.length() / cols;  // rows = 35

            // Tạo mảng 2 chiều để lưu zigzagẻ
            char[][] matrix = new char[rows][cols];

            int index = 0;
            for (int row = 0; row < rows; row++) {
                if (row % 2 == 0) {
                    for (int col = 0; col < cols; col++) {
                        matrix[row][col] = s.charAt(index++);
                    }
                }
                else {
                    for (int col = cols - 1; col >= 0; col--) {
                        matrix[row][col] = s.charAt(index++);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < cols; col++) {
                for (int row = 0; row < rows; row++) {
                    sb.append(matrix[row][col]);
                }
            }
            System.out.println(sb);

        }
    }

//    public static void reverse(String[] row) {
//        int left = 0;
//        int right = row.length - 1;
//
//        while (left < right) {
//            String temp = row[left];
//            row[left] = row[right];
//            row[right] = temp;
//
//            left++;
//            right--;
//        }
//    }
}
