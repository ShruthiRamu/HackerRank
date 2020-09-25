import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps2{

    // Complete the minimumSwaps function below.
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
