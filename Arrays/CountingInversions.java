import java.io.IOException;
import java.util.Scanner;

public class CountingInversions {
    static long countInversions(int[] arr) {
    return 1L;

    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the number of test cases: \n");
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < t; i++) {
            System.out.println("Enter the size of the array for the test case: " + i);
            int n = scanner.nextInt();
            int[] q = new int[n];

            //String[] arrItems = scanner.nextLine().split("\n");
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println("Enter the array elements: ");
            for (int j = 0; j < n; j++) {
                q[j] = scanner.nextInt();
            }
            countInversions(q);
        }

        scanner.close();
    }
}
