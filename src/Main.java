import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws FileNotFoundException {

        try {
            System.setIn(new FileInputStream("input.txt"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);

        while (true) {
            int number = sc.nextInt();
            if (number == 42) {
               break;
            }
            System.out.println(number);
        }
    }
}
