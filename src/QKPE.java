import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QKPE {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);
        int boardNumber = 1;

        while (true) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();

            if (rows == 0 && cols == 0) break;

            int[][] board = new int[rows + 1][cols + 1];

            // Đọc quân hậu (queen)
            int queens = sc.nextInt();

            // Setup 8 hướng cho quân hậu.
            // -1: trừ một hàng hoặc cột
            // 0: Hàng và cột không đổi
            // 1: Tăng một hàng và cột
            int[] drQ = {-1, -1, -1, 0, 0, 1, 1, 1};
            int[] dcQ = {-1, 0, 1, -1, 1, -1, 0, 1};

            // <============== Đánh dấu vị trí hậu ================>
            for (int i = 0; i < queens; i++) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                board[row][col] = 1;   // Đánh dấu vị trí quân hậu là 1
            }
            // <================================================>


            // <============== Đánh dấu vị trí mã ================>
            // Đọc quân mã
            int knights = sc.nextInt();
            int[] drK = {-2, -1, 1, 2, 2, 1, -1, -2};
            int[] dcK = {1, 2, 2, 1, -1, -2, -2, -1};
            for (int i = 0; i < knights; i++) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                board[row][col] = 2;   // Đánh dấu vị trí quân mã là 2
            }
            // <================================================>

            // <============== Đánh dấu vị trí tốt ================>
            int pawns = sc.nextInt();
            for (int i = 0; i < pawns; i++) {
                int row = sc.nextInt();
                int col = sc.nextInt();
                board[row][col] = 3;   // Đánh dấu vị trí quân tốt là 3
            }
            // <================================================>

            boolean[][] attacked = new boolean[rows + 1][cols + 1];
            for (int row = 1; row <= rows; row++) {
                for (int col = 1; col <= cols; col++) {
                    if (board[row][col] == 1) {   // Nếu là hậu thì duyệt hậu
                        for (int d = 0; d < 8; d++) {
                            int nr = row + drQ[d];
                            int nc = col + dcQ[d];
                            while (nr >= 1 && nr <= rows && nc >= 1 && nc <= cols) {
                                if (board[nr][nc] != 0) {   // Nếu vị trí này là một số (hậu, mã hoặc tốt) thì là bị chặn
                                    break;                  // => break
                                }
                                attacked[nr][nc] = true;
                                nr += drQ[d];
                                nc += dcQ[d];
                            }
                        }
                    } else if (board[row][col] == 2) {
                        for (int d = 0; d < 8; d++) {
                            int nr = row + drK[d];
                            int nc = col + dcK[d];
                            if (nr >= 1 && nr <= rows && nc >= 1 && nc <= cols) {
                                attacked[nr][nc] = true;
                            }
                        }
                    }
                }
            }

            // Đếm vị trí an toàn
            int isSafe = 0;
            for (int row = 1; row <= rows; row++) {
                for (int col = 1; col <= cols; col++) {
                    if (!attacked[row][col] && board[row][col] == 0) {
                        isSafe++;
                    }
                }
            }

            System.out.println("Board " + boardNumber + " has " + isSafe + " safe squares.");
            boardNumber++;
        }
    }
}

// Ý tưởng bài làm:
//
// B1: Tạo một mảng gồm row và col là các ký tự được đọc vào
// B2: Đếm số quân hậu, mã, tốt (là các kí tự đầu dòng của một testcase)
// B3: Đánh dấu vị trí các quân bằng số bất kỳ
// B4: Duyệt từng hàng, cột. Tiếp tục duyệt theo trường hợp hậu hoặc mã và đánh dấu theo 8 hướng.
// B5: Tạo matrix có tên attacked[][] và dánh dấu xem vị trí nào đúng theo hướng chạy của quân cờ thì đánh dấu là true
// B6: In ra số lượng ô trống bằng cách kiểm tra xem, nếu vị trí nào có !attacked[row][col] thì cộng đếm lên.
