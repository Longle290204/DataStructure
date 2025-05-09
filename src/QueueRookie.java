import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QueueRookie {

    static class Person {
        int height;
        int tallerInFront;

        Person(int height, int tallerInFront) {
            this.height = height;
            this.tallerInFront = tallerInFront;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while (T-- > 0) {
            int N = Integer.parseInt(sc.nextLine());
            int[] heights = new int[N];
            int[] front = new int[N];

            String[] heightStr = sc.nextLine().split(" ");
            String[] frontStr = sc.nextLine().split(" ");

            for (int i = 0; i < N; i++) {
                heights[i] = Integer.parseInt(heightStr[i]);
                front[i] = Integer.parseInt(frontStr[i]);
            }

            // Step 1: create people array
            Person[] people = new Person[N];
            for (int i = 0; i < N; i++) {
                people[i] = new Person(heights[i], front[i]);
            }

            // Step 2: sort by descending height
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (people[i].height < people[j].height) {
                        Person temp = people[i];
                        people[i] = people[j];
                        people[j] = temp;
                    }
                }
            }

            // Step 3: insert into result at index = tallerInFront
            int[] result = new int[N];
            for (int i = 0; i < N; i++) {
                int pos = people[i].tallerInFront;
                // shift right
                for (int j = N - 1; j > pos; j--) {
                    result[j] = result[j - 1];
                }
                result[pos] = people[i].height;
            }

            // Print result
            for (int i = 0; i < N; i++) {
                System.out.print(result[i]);
                if (i != N - 1) System.out.print(" ");
            }
            System.out.println();
        }

        sc.close();

    }
}
