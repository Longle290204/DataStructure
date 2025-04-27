import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimeGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            for(int i = m; i <= n; i++) {
                if (isPrime(i)) {
                    System.out.println(i);
                }
            }
            System.out.println();
        }
    }

    private static boolean isPrime(int nume) {
        if (nume < 2) return false;
        if (nume == 2 || nume == 3) return true;
        if (nume % 2 == 0) return false;

        for(int i = 2; i * i <= nume; i += 2) {
            if (nume % i == 0) {
                return false;
            }
        }
        return true;
    }
}

// Lưu ý: Để xác định là một số nguyên tố thì số đó không được chia hết cho các số lẻ bé hơn căn bậc của chính nó
// VD: căn 49 = 7, thì 49 không được phép chia hết cho các số tính từ 3 tới 7


