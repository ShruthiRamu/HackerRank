import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps2{

    // Complete the minimumSwaps function below.
    /*
    5
    2 3 4 1 5

    o/p: 3

    You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates.
    You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort
    the array in ascending order.

    For example, given the array  we perform the following steps:

i   arr                         swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
It took 5 swaps to sort the array.

     */
    static int minimumSwaps(int[] arr) {
        int temp;
        int swaps=0;
        int n =arr.length;
        for (int i = 0; i < n; i++) {
            if(arr[i]==i+1) continue;
            swaps++;

            temp=arr[i];
            arr[i] = arr[temp-1];
            arr[temp-1] = temp;
            i--;
            System.out.println(Arrays.toString(arr));

        }
        return swaps;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        System.out.println("Enter the size of the array: \n");
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println("Enter the array of size " + n + "\n");
        int[] arr = new int[n];

        //String[] arrItems = scanner.nextLine().split("\n");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int res = minimumSwaps(arr);
        System.out.println(res);

        scanner.close();
    }
}
