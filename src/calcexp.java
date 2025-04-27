import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

    public class calcexp {
        public static void main(String[] args) throws FileNotFoundException {
            System.setIn(new FileInputStream("input.txt"));

            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();

            for(int i = 1; i <= N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                int j = 1;
                int result = 1;
                while (j <= b) {
                    result *= a ;
                    j++;
                }

                System.out.println("#" + i + " " + result);
            }
        }
    }
