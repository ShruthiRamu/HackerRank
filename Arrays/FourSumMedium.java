import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FourSumMedium {
    /*
    Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

Example:

Input:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

Output:
2

Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
     */

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> E = new HashMap<Integer, Integer>();
        for (int a: A) {
            for (int b: B) {
                E.put(a+b, E.getOrDefault(a+b, 0) + 1);
            }
        }
        int count = 0;

        for (int c: C) {
            for (int d: D) {
                count += E.getOrDefault(-c-d, 0);
            }
        }

        return count;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the size of the arrays: \n");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];


        System.out.println("Enter the array of size " + n + "\n");

        //String[] arrItems = scanner.nextLine().split("\n");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                A[i] = scanner.nextInt();
            }
        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            C[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            D[i] = scanner.nextInt();
        }




        int res = fourSumCount(A,B,C,D);
        System.out.println(res);


        scanner.close();
    }
}
