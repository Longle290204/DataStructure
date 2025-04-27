import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FnStr {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);


        while (sc.hasNextLine()) {
            int N = sc.nextInt();  // 1
            sc.nextLine();
            String needFn = sc.nextLine();  // ab
            String str = sc.nextLine().replaceAll("\\s+", "");

            int cout = 0;
            for (int i = 0; i <= str.length() - needFn.length(); i++) {
                String pair = str.substring(i, i + needFn.length());
                if (pair.equals(needFn)) {
                    cout++;
                }
            }
            System.out.println("#" + N + " " + cout);
        }
        sc.close();
    }
}
