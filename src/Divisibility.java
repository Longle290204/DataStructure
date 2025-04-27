import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Divisibility {
    public static void main(String [] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();


           for(int j = 1; j < n; j++) {
               if (j % x == 0 && j % y != 0) {
                   System.out.print(j + " ");

               }

           }

           System.out.println();
        }
    }
}
