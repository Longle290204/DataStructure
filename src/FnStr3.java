import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FnStr3 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            int N = Integer.parseInt(sc.nextLine());
            String s1 = sc.nextLine();
            System.out.println(s1);
            String s2 = sc.nextLine();
            System.out.println(s2);

            int index = 0;
            int cout = 0;

            while (s2.indexOf(s1, index) != -1) {
                cout++;
                index++;
            }

            System.out.println("#" + N + " " + cout);
        }
    }
}
