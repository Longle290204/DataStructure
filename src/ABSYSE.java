import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ABSYSE {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            String line = sc.nextLine();
            while (line.isEmpty()) { // bỏ qua dòng trống
                line = sc.nextLine();
            }

            String[] parts = line.split(" ");

                if(parts[0].contains("machula") ) {
                    int b = Integer.parseInt(parts[2]);
                    int c = Integer.parseInt(parts[4]);
                    parts[0] = Integer.toString(c - b);
                }
                else if (parts[2].contains("machula")) {
                    int a = Integer.parseInt(parts[0]);
                    int c = Integer.parseInt(parts[4]);
                    parts[2] = Integer.toString(c - a);
                }
                else if (parts[4].contains("machula")) {
                    int a = Integer.parseInt(parts[0]);
                    int b = Integer.parseInt(parts[2]);
                    parts[4] = Integer.toString(a + b);
                }

            System.out.println(parts[0] + " + " + parts[2] + " = " + parts[4]);
        }
    }
}
